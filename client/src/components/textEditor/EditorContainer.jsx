import React, {useState, useEffect} from 'react'

import styled from 'styled-components'

import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css'
import { EditorState } from 'draft-js'
import { Editor } from 'react-draft-wysiwyg'
import { SERVER_URL } from '../../utils/constants'

function EditorContainer() {
  const [editorState, setEditorState] = useState(EditorState.createEmpty())
  const [isLoading, setIsLoading] = useState(false)
  const [postId, setpostId] = useState('0')

  const [inputValue, setInputValue] = useState('')

  const handleInputChange = (event) => {
      setInputValue(event.target.value)
  }

  const handleSubmit = (event) => {
      event.preventDefault()
      console.log(inputValue)
  }

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
      })
          .then((response) => response.json())
          .then((data) => {
              resolve({
                  data: {
                      link: SERVER_URL + '/images/' + data.created.Desktop,
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
      <Wrapper>
          <ContainerForm>
              <form>
                  <ContainerInputs>
                      <label htmlFor="fname">Tittle *</label>
                      <StyledInput id="fname" type="text"  value={inputValue} onChange={handleInputChange}/>

                      <label htmlFor="fheadline">Headline *</label>
                      <StyledInput id="fheadline" type="text" />

                      <label htmlFor="fsynthesis">Synthesis *</label>
                      <StyledInput id="fsynthesis" type="text" />
                  </ContainerInputs>
              </form>
          </ContainerForm>
          <ContainerEditor>
              <Editor
                  editorStyle={{ border: '1px solid #F1F1F1' }}
                  editorState={editorState}
                  onEditorStateChange={setEditorState}
                  placeholder="    Tell a story..."
                  toolbar={{
                      image: {
                          uploadCallback: (file) => uploadImageCallback(file),
                          alt: { present: true, mandatory: true },
                          urlEnabled: true,
                      },
                      options: [
                          'inline',
                          'blockType',
                          'fontSize',
                          'fontFamily',
                          'list',
                          'textAlign',
                          'colorPicker',
                          'link',
                          'emoji',
                          'image',
                          'remove',
                          'history',
                      ],
                  }}
              />
          </ContainerEditor>
      </Wrapper>
  )
}

const Wrapper = styled.div`
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
`

const ContainerEditor = styled.div`
    width: 80%;
`
const ContainerForm = styled.div`
    width: 80%;
`

const ContainerInputs = styled.div`
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: start;
    
`

const StyledInput = styled.input`
    width: 100%;
    border: 1px solid #f1f1f1;
    padding: 8px 8px;
    outline: none;
    &:focus {
        border: 2px solid #bfbfbf;
    }
`

export default EditorContainer