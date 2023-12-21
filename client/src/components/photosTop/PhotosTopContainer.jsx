import React from 'react'
import Carousel from 'react-elastic-carousel'
import {Link} from 'react-router-dom'

function PhotosTopContainer() {
    const breakPointsMovie = [
        { width: 1, itemsToShow: 2, itemsToScroll: 2 },
        { width: 408, itemsToShow: 3, itemsToScroll: 3 },
        { width: 550, itemsToShow: 4, itemsToScroll: 3 },
        { width: 672, itemsToShow: 5, itemsToScroll: 3 },
        { width: 768, itemsToShow: 4, itemsToScroll: 4 },
        { width: 880, itemsToShow: 5, itemsToScroll: 3 },
        { width: 1070, itemsToShow: 6, itemsToScroll: 5 },
    ]
  return (
      <div className='relative mt-2'>
          <Carousel
              disableArrowsOnEnd={true}
              enableMouseSwipe={false}
              itemPadding={[0, 4, 0, 4]}
              pagination={false}
              breakPoints={breakPointsMovie}
          >
              <Link to={'/film'}>
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://images.squarespace-cdn.com/content/v1/5f0eef7fdf92a846778e73d3/1623841814050-LKZLQ6OLKT455K9T607I/tokyo+drift.jpeg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
              <Link to="/asdasdbv">
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://images.tntdrama.com/tnt/$dyna_params/https%3A%2F%2Fi.cdn.tntdrama.com%2Fassets%2Fimages%2F2020%2F04%2FTokyoDrift-2048x1536.jpg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
              <Link to="/asdasdbv">
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://ew.com/thmb/le-W0Q9L0HwVn2ZbixAh9LDUj9g=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/tokyo-drift-97c114fa96c5415989804976ce982a40.jpg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
              <Link to="/asdasdbv">
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://depor.com/resizer/9qhCOStINVR8X_QMBHRuWA-ytXY=/580x330/smart/filters:format(jpeg):quality(90)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/XQRDSSKUZ5HIDCCKYETFHL35AU.jpg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
              <Link to={'/film'}>
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://images.squarespace-cdn.com/content/v1/5f0eef7fdf92a846778e73d3/1623841814050-LKZLQ6OLKT455K9T607I/tokyo+drift.jpeg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
              <Link to="/asdasdbv">
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://images.tntdrama.com/tnt/$dyna_params/https%3A%2F%2Fi.cdn.tntdrama.com%2Fassets%2Fimages%2F2020%2F04%2FTokyoDrift-2048x1536.jpg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
              <Link to="/asdasdbv">
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://ew.com/thmb/le-W0Q9L0HwVn2ZbixAh9LDUj9g=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/tokyo-drift-97c114fa96c5415989804976ce982a40.jpg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
              <Link to="/asdasdbv">
                  <img
                      //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                      src="https://depor.com/resizer/9qhCOStINVR8X_QMBHRuWA-ytXY=/580x330/smart/filters:format(jpeg):quality(90)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/XQRDSSKUZ5HIDCCKYETFHL35AU.jpg"
                      alt="Elva dressed as a fairy"
                      className="w-[178px] h-[178px] object-cover object-center group-hover:opacity-75"
                  />
              </Link>
          </Carousel>
      </div>
  )
}

export default PhotosTopContainer