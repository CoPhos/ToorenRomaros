import React from 'react'

import styled from 'styled-components'

import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css'
import { Editor } from 'react-draft-wysiwyg'


function EditorContainer(props) {

   if (props.isLoading) {
       return <div>Loading...</div>
   }

  return (
      <Wrapper>
          <ContainerForm>
              <ContainerInputs>
                  <label htmlFor="fname">Tittle *</label>
                  <StyledInput id="fname" type="text" required />

                  <label htmlFor="fheadline">Headline *</label>
                  <StyledInput id="fheadline" type="text" required />

                  <label htmlFor="fsynthesis">Synthesis *</label>
                  <StyledInput id="fsynthesis" type="text" required />
              </ContainerInputs>
          </ContainerForm>
          <ContainerEditor>
              <Editor
                  editorStyle={{ border: '1px solid #F1F1F1' }}
                  editorState={props.editorState}
                  onEditorStateChange={props.setEditorState}
                  placeholder=" Tell a story..."
                  toolbar={{
                      image: {
                          uploadCallback: (file) =>
                              props.uploadImageCallback(file),
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
          <ContainerButtons>
              <ContainerSaveDiscard>
                  <SaveButton>Save Draft</SaveButton>
                  <DiscardButton
                      onClick={(e) => props.discardPost()}
                      formnovalidate
                  >
                      Discard
                  </DiscardButton>
              </ContainerSaveDiscard>
              <PostButton>Post</PostButton>
          </ContainerButtons>
      </Wrapper>
  )
}

const Wrapper = styled.form`
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
`

const ContainerEditor = styled.div`
    width: 80%;
    margin: 16px 0;
`
const ContainerForm = styled.div`
    width: 80%;
    margin-top: 8px;
`

const ContainerInputs = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: start;
    width: 100%;
    gap: 8px;
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

const ContainerButtons = styled.div`
    display: flex;
    flex-direction: column;
    gap: 8px;
    aling-items: center;
    justify-content: flex-start;
    width: 80%;
`

const ContainerSaveDiscard = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-end;
    gap: 16px;
`

const PostButton = styled.button`
    width: 100%;
    height: 32px;
    background-color: ${(props) => props.theme.colors.secondary};
    border: none;
    color: white;
    border-radius: 4px;
    &:hover {
        cursor: pointer;
        background-color: ${(props) => props.theme.colors.secondaryHover};
    }
`
const SaveButton = styled.button`
    height: 32px;
    padding: 0 16px;
    background-color: ${(props) => props.theme.colors.green};
    border: none;
    color: white;
    border-radius: 4px;
    &:hover {
        cursor: pointer;
        background-color: ${(props) => props.theme.colors.greenHover};
    }
`
const DiscardButton = styled(SaveButton)`
    background-color: ${(props) => props.theme.colors.red};
    &:hover {
        
        background-color: ${(props) => props.theme.colors.redHover};
    }
`


export default EditorContainer