const d = document;
const w = window;

export default function responsiveMedia(id, mq, mobileContent, desktopContent) {
  const $id = d.getElementById(id);

  let breakpoint = w.matchMedia(mq);

  const responsive = (e) => {
    //console.log("MQ", breakpoint, e.matches)
    if (e.matches) {
      $id.innerHTML = desktopContent;
    } else {
      $id.innerHTML = mobileContent;
    }
  };

  breakpoint.addListener(responsive);
  responsive(breakpoint);
  // breakpoint.addListener(function (e) {
  //   if (e.matches) {
  //     $id.innerHTML = desktopContent;
  //   } else {
  //     $id.innerHTML = mobileContent;
  //   }
  // });
}
