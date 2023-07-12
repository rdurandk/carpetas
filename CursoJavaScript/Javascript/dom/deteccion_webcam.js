const d = document;
const n = navigator;
export default function webCam(id) {
    const $video = d.getElementById(id);
    //console.log(n.mediaDevices.getUserMedia)

    if (n.mediaDevices.getUserMedia) {
        n.mediaDevices.getUserMedia({ video: {
            width: { min: 1024, ideal: 1280, max: 1600 },
            height: { min: 776, ideal: 720, max: 900 }
          }, audio: true })
        .then((stream) => { 
            console.log(stream);
            $video.srcObject = stream;
            $video.play();
        })
        .catch((err) => {
            $video.insertAdjacentHTML("beforebegin", `<p>Sucedio el siguiente error:<mark>${err}</mark></p>`);
            /*console.log(`Sucedio el siguiente error: ${err}`)*/});
    }
}