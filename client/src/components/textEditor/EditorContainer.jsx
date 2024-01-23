import React from 'react'

import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css'
import { Editor } from 'react-draft-wysiwyg'
import { convertToRaw } from 'draft-js'


function EditorContainer(props) {

   if (props.isLoading) {
       return <div>Loading...</div>
   }

   const handleSubmit = (e) => {
       e.preventDefault()
       console.log(props.postInfo)
   }


  return (
      <div>
          {/* <form onSubmit={(e) => handleSubmit(e)}>
              <div>
                  <label htmlFor="fname">Tittle *</label>
                  <input
                      value={props.postInfo.tittle}
                      id="fname"
                      type="text"
                      required
                      onChange={(e) => props.handleOnChange(e, 'tittle')}
                  />

                  <label htmlFor="fheadline">Headline *</label>
                  <input
                      value={props.postInfo.headline}
                      id="fheadline"
                      type="text"
                      required
                      onChange={(e) => props.handleOnChange(e, 'headline')}
                  />

                  <label htmlFor="fimage">Front image *</label>
                  <input
                      id="fimage"
                      type="file"
                      accept="image/jpeg"
                      required
                      onChange={(e) => props.handleOnChange(e, 'image')}
                  />

                  <label htmlFor="fsynthesis">Synthesis *</label>
                  <input
                      value={props.postInfo.synthesis}
                      id="fsynthesis"
                      type="text"
                      required
                      onChange={(e) => props.handleOnChange(e, 'synthesis')}
                  />
              </div>
          </form> */}
          <div>
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
          </div>
          {/* <div>
              <div>
                  <button
                      onClick={(e) => props.savePost('draft')}
                      formnovalidate
                  >
                      Save Draft
                  </button>
                  <button onClick={(e) => props.discardPost()} formnovalidate>
                      Discard
                  </button>
              </div>
              <button onClick={(e) => props.savePost('completed')}>Post</button>
          </div> */}
          <button
              onClick={(e) => {
                  console.log(
                      JSON.stringify(
                          convertToRaw(props.editorState.getCurrentContent())
                      )
                  )
              }}
          >
              print to console
          </button>
      </div>
  )
}

export default EditorContainer