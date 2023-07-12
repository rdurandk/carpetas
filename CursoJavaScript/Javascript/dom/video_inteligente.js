const d = document;
const w = window;
export default function smartVideo() {
  const $videos = d.querySelectorAll("video[data-smart-video]");
  const cb = (entries) => {
    //forEach por que tenemos mas de un video
    entries.forEach((entry) => {
      console.log("entry", entry);
      if (entry.isIntersecting) {
        entry.target.play();
      } else {
        entry.target.pause();
      }

      //Esto visibilitychange sera para cuando abramos otra pestaña o minimizamos la ventana
      w.addEventListener("visibilitychange", (e) => {
        if (d.visibilityState === "visible" && entry.isIntersecting) {
          entry.target.play();
        } else {
          entry.target.pause();
        }
      });
    });
  };
  const observer = new IntersectionObserver(cb, {
    threshold: 0.5,
  });
  $videos.forEach((el) => observer.observe(el));
}
