import React, { useState, useRef } from 'react'

function VideoContainer() {
    const videoRef = useRef(null)
    const [isPlaying, setIsPlaying] = useState(false)

    const togglePlay = () => {
        if (videoRef.current.paused) {
            videoRef.current.play()
        } else {
            videoRef.current.pause()
        }
        setIsPlaying(!isPlaying)
    }

    return (
        <div className="flex flex-row w-full">
            <video
                ref={videoRef}
                controls
                onClick={togglePlay}
                autoPlay={false}
                muted
                className="w-full h-auto rounded-md"
            >
                <source
                    src="https://video.internetvideoarchive.net/video.mp4?cmd=6&fmt=4&customerid=654126&publishedid=550987&e=2208902400&videokbrate=1500&h=09406aa09769643a160c009b28e19411"
                    type="video/mp4"
                />
                Your browser does not support the video tag.
            </video>
        </div>
    )
}

export default VideoContainer
