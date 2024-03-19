import React, { useState, useEffect, useContext } from 'react'
import { useSearchParams, useParams, useNavigate } from 'react-router-dom'
import { useQuery, useMutation, useQueryClient } from 'react-query'
import { EditorState, convertFromRaw, convertToRaw } from 'draft-js'
import useAuth from '../hooks/useAuth'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import ErrorBoundary from '../../utils/ErrorBoundary'
import { ActionNotificationContext } from '../context/ActionNotificationProvider'

import EditorContainer from './EditorContainer'
import { data } from 'autoprefixer'
function EditorManager() {
    const { auth } = useAuth()
    const axiosPrivate = useAxiosPrivate()
    const params = useParams()
    const navigate = useNavigate()
    const queryClient = useQueryClient()
    const [searchParams, setSearchParams] = useSearchParams()
    const [editorState, setEditorState] = useState(EditorState.createEmpty())
    const [postId, setpostId] = useState(null)
    const [postInfo, setPostInfo] = useState({
        tittle: '',
        headline: '',
        synthesis: '',
        image: '',
        tag: '',
    })
    const [validtittle, setvalidtittle] = useState(false)
    const [validheadline, setvalidheadline] = useState(false)
    const [validsynthesis, setvalidsynthesis] = useState(false)
    const [validimage, setvalidimage] = useState(false)
    const [validtag, setvalidtag] = useState(false)
    const [buttonsEnable, setbuttonsEnable] = useState(true)

    const edit = searchParams.get('edit') || ''

    const isValidUUID = (str) => {
        const uuidRegex =
            /^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$/
        return uuidRegex.test(str)
    }

    const { setnotificationText, settype, setisNotificationPopupOpen } =
        useContext(ActionNotificationContext)

    function handleDiscardPost(event) {
        event.preventDefault()
        setbuttonsEnable(false)
        discardPost.mutate()
        navigate('/', { replace: true })
    }

    function handleOnChange(e, key) {
        if (key == 'image') {
            setPostInfo({ ...postInfo, [key]: e.target.files[0] })
        } else {
            setPostInfo({ ...postInfo, [key]: e.target.value })
        }
    }

    const getExistingPost = useQuery({
        queryKey: ['getExistingPost', auth.id],
        queryFn: async () => {
            try {
                return axiosPrivate.get(`/posts/${edit}`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            setpostId(data?.data?.response?.id)
            setPostInfo({
                tittle: data?.data?.response?.tittle,
                headline: data?.data?.response?.headline,
                synthesis: data?.data?.response?.synthesis,
                tag: data?.data?.response?.tag,
            })
            setEditorState(
                EditorState.createWithContent(
                    convertFromRaw(JSON.parse(data?.data?.response?.content))
                )
            )
            setnotificationText('Post Loaded Successfully.')
            settype('success')
            setisNotificationPopupOpen(true)
        },
        onError: (error) => {
            settype('error')
            setnotificationText(
                error?.response?.data?.message || 'No server response'
            )
            setisNotificationPopupOpen(true)
        },
        enabled: !!edit && isValidUUID(edit),
    })

    const createNewPost = useQuery({
        queryKey: ['createNewPost', auth.id],
        queryFn: async () => {
            try {
                return axiosPrivate.post(
                    `/posts`,
                    JSON.stringify({
                        user: auth.id,
                        film: params.uuid,
                        status: 'draft',
                        tag: '20c9127b-79d5-485a-8e59-c14a3dc8a777',
                        publicationDateTime: new Date().toISOString(),
                    })
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            setpostId(data?.data?.response?.id)
            setnotificationText('New Post Created Successfully.')
            settype('success')
            setisNotificationPopupOpen(true)
        },
        onError: (error) => {
            settype('error')
            setnotificationText(
                error?.response?.data?.message || 'No server response'
            )
            setisNotificationPopupOpen(true)
        },
        enabled: !!!edit,
    })

    const discardPost = useMutation({
        mutationKey: ['discardPost', auth.id],
        mutationFn: async () => {
            try {
                return axiosPrivate.delete(`/posts/${postId}`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            navigate('/', { replace: true })
            setnotificationText('Post Deleted Successfully.')
            settype('success')
            setisNotificationPopupOpen(true)
        },
        onError: (error) => {
            settype('error')
            setnotificationText(
                error?.response?.data?.message || 'No server response'
            )
            setisNotificationPopupOpen(true)
            setbuttonsEnable(true)
        },
    })

    const savePost = useMutation({
        mutationKey: ['savePost', auth.id],
        mutationFn: async (postStatus) => {
            return axiosPrivate.patch(`/posts/${postId}`, {
                tittle: postInfo.title ? postInfo.title : "Draft without title",
                headline: postInfo.headline,
                synthesis: postInfo.synthesis,
                content: JSON.stringify(
                    convertToRaw(editorState.getCurrentContent())
                ),
                status: postStatus,
                tag: postInfo.tag,
                publicationDateTime: new Date(),
            })
        },
        onSuccess: (data) => {
            setnotificationText('Post Saved.')
            settype('success')
            setisNotificationPopupOpen(true)
        },
        onError: (error) => {
            settype('error')
            setnotificationText(
                error?.response?.data?.message || 'No server response'
            )
            setisNotificationPopupOpen(true)
        },
    })

    const saveImage = useMutation({
        mutationKey: ['saveImage', auth.id],
        mutationFn: async (formData) => {
            return axiosPrivate.post(`/posts/images`, formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            })
        },
        onSuccess: (data) => {},
        onError: (error) => {
            settype('error')
            setnotificationText(
                error?.response?.data?.message || 'No server response'
            )
            setisNotificationPopupOpen(true)
        },
    })

    async function handlesavePost(postStatus) {
        if (
            (validtittle &&
                validheadline &&
                validsynthesis &&
                (validimage ||
                    getExistingPost.data?.data?.response?.mainImageId) &&
                validtag) ||
            postStatus == 'DRAFT'
        ) {
            try {
                setbuttonsEnable(false)
                const requests = [savePost.mutateAsync(postStatus)]
                if (postInfo.image instanceof File) {
                    const formData = new FormData()
                    formData.append('image', postInfo.image)
                    formData.append('imageType', 'POST_MAIN')
                    formData.append('id', postId)
                    requests.push(saveImage.mutateAsync(formData))
                }
                const results = await Promise.all(requests)
                const allMutationsSucceeded = results.every(
                    (result) => !result.error
                )

                if (allMutationsSucceeded) {
                    navigate('/', { replace: true })
                } else {
                    setbuttonsEnable(true)
                }
            } catch (error) {}
        }
    }

    async function uploadImageCallback(file) {
        return new Promise((resolve, reject) => {
            console.log(postId)
            const formData = new FormData()
            formData.append('image', file)
            formData.append('id', postId)
            formData.append('imageType', 'POST_COLLECTION')
            
            fetch('http://localhost:9090/api/v1/posts/images', {
                method: 'POST',
                body: formData,
            })
                .then(async (response) => {
                    const data = await response.json()
                    if (!response.ok) {
                        settype('error')
                        setnotificationText('Something went wrong!')
                        setisNotificationPopupOpen(true)
                    } else {
                        resolve({
                            data: {
                                link:
                                    'http://localhost:9090/api/v1' +
                                    '/images/' +
                                    data.response['960x880'],
                            },
                        })
                    }
                })
                .catch((error) => {})
        })
    }
    useEffect(() => {
        history.pushState(null, document.title, location.href)
        const handleBeforeUnload = (event) => {
            const message = 'Are you sure you want to leave?'
            event.returnValue = message
            return message
        }

        const handlePopState = (event) => {
            if (!event.persisted) {
                const shouldLeave = window.confirm(
                    'Are you sure you want to leave?'
                )
                if (shouldLeave) {
                    if (!edit) discardPost.mutate()
                }
            }
        }

        const handleLinkClick = (event) => {
            const shouldLeave = window.confirm(
                'Are you sure you want to leave?'
            )
            if (shouldLeave) {
                if (!edit) discardPost.mutate()
            } else {
                event.preventDefault()
            }
        }

        window.addEventListener('beforeunload', handleBeforeUnload)
        window.addEventListener('popstate', handlePopState)

        const links = document.querySelectorAll('a')
        links.forEach((link) => link.addEventListener('click', handleLinkClick))

        return () => {
            window.removeEventListener('beforeunload', handleBeforeUnload)
            window.removeEventListener('popstate', handlePopState)

            links.forEach((link) =>
                link.removeEventListener('click', handleLinkClick)
            )
        }
    }, [])
    

    useEffect(() => {
        setvalidtittle(postInfo.tittle.length <= 255)
    }, [postInfo.tittle])

    useEffect(() => {
        setvalidheadline(postInfo.headline.length <= 255)
    }, [postInfo.headline])
    useEffect(() => {
        setvalidimage(postInfo.image)
    }, [postInfo.image])
    useEffect(() => {
        setvalidsynthesis(postInfo.synthesis.length <= 1000)
    }, [postInfo.synthesis])
    useEffect(() => {
        setvalidtag(postInfo.tag.length > 1)
    }, [postInfo.tag])
 
    const display =
        createNewPost.data?.data?.response?.id ||
        getExistingPost.data?.data?.response?.id
    
    return (
        <ErrorBoundary>
            {display ? (
                <EditorContainer
                    editorState={editorState}
                    setEditorState={setEditorState}
                    uploadImageCallback={uploadImageCallback}
                    discardPost={discardPost}
                    handlesavePost={handlesavePost}
                    postInfo={postInfo}
                    handleOnChange={handleOnChange}
                    validtittle={validtittle}
                    validheadline={validheadline}
                    validimage={validimage}
                    validsynthesis={validsynthesis}
                    validtag={validtag}
                    handleDiscardPost={handleDiscardPost}
                    mainImage={
                        getExistingPost.data?.data?.response?.mainImageId || ''
                    }
                    buttonsEnable={buttonsEnable}
                ></EditorContainer>
            ) : (
                ''
            )}
        </ErrorBoundary>
    )
}

export default EditorManager
