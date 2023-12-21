import React, {useState} from 'react'
import PostRatingContainer from './PostRatingContainer';

function PostRatingManager() {
   const [formData, setFormData] = useState({
      text: '',
      spoiler: false,
   })

   const handleChange = (e) => {
       const { name, value } = e.target
       setFormData((prevData) => ({
           ...prevData,
           [name]: value,
       }))
   }

   const handleSubmit = (e) => {
       e.preventDefault()
       console.log('Form submitted:', formData)
   }

  return (
    <PostRatingContainer formData={formData} handleChange={handleChange} handleSubmit={handleSubmit}></PostRatingContainer>
  )
}

export default PostRatingManager