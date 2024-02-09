import React, { useState, useEffect, useContext } from 'react'
import { useSearchParams, useParams, useNavigate } from 'react-router-dom'
import { useQuery, useMutation, useQueryClient } from 'react-query'
import { EditorState, convertFromRaw, convertToRaw } from 'draft-js'
import useAuth from '../hooks/useAuth'
import useAxiosPrivate from '../hooks/useAxiosPrivate'

import EditorContainer from './EditorContainer'
function EditorManager() {
    // const [editorState, setEditorState] = useState(
    //     EditorState.createWithContent(
    //         convertFromRaw({
    //             blocks: [
    //                 {
    //                     key: 'c5kkv',
    //                     text: ' In the vast landscape of cinematic storytelling, where every frame is a canvas and every line of dialogue a brushstroke, the art of crafting a compelling narrative is both a delicate dance and an immersive journey. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 216,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'dnq89',
    //                     text: 'As audiences, we embark on these cinematic odysseys seeking not just entertainment but an experience that resonates with our emotions, stimulates our intellect, and perhaps, leaves an indelible mark on our perspectives. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 220,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'dpmdg',
    //                     text: 'A truly remarkable aspect of the cinematic world is its ability to transport us to realms unknown, to make us laugh, cry, and ponder the intricacies of the human condition. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 173,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'fp84t',
    //                     text: 'Whether nestled within the cozy confines of our living rooms or amidst the hushed ambiance of a darkened theater, each film or television show we engage with holds the potential to be a portal to new dimensions, a window into diverse cultures, or a mirror reflecting our shared humanity. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 288,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '8k82k',
    //                     text: "At the heart of this captivating journey lies the storytelling prowess that transforms mere scripts into gripping tales. It is the storyteller's craft that weaves the fabric of characters, settings, and plots, inviting us to partake in the unfolding narrative. ",
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 261,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '3c0u9',
    //                     text: 'The magnetic pull of a well-told story is irresistible, drawing us into its orbit with the promise of discovery and emotional resonance.    ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 140,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [
    //                         { offset: 138, length: 1, key: 0 },
    //                         { offset: 139, length: 1, key: 1 },
    //                     ],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '2e9g9',
    //                     text: '',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '211c9',
    //                     text: ' ',
    //                     type: 'atomic',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [{ offset: 0, length: 1, key: 2 }],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'c34ks',
    //                     text: 'Popular character in Movie123 (Some Production Name.)  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 53,
    //                             style: 'color-rgb(68,68,68)',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 53,
    //                             style: 'bgcolor-white',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 53,
    //                             style: 'fontsize-8.5pt',
    //                         },
    //                         { offset: 0, length: 55, style: 'ITALIC' },
    //                         {
    //                             offset: 0,
    //                             length: 55,
    //                             style: 'fontsize-11',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 55,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: { 'text-align': 'center' },
    //                 },
    //                 {
    //                     key: 'erjop',
    //                     text: 'One element that distinguishes exceptional storytelling is the artful construction of characters. When characters transcend the boundaries of the screen and become living, breathing entities, the narrative gains a depth that resonates with the audience. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 254,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '8jrjl',
    //                     text: ' Whether flawed anti-heroes navigating moral gray areas or relatable protagonists facing everyday challenges, the authenticity of characters allows us to empathize, connect, and reflect on our own journeys. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 207,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '8sbhg',
    //                     text: '',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'fem7k',
    //                     text: 'Unveiling Cinematic Mastery: A Deep Dive into Storytelling Brilliance ',
    //                     type: 'header-three',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 69,
    //                             style: 'fontsize-11pt',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 70,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                         { offset: 0, length: 70, style: 'BOLD' },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '5cjb',
    //                     text: 'Consider the interplay of conflict and resolution, the ebb, and flow of tension within a story. A well-crafted narrative keeps us on the edge of our seats, yearning for resolution while savoring the anticipation.  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 214,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'e8q9e',
    //                     text: 'The strategic placement of plot twists, the revelation of unexpected truths, and the gradual unfolding of a mystery contribute to the immersive experience, leaving us craving more. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 181,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '4ji1f',
    //                     text: 'The visual language of cinema is another dimension that enhances storytelling. From sweeping landscapes that evoke a sense of awe to intimate close-ups that capture the nuances of human emotion, each frame is a carefully composed brushstroke contributing to the larger masterpiece.  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 283,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'd69ve',
    //                     text: 'Cinematography is the silent storyteller, conveying emotions and themes beyond the spoken word. The artful use of color, light, and composition creates a visual symphony that resonates with our senses. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 202,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '7eph9',
    //                     text: 'Through the lens of luminaries like Charlie Chaplin and Buster Keaton, silent films communicated universal emotions, transcending language barriers and establishing the visual language of storytelling. Each frame was a canvas, and the absence of dialogue invited audiences to interpret narratives through nuanced performances and captivating imagery.   ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 353,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [{ offset: 352, length: 1, key: 3 }],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'cvas4',
    //                     text: '',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'auud9',
    //                     text: ' ',
    //                     type: 'atomic',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [{ offset: 0, length: 1, key: 4 }],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '5pfpn',
    //                     text: 'Popular characters in Movie123 (Some Production Name.)  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 54,
    //                             style: 'color-rgb(68,68,68)',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 54,
    //                             style: 'bgcolor-white',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 54,
    //                             style: 'fontsize-8.5pt',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 56,
    //                             style: 'fontsize-11',
    //                         },
    //                         { offset: 0, length: 56, style: 'ITALIC' },
    //                         {
    //                             offset: 0,
    //                             length: 56,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: { 'text-align': 'center' },
    //                 },
    //                 {
    //                     key: '6gbl',
    //                     text: 'The mid-20th century witnessed the rise of auteur directors, individuals who stamped their unique artistic vision on every film. Filmmakers like Akira Kurosawa, Ingmar Bergman, and Federico Fellini pushed the boundaries of conventional storytelling, experimenting with narrative structures and delving into profound philosophical themes.  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 339,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '9mg8v',
    //                     text: 'The result was a cinematic landscape enriched by diverse cultural perspectives, challenging audiences to engage with stories that transcended geographical and cultural boundaries. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 180,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'ce5u6',
    //                     text: 'The turn of the millennium witnessed the convergence of traditional filmmaking and digital technologies. Filmmakers like Christopher Nolan and Quentin Tarantino embraced nonlinear storytelling, manipulating time and narrative structure to create intellectually engaging experiences. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 283,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '5c51s',
    //                     text: 'The democratization of filmmaking tools enabled independent filmmakers to tell unconventional stories, contributing to a rich tapestry of narratives that challenged mainstream conventions. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 189,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '4s2hd',
    //                     text: 'The present era is characterized by a diverse cinematic landscape, where streaming platforms provide a platform for storytellers to experiment with episodic formats and unconventional narratives.  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 197,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'dboj1',
    //                     text: 'Television series have become a canvas for long-form storytelling, allowing for character development and intricate plot arcs that rival the complexity of epic novels.  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 169,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '400s6',
    //                     text: '“ In the tapestry of existence, woven with threads of unpredictability, lies the essence of our individual odysseys. Embrace the uncertainty of the journey, for it is within the uncharted territories of life that we unravel the threads of our truest selves. Like intrepid explorers navigating uncharted seas, we find resilience in the face of the unknown, and in those moments of uncertainty, we uncover the colors that define the canvas of our unique narratives. It is through the interplay of challenges and triumphs that our character deepens, and our stories unfold with an exquisite complexity. So, let the unpredictable rhythms of life be your guide, for it is in embracing the unknown that we embark on the most profound and transformative chapters of our personal sagas.“   -someone 2019',
    //                     type: 'blockquote',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 1,
    //                             style: 'color-rgb(36,36,36)',
    //                         },
    //                         {
    //                             offset: 778,
    //                             length: 1,
    //                             style: 'color-rgb(36,36,36)',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 1,
    //                             style: 'bgcolor-rgb(255,255,255)',
    //                         },
    //                         {
    //                             offset: 778,
    //                             length: 1,
    //                             style: 'bgcolor-rgb(255,255,255)',
    //                         },
    //                         { offset: 0, length: 795, style: 'ITALIC' },
    //                         {
    //                             offset: 0,
    //                             length: 795,
    //                             style: 'fontsize-14',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 795,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'bm3hr',
    //                     text: 'This shift has redefined audience expectations, encouraging filmmakers to craft narratives that unfold over multiple episodes, creating immersive worlds that invite viewers to invest in the characters and their journeys. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 221,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'cs5',
    //                     text: 'Sound design and musical scores add yet another layer to the cinematic tapestry. A haunting melody can elevate a poignant moment, a pulsating rhythm can intensify an action sequence, and a carefully chosen soundtrack can become the heartbeat of a narrative.  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 259,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '4k76b',
    //                     text: "The marriage of visuals and sound transforms the viewing experience into a multisensory journey, immersing us in the filmmaker's intended atmosphere. ",
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 150,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '74tp5',
    //                     text: '',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'eb6dj',
    //                     text: 'Beyond the Screen: Exploring the Emotionally Charged Landscape of Cinematic Excellence ',
    //                     type: 'header-three',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 86,
    //                             style: 'fontsize-11pt',
    //                         },
    //                         { offset: 0, length: 87, style: 'BOLD' },
    //                         {
    //                             offset: 0,
    //                             length: 87,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '4dlfn',
    //                     text: 'Moreover, the pacing of a narrative is a delicate dance, striking a balance between moments of reflection and bursts of intensity. A well-paced story allows for the organic development of characters and themes, creating a rhythm that guides the audience through the narrative landscape. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 287,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'c7fl9',
    //                     text: '',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '202uu',
    //                     text: ' ',
    //                     type: 'atomic',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 1,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [{ offset: 0, length: 1, key: 5 }],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '78fr1',
    //                     text: ' Popular character in Movie123 (Some Production Name.)  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 56,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                         {
    //                             offset: 1,
    //                             length: 53,
    //                             style: 'color-rgb(68,68,68)',
    //                         },
    //                         {
    //                             offset: 1,
    //                             length: 53,
    //                             style: 'bgcolor-white',
    //                         },
    //                         {
    //                             offset: 1,
    //                             length: 53,
    //                             style: 'fontsize-8.5pt',
    //                         },
    //                         {
    //                             offset: 1,
    //                             length: 55,
    //                             style: 'fontsize-11',
    //                         },
    //                         { offset: 1, length: 55, style: 'ITALIC' },
    //                     ],
    //                     entityRanges: [],
    //                     data: { 'text-align': 'center' },
    //                 },
    //                 {
    //                     key: '8n9dd',
    //                     text: 'It is in the pauses, the beats between dialogues, and the lingering shots that the audience has the space to absorb, reflect, and feel the emotional weight of the unfolding events. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 181,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '2ien1',
    //                     text: 'While the technical aspects of filmmaking contribute significantly to the storytelling process, the thematic depth of a narrative often determines its lasting impact. The exploration of universal themes such as love, loss, identity, and the human\ncondition forms the emotional core that resonates across diverse audiences. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 323,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '7o79b',
    //                     text: ' A narrative that prompts introspection and transcends cultural boundaries becomes a shared experience, fostering a sense of collective storytelling that binds us as global spectators. ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 185,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: '8v3r9',
    //                     text: '',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //                 {
    //                     key: 'cl599',
    //                     text: 'Conclusion ',
    //                     type: 'header-three',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 10,
    //                             style: 'color-rgb(36,36,36)',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 10,
    //                             style: 'bgcolor-rgb(255,255,255)',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 10,
    //                             style: 'fontsize-24',
    //                         },
    //                         {
    //                             offset: 0,
    //                             length: 11,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                         { offset: 0, length: 11, style: 'BOLD' },
    //                     ],
    //                     entityRanges: [],
    //                     data: { 'text-align': 'start' },
    //                 },
    //                 {
    //                     key: '2h4mg',
    //                     text: 'In conclusion, the world of cinema is a realm of endless possibilities, where storytelling becomes an art form that transcends time and space. Whether through the lens of a camera or the dialogue delivered by actors, each element contributes to the rich tapestry of narratives that captivate, inspire, and challenge our perspectives. As audiences, we are not merely passive observers;we are active participants in a cinematic odyssey that continues to shape our understanding of the world and our place within it.  ',
    //                     type: 'unstyled',
    //                     depth: 0,
    //                     inlineStyleRanges: [
    //                         {
    //                             offset: 0,
    //                             length: 515,
    //                             style: 'fontfamily-Georgia',
    //                         },
    //                     ],
    //                     entityRanges: [],
    //                     data: {},
    //                 },
    //             ],
    //             entityMap: {
    //                 0: {
    //                     type: 'IMAGE',
    //                     mutability: 'MUTABLE',
    //                     data: {
    //                         src: 'http://localhost:9090/api/v1/images/3d4c86e8-fc74-490e-bebe-dd5001324335',
    //                         height: 'auto',
    //                         width: 'auto',
    //                         alt: 'Popular character in Movie123 (Some Production Name.)',
    //                     },
    //                 },
    //                 1: {
    //                     type: 'IMAGE',
    //                     mutability: 'MUTABLE',
    //                     data: {
    //                         src: 'http://localhost:9090/api/v1/images/09836cbb-bcf4-450e-9c43-35a2a6ffe680',
    //                         height: 'auto',
    //                         width: 'auto',
    //                         alt: 'Popular character in Movie123 (Some Production Name.)',
    //                         alignment: 'none',
    //                     },
    //                 },
    //                 2: {
    //                     type: 'IMAGE',
    //                     mutability: 'MUTABLE',
    //                     data: {
    //                         src: 'http://localhost:9090/api/v1/images/12517f15-0609-4c69-8e08-9751930786f1',
    //                         height: 'auto',
    //                         width: 'auto',
    //                         alt: 'Popular character in Movie123 (Some Production Name.)',
    //                     },
    //                 },
    //                 3: {
    //                     type: 'IMAGE',
    //                     mutability: 'MUTABLE',
    //                     data: {
    //                         src: 'http://localhost:9090/api/v1/images/e8e97139-2601-4bf8-a4f2-5709d4032bde',
    //                         height: 'auto',
    //                         width: 'auto',
    //                         alt: 'Popular character in Movie123 (Some Production Name.)',
    //                         alignment: 'none',
    //                     },
    //                 },
    //                 4: {
    //                     type: 'IMAGE',
    //                     mutability: 'MUTABLE',
    //                     data: {
    //                         src: 'http://localhost:9090/api/v1/images/0f1b7ede-bac8-4b6f-830b-675df7af465b',
    //                         height: 'auto',
    //                         width: 'auto',
    //                         alt: 'Popular character in Movie123 (Some Production Name.)',
    //                     },
    //                 },
    //                 5: {
    //                     type: 'IMAGE',
    //                     mutability: 'MUTABLE',
    //                     data: {
    //                         src: 'http://localhost:9090/api/v1/images/05848e52-424d-4110-af96-2ae13cacf9e4',
    //                         height: 'auto',
    //                         width: 'auto',
    //                         alt: 'Popular character in Movie123 (Some Production Name.)',
    //                     },
    //                 },
    //             },
    //         })
    //     )
    // )
     
    const { auth } = useAuth()
    const axiosPrivate = useAxiosPrivate()
    const params = useParams()
    const navigate = useNavigate()
    const queryClient = useQueryClient()
    const [searchParams, setSearchParams] = useSearchParams()
    const [editorState, setEditorState] = useState(EditorState.createEmpty())
    const [postId, setpostId] = useState(null)
    const [postInfo, setPostInfo] = useState({
        tittle: '',
        headline: '',
        synthesis: '',
        image: '',
        tag: '',
    })
    const [validtittle, setvalidtittle] = useState(false)
    const [validheadline, setvalidheadline] = useState(false)
    const [validsynthesis, setvalidsynthesis] = useState(false)
    const [validimage, setvalidimage] = useState(false)

    const edit = searchParams.get('edit') || ''

    function handleDiscardPost(event) {
        event.preventDefault()
        discardPost.mutate()
        navigate('/', { replace: true })
    }

    //dependent query on postId to get POST_MAIN image if exists

    function handleOnChange(e, key) {
        if (key == 'image') {
            setPostInfo({ ...postInfo, [key]: e.target.files[0] })
        } else {
            setPostInfo({ ...postInfo, [key]: e.target.value })
        }
        console.log(postInfo)
    }

    const createNewPost = useQuery({
        queryKey: ['', auth.id],
        queryFn: async () => {
            try {
                return axiosPrivate.post(
                    `/posts`,
                    JSON.stringify({
                        user: auth.id,
                        film: params.uuid,
                        status: 'draft',
                        tag: '20c9127b-79d5-485a-8e59-c14a3dc8a777',
                        publicationDateTime: new Date().toISOString(),
                    })
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            setpostId(data?.data?.created?.id)
            console.log(data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    const discardPost = useMutation({
        mutationKey: ['discardPost', auth.id],
        mutationFn: async () => {
            try {
                return axiosPrivate.delete(`/posts/${postId}`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            console.log(data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    const savePost = useMutation({
        mutationKey: ['savePost', auth.id],
        mutationFn: async (postStatus) => {
            axiosPrivate.patch(`${SERVER_URL}/posts/${postId}`, {
                tittle: postInfo.tittle,
                headline: postInfo.headline,
                synthesis: postInfo.synthesis,
                content: JSON.stringify(
                    convertToRaw(editorState.getCurrentContent())
                ),
                status: postStatus,
            })
        },
    })

    const saveImage = useMutation({
        mutationKey: ['saveImage', auth.id],
        mutationFn: async (formData) =>{
              axiosPrivate.post(`${SERVER_URL}/RT/${postId}/image`, formData)
        }
    })

   async function handlesavePost(postStatus) {
       try {
           const requests = [savePost.mutateAsync(postStatus)]
           if (postInfo.image instanceof File) {
            //ask if an image already exists if it does remove it and push the new image
               const formData = new FormData()
               formData.append('image', postInfo.image)
               formData.append('imageType', 'POST_MAIN')
               requests.push(saveImage.mutateAsync(formData))
           }

           await Promise.all(requests)
           history.replace('/')
       } catch (error) {
           console.error(error)
       }
   }

    async function uploadImageCallback(file) {
        return new Promise((resolve, reject) => {
            const formData = new FormData()
            formData.append('image', file)
            formData.append('id', postId)
            formData.append('imageType', 'POST_COLLECTION')

            fetch('http://localhost:9090/api/v1/posts/images', {
                method: 'POST',
                body: formData,
            })
                .then(async (response) => {
                    const data = await response.json()
                    if (!response.ok) {
                        //const error = (data && data.message) || response.status
                        //setError(error)
                    } else {
                        console.log(data)
                        resolve({
                            data: {
                                link:
                                    'http://localhost:9090/api/v1' +
                                    '/images/' +
                                    data.created['960x880'],
                            },
                        })
                    }
                })
                .catch((error) => {
                    //console.error('There was an error!', error)
                })
        })
    }
    useEffect(() => {
        history.pushState(null, document.title, location.href)
        const handleBeforeUnload = (event) => {
            const message = 'Are you sure you want to leave?'
            event.returnValue = message
            return message
        }

        const handlePopState = (event) => {
            if (!event.persisted) {
                const shouldLeave = window.confirm(
                    'Are you sure you want to leave?'
                )
                if (shouldLeave) {
                    console.log('User is leaving...')
                    discardPost.mutate()
                }
            }
        }

        const handleLinkClick = (event) => {
            const shouldLeave = window.confirm(
                'Are you sure you want to leave?'
            )
            if (shouldLeave) {
                discardPost.mutate()
            } else {
                event.preventDefault()
            }
        }

        window.addEventListener('beforeunload', handleBeforeUnload)
        window.addEventListener('popstate', handlePopState)

        const links = document.querySelectorAll('a')
        links.forEach((link) => link.addEventListener('click', handleLinkClick))

        return () => {
            window.removeEventListener('beforeunload', handleBeforeUnload)
            window.removeEventListener('popstate', handlePopState)

            links.forEach((link) =>
                link.removeEventListener('click', handleLinkClick)
            )
        }
    }, [])

    useEffect(() => {
        setvalidtittle(postInfo.tittle.length <= 255)
    }, [postInfo.tittle])

    useEffect(() => {
        setvalidheadline(postInfo.headline.length <= 255)
    }, [postInfo.headline])
    useEffect(() => {
        setvalidimage(postInfo.image)
    }, [postInfo.image])
    useEffect(() => {
        setvalidsynthesis(postInfo.synthesis.length <= 1000)
    }, [postInfo.synthesis])

    return (
        <EditorContainer
            editorState={editorState}
            setEditorState={setEditorState}
            uploadImageCallback={uploadImageCallback}
            discardPost={discardPost}
            savePost={savePost}
            postInfo={postInfo}
            handleOnChange={handleOnChange}
            validtittle={validtittle}
            validheadline={validheadline}
            validimage={validimage}
            validsynthesis={validsynthesis}
            handleDiscardPost={handleDiscardPost}
        ></EditorContainer>
    )
}

export default EditorManager
