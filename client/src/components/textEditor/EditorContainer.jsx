import React, {useState, useEffect} from 'react'
import { EditorState } from 'draft-js'
import { Editor } from 'react-draft-wysiwyg'
import { SERVER_URL } from '../../utils/constants'


import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css'

function EditorContainer() {
  const [editorState, setEditorState] = useState(EditorState.createEmpty())
  const [isLoading, setIsLoading] = useState(false)
  const [postId, setpostId] = useState('0')

  useEffect(() => {
    createNewPost()
  }, [])

  function createNewPost() {
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
        .then((response) => response.json())
        .then((data) => {
          console.log(data.created.id) 
          setpostId(data.created.id)
          setIsLoading(false)
        })
        .catch((error) => {
            console.error('Error:', error)
        })
  }

  function uploadImageCallback(file){
    return new Promise((resolve, reject) => {
      const formData = new FormData()
      formData.append('image', file)
      formData.append('imageType', 'postContent')
      fetch(SERVER_URL + '/RT/' + postId + '/image', {
          method: 'POST',
          body: formData,
      })/* working on */
          .then((response) => response.json())
          .then((data) => {
              resolve({
                  data: {
                      link:
                          SERVER_URL +
                          'images/' + data,
                  },
              })
          })
          .catch((error) => {
              console.error('Error:', error)
              reject(error)
          })
    })
  }

   if (isLoading) {
       return <div>Loading...</div>
   }

  return (
      <Editor
          editorState={editorState}
          onEditorStateChange={setEditorState}
          placeholder="Tell a story..."
          toolbar={{
              image: {
                  uploadCallback: (file) => uploadImageCallback(file),
                  alt: { present: true, mandatory: true },
                  urlEnabled: true,
              },
          }}
      />
  )
}

export default EditorContainer