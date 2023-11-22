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
        synthesis: ''
    })

    useEffect(() => {
        createNewPost()
    }, [])

    function handleOnChange(e, key){
        setPostInfo({ ...postInfo, [key]: e.target.value })
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

        fetch(SERVER_URL + '/posts/' + postId, {
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
        })
            .then(async (response) => {
                const data = await response.json()
                if (!response.ok) {
                    //const error = (data && data.message) || response.status
                    //setError(error)
                } else {
                    console.log(data)
                    setIsLoading(false)
                    history.replace('/')
                }
            })
            .catch((error) => {
                console.error('There was an error!', error)
            })
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