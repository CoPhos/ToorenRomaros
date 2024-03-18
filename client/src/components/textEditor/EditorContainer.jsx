import React, { useState, useRef, useEffect, Fragment } from 'react'

import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css'
import { Editor } from 'react-draft-wysiwyg'
import { BASE_URL } from '../../utils/constants'

import SortPanel from '../cards/browse/SortPanel'

function EditorContainer(props) {
    const tagRadioButtonData = {
        0: { text: 'Actor Spotlight', value: 'Actor Spotlight' },
        1: { text: 'Behind The Camera', value: 'Behind The Camera' },
        2: { text: 'Behind The Scenes', value: 'Behind The Scenes' },
        3: { text: 'Cast And Crew', value: 'Cast And Crew' },
        4: { text: 'Character Insight', value: 'Character Insight' },
        5: { text: 'Character Study', value: 'Character Study' },
        6: { text: 'Cinematic Experience', value: 'Cinematic Experience' },
        7: { text: 'Cinematic Perspective', value: 'Cinematic Perspective' },
        8: { text: 'Commentary Track', value: 'Commentary Track' },
        9: { text: 'Director Commentary', value: 'Director Commentary' },
        10: { text: 'Director Diaries', value: 'Director Diaries' },
        11: { text: 'Director Interview', value: 'Director Interview' },
        12: { text: 'Episode Discussion', value: 'Episode Discussion' },
        13: { text: 'Exclusive Interview', value: 'Exclusive Interview' },
        14: { text: 'Film Analysis', value: 'Film Analysis' },
        15: { text: 'Film Club', value: 'Film Club' },
        16: { text: 'Film Crew', value: 'Film Crew' },
        17: { text: 'Film Discussion', value: 'Film Discussion' },
        18: { text: 'Film maker Talk', value: 'Film maker Talk' },
        19: { text: 'Movie Magic', value: 'Movie Magic' },
        20: { text: 'Movie Recommendation', value: 'Movie Recommendation' },
        21: { text: 'Movie Review', value: 'Movie Review' },
        22: { text: 'On Location', value: 'On Location' },
        23: { text: 'On Set Magic', value: 'On Set Magic' },
        24: { text: 'OnScreen Chemistry', value: 'OnScreen Chemistry' },
        25: { text: 'Plot Twist', value: 'Plot Twist' },
        26: { text: 'Production Insider', value: 'Production Insider' },
        27: { text: 'Scene Breakdown', value: 'Scene Breakdown' },
        28: { text: 'Series Finale', value: 'Series Finale' },
        29: { text: 'Set Design', value: 'Set Design' },
        30: { text: 'Set Life', value: 'Set Life' },
        31: { text: 'Show Recommendation', value: 'Show Recommendation' },
        32: { text: 'Spoiler Alert', value: 'Spoiler Alert' },
        33: { text: 'TV Analysis', value: 'TV Analysis' },
        34: { text: 'TV Review', value: 'TV Review' },
        35: { text: 'TVShow Discussion', value: 'TVShow Discussion' },
        36: { text: 'TVShow Recap', value: 'TVShow Recap' },
        37: { text: 'TVShow Spoiler ', value: 'TVShow Spoiler' },
    }
     const [openPanels, setOpenPanels] = useState([])

     const handleButtonClick = (panelKey, event) => {
         event.preventDefault()
         setOpenPanels((prev) => [...prev, panelKey])
     }

     const handlePanelClose = (panelKey, event) => {
         event.preventDefault()
         setOpenPanels((prev) => prev.filter((panel) => panel !== panelKey))
         console.log(openPanels)
     }

     const isPanelOpen = (panelKey) => openPanels.includes(panelKey)

    const handleSubmit = (e) => {
        e.preventDefault()
    }
    const IMAGE_URL = '/images/'
    const image = BASE_URL + IMAGE_URL + props.mainImage

    const imageError = !props.validimage && !props.mainImage
    const currentImage = props.mainImage && !props.validimage
    return (
        <div className="flex flex-col items-start justify-start gap-2 w-full mt-4">
            <form
                onSubmit={(e) => handleSubmit(e)}
                className="flex flex-col items-start justify-start gap-2 w-full"
            >
                <div className="w-full">
                    <label htmlFor="fname">Tittle</label>
                    <input
                        value={props.postInfo.tittle}
                        id="fname"
                        type="text"
                        required
                        className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                        onChange={(e) => props.handleOnChange(e, 'tittle')}
                    />
                    {!props.validtittle && (
                        <p className="text-tiny-m-400 lg:text-tiny-d-400 text-red-600">
                            Title maximum lenght is 255 characters
                        </p>
                    )}
                </div>
                <div className="w-full">
                    <label htmlFor="fheadline">Headline</label>
                    <input
                        value={props.postInfo.headline}
                        id="fheadline"
                        type="text"
                        required
                        className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                        onChange={(e) => props.handleOnChange(e, 'headline')}
                    />
                    {!props.validheadline && (
                        <p className="text-tiny-m-400 lg:text-tiny-d-400 text-red-600">
                            Headline maximum lenght is 255 characters
                        </p>
                    )}
                </div>
                <div className="flex flex-row items-center justify-between flex-wrap w-full ">
                    <div>
                        <label htmlFor="fimage">Front image</label>
                        <input
                            id="fimage"
                            type="file"
                            accept="image/jpeg"
                            required
                            onChange={(e) => props.handleOnChange(e, 'image')}
                            className="overflow-hidden text-ellipsis line-clamp-3 w-full break-words h-[36px] text-small-m-400 lg:text-small-d-400"
                        />
                        {imageError && (
                            <p className="text-tiny-m-400 lg:text-tiny-d-400 text-red-600">
                                Please select a main image for your post
                            </p>
                        )}
                    </div>
                    {currentImage && (
                        <div className="flex flex-col items-start justify-start gap-1">
                            <p>Current image</p>
                            <img
                                //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                                src={image}
                                alt="Elva dressed as a fairy"
                                className="w-[400px] h-[270px]  object-cover object-center"
                            />
                        </div>
                    )}
                </div>
                <div>
                    <p>Tag</p>
                    <div className="flex flex-row items-center justify-start gap-2 relative min-[665px]:static flex-wrap">
                        <div className="static min-[665px]:relative">
                            <div
                                onClick={(event) => {
                                    event.stopPropagation()
                                    handleButtonClick('tag', event)
                                }}
                                className="flex flex-row items-center justify-start gap-1 px-2 py-[4px] border border-white-300 rounded-[18px] hover:cursor-pointer"
                            >
                                <button className="text-small-m-400 lg:text-small-d-400 text-white-700 uppercase">
                                    {props.postInfo.tag
                                        ? props.postInfo.tag
                                        : 'Tags'}
                                </button>
                                <svg
                                    width="10"
                                    height="10"
                                    viewBox="0 0 10 10"
                                    fill="none"
                                    className=""
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        d="M10 2.8248V2.87734C9.98659 3.06601 9.91836 3.22187 9.79531 3.34491C8.39258 4.74817 6.99818 6.14257 5.61211 7.52812C5.49883 7.6414 5.41575 7.71425 5.36289 7.74667C5.14492 7.88026 4.86797 7.88124 4.64609 7.75234C4.59232 7.72109 4.50462 7.64472 4.38301 7.52323C2.98848 6.12922 1.59421 4.73495 0.200195 3.34042C0.0796224 3.21972 0.0128906 3.06457 0 2.87499V2.82226C0.00976562 2.68411 0.0473958 2.56711 0.112891 2.47128C0.252344 2.26698 0.444857 2.16067 0.69043 2.15234C0.811263 2.1483 0.929688 2.17844 1.0457 2.24276C1.10299 2.27454 1.1776 2.33638 1.26953 2.42831C2.49154 3.65175 3.73359 4.894 4.9957 6.15507C4.99857 6.15793 5.0015 6.15793 5.00449 6.15507C6.2748 4.88476 7.53776 3.6218 8.79336 2.3662C9.06953 2.09023 9.50273 2.08026 9.7832 2.34589C9.91484 2.4705 9.98711 2.63013 10 2.8248Z"
                                        fill="black"
                                    />
                                </svg>
                            </div>
                            <SortPanel
                                tittle={'Tags'}
                                panelKey="tag"
                                isOpen={isPanelOpen('tag')}
                                isPanelOpen={isPanelOpen}
                                onClose={handlePanelClose}
                                sortRadioButtonData={tagRadioButtonData}
                                selectedValue={props.postInfo.tag}
                                onchange={props.handleOnChange}
                                link={true}
                            ></SortPanel>
                        </div>
                    </div>
                    {!props.validtag && (
                        <p className="text-tiny-m-400 lg:text-tiny-d-400 text-red-600">
                            Please select a tag for your post
                        </p>
                    )}
                </div>
                <div className="w-full">
                    <label htmlFor="fsynthesis">Synthesis</label>
                    <input
                        value={props.postInfo.synthesis}
                        id="fsynthesis"
                        type="text"
                        required
                        className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                        onChange={(e) => props.handleOnChange(e, 'synthesis')}
                    />
                    {!props.validsynthesis && (
                        <p className="text-tiny-m-400 lg:text-tiny-d-400 text-red-600">
                            Synthesis maximum lenght is 1000 characters
                        </p>
                    )}
                </div>
            </form>
            <div>
                <Editor
                    editorStyle={{
                        border: '1px solid #F1F1F1',
                        padding: '8px',
                        minHeight: '270px',
                    }}
                    editorState={props.editorState}
                    onEditorStateChange={props.setEditorState}
                    placeholder=" Tell your story..."
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

            <div className="flex flex-row items-center justify-between flex-wrap gap-1 self-end my-5">
                <button
                    onClick={(event) => props.handleDiscardPost(event)}
                    disabled={!props.buttonsEnable}
                    className="flex flex-row items-center justify-center w-[98px] h-[32px] bg-red-600 rounded hover:bg-red-400 text-white-50 text-small-d-400"
                >
                    Discard
                </button>
                <button
                    onClick={(e) => props.handlesavePost('DRAFT')}
                    disabled={!props.buttonsEnable}
                    className="flex flex-row items-center justify-center w-[98px] h-[32px] bg-white-600 rounded hover:bg-white-400 text-white-50 text-small-d-400"
                >
                    Save Draft
                </button>
                <button
                    onClick={(e) => props.handlesavePost('PUBLISHED')}
                    disabled={!props.buttonsEnable}
                    className="flex flex-row items-center justify-center w-[98px] h-[32px] bg-green-700 rounded hover:bg-green-600 text-white-50 text-small-d-400"
                >
                    Post
                </button>
            </div>
        </div>
    )
}

export default EditorContainer
