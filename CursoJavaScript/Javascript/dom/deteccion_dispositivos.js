const d = document;
const n = navigator;
const ua = n.userAgent;
export default function userDeviceInfo(id) {
  const $id = d.getElementById(id);
  const isMobile = {
    android: () => ua.match(/android/i),
    ios: () => ua.match(/iphone|ipad|ipod/i),
    windows: () => ua.match(/windows phone/i),
    any: function () {
      return this.android() || this.ios() || this.windows();
    },
  };
  const isDesktop = {
    linux: () => ua.match(/linux/i),
    mac: () => ua.match(/mac os/i),
    windows: () => ua.match(/windows nt/i),
    any: function () {
      return this.linux() || this.mac() || this.windows();
    },
  };
  const isBrowser = {
    chrome: () => ua.match(/chrome/i),
    safari: () => ua.match(/safari/i),
    firefox: () => ua.match(/firefox/i),
    opera: () => ua.match(/opera/i),
    ie: () => ua.match(/msie|iemobile/i),
    edg: () => ua.match(/edg/i),
    any: function () {
      return (
        this.ie() ||
        this.edg() ||
        this.chrome() ||
        this.safari() ||
        this.firefox() ||
        this.opera()
      );
    },
  };
  //console.log(ua);
  //console.log(isMobile.android());
  //console.log(isMobile.any());

  $id.innerHTML = `
    <ul>
    <li>UserAgent ${ua}</li>
    <br><li>Plataforma: ${
      isMobile.any() ? isMobile.any() : isDesktop.any()
    }</li>
    <br><li>Browser: ${isBrowser.any()}</li>
    </ul>
    `;

  /**Contenido Exclusivo**/
  if (isBrowser.any()) {
    $id.innerHTML += `<p><mark>Este contenido es exclusivamente para ${isBrowser.any()}</mark></p>`;
  }
  /*Redireccion*/

  if (isDesktop.linux()) {
    window.location.href = `https://www.youtube.com`;
  }
}
