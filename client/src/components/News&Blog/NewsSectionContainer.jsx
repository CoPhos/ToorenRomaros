import React from 'react'
import NewsSection from './NewsSection'

function NewsSectionContainer(props) {
  return (
      <NewsSection
          slides={props.slides}
          dimension={props.dimension}
          belowText={props.belowText}
          gradient={props.gradient}
          insideText={props.insideText}
          border={props.border}
          rating={props.rating}
          sizes={props.sizes}
      ></NewsSection>
  )
}

export default NewsSectionContainer