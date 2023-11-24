import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom'

import EditorContainer from './EditorContainer'

import { SERVER_URL } from '../../utils/constants'
import { EditorState, convertFromRaw, convertToRaw } from 'draft-js'


function EditorManager() {
    const history = useHistory()
    const [editorState, setEditorState] = useState(EditorState.createEmpty())
    const [isLoading, setIsLoading] = useState(false)
    const [postId, setpostId] = useState('0')
    const [postInfo, setPostInfo] = useState({
        tittle: '',
        headline: '',
        synthesis: '',
        image: ''
    })

    useEffect(() => {
        createNewPost()
    }, [])

    function handleOnChange(e, key){
        if(key == 'image'){
            setPostInfo({ ...postInfo, [key]: e.target.files[0] })
        }else{
            setPostInfo({ ...postInfo, [key]: e.target.value })
        }
    }

    async function createNewPost() {
        setIsLoading(true)
        const demoUserId = 'b7a61937-6f59-4bbb-80a7-08d65d1ad656'

        fetch(SERVER_URL + '/posts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                user: demoUserId,
                publicationDateTime: new Date().toISOString(),
                status: 'inDevelop',
            }),
        })
            .then(async (response) => {
                const data = await response.json()
                if (!response.ok) {
                    //const error = (data && data.message) || response.status
                    //setError(error)
                } else {
                    console.log(data.created.id)
                    setpostId(data.created.id)
                    setIsLoading(false)
                }
            })
            .catch((error) => {
                console.error('There was an error!', error)
            })
    }

    async function uploadImageCallback(file) {
        return new Promise((resolve, reject) => {
            const formData = new FormData()
            formData.append('image', file)
            formData.append('imageType', 'postContent')

            fetch(SERVER_URL + '/RT/' + postId + '/image', {
                method: 'POST',
                body: formData,
            })
                .then(async (response) => {
                    const data = await response.json()
                    if (!response.ok) {
                        //const error = (data && data.message) || response.status
                        //setError(error)
                    } else {
                        resolve({
                            data: {
                                link:
                                    SERVER_URL +
                                    '/images/' +
                                    data.created.Desktop,
                            },
                        })
                    }
                })
                .catch((error) => {
                    console.error('There was an error!', error)
                })
        })
    }

    async function discardPost() {
        fetch(SERVER_URL + '/posts/' + postId, { method: 'DELETE' })
            .then(async (response) => {
                //const data = await response.json()
                if (!response.ok) {
                    //const error = (data && data.message) || response.status
                }
                else{
                    history.replace('/')
                }
                
            })
            .catch((error) => {
                console.error('There was an error!', error)
            })
    }

    async function savePost(postStatus){
        setIsLoading(true)

        let requestPost = fetch(SERVER_URL + '/posts/' + postId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                tittle: postInfo.tittle,
                headline: postInfo.headline,
                synthesis: postInfo.synthesis,
                content: JSON.stringify(
                    convertToRaw(editorState.getCurrentContent())
                ),
                status: postStatus,
            }),
        });
        
        let requests = [requestPost]
        
        if(postInfo.image instanceof File){
            const formData = new FormData()
            formData.append('image', postInfo.image)
            formData.append('imageType', 'postMain')

            let requestImage = fetch(SERVER_URL + '/RT/' + postId + '/image', {
                method: 'POST',
                body: formData,
            })

            requests.push(requestImage)
        }

        await Promise.all(requests)
            .then(()=>{
                setIsLoading(false)
                history.replace('/')
            })
            .catch((error) => console.error(error))
    }

  return (
      <EditorContainer
          isLoading={isLoading}
          editorState={editorState}
          setEditorState={setEditorState}
          uploadImageCallback={uploadImageCallback}
          discardPost={discardPost}
          savePost={savePost}
          postInfo={postInfo}
          handleOnChange={handleOnChange}
      ></EditorContainer>
  )
}

export default EditorManager



// const rawcontentExmaple = {
//     blocks: [
//         {
//             key: '954lm',
//             text: 'fghghfgh',
//             type: 'unstyled',
//             depth: 0,
//             inlineStyleRanges: [],
//             entityRanges: [],
//             data: {},
//         },
//         {
//             key: '9mnpp',
//             text: ' ',
//             type: 'atomic',
//             depth: 0,
//             inlineStyleRanges: [],
//             entityRanges: [{ offset: 0, length: 1, key: 0 }],
//             data: {},
//         },
//         {
//             key: 'a2vp6',
//             text: '',
//             type: 'unstyled',
//             depth: 0,
//             inlineStyleRanges: [],
//             entityRanges: [],
//             data: {},
//         },
//         {
//             key: '2bnie',
//             text: ' ',
//             type: 'atomic',
//             depth: 0,
//             inlineStyleRanges: [],
//             entityRanges: [{ offset: 0, length: 1, key: 1 }],
//             data: {},
//         },
//         {
//             key: '2qn14',
//             text: '',
//             type: 'unstyled',
//             depth: 0,
//             inlineStyleRanges: [],
//             entityRanges: [],
//             data: {},
//         },
//     ],
//     entityMap: {
//         0: {
//             type: 'IMAGE',
//             mutability: 'MUTABLE',
//             data: {
//                 src: 'http://localhost:9090/api/v1/images/e08f812f-7dc2-4907-8f44-00c362411eda',
//                 height: 'auto',
//                 width: 'auto',
//                 alt: 'g',
//             },
//         },
//         1: {
//             type: 'IMAGE',
//             mutability: 'MUTABLE',
//             data: {
//                 src: 'http://localhost:9090/api/v1/images/52e50401-51f0-4468-b91c-957dec0a833f',
//                 height: 'auto',
//                 width: 'auto',
//                 alt: 'g',
//             },
//         },
//     },
// }