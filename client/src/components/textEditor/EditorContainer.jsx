import React from 'react'
import { EditorState } from 'draft-js'
import { Editor } from 'react-draft-wysiwyg'

import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css'

function EditorContainer() {
  const [editorState, setEditorState] = React.useState(() =>
      EditorState.createEmpty()
  )

  return (
      <Editor editorState={editorState} onEditorStateChange={setEditorState} />
  )
}

export default EditorContainer