import React, {useState} from 'react'
import PostRatingContainer from './PostRatingContainer';

function PostRatingManager() {
   const [formData, setFormData] = useState({
      text: '',
   })
   const [isChecked, setIsChecked] = useState(false)

   const handleCheckboxChange = () => {
       setIsChecked((prevChecked) => !prevChecked)
   }

   const handleChange = (e) => {
       const { name, value } = e.target
       setFormData((prevData) => ({
           ...prevData,
           [name]: value,
       }))
   }

   const handleSubmit = (e) => {
       e.preventDefault()
       console.log('Form submitted:', formData + isChecked)
   }

  return (
      <PostRatingContainer
          formData={formData}
          handleChange={handleChange}
          handleSubmit={handleSubmit}
          handleCheckboxChange={handleCheckboxChange}
      ></PostRatingContainer>
  )
}

export default PostRatingManager