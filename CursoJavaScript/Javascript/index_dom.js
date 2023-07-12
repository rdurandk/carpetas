import slider from "./dom/carrusel.js";
import countdown from "./dom/cuenta_regresiva.js";
import userDeviceInfo from "./dom/deteccion_dispositivos.js";
import networkStatus from "./dom/deteccion_red.js";
import webCam from "./dom/deteccion_webcam.js";
import searchFilters from "./dom/filtro_busqueda.js";
import getGeolocation from "./dom/geolocalizacion.js";
import hamburguerMenu from "./dom/menu_hamburguesa.js";
import speechReader from "./dom/narrador.js";
import responsiveMedia from "./dom/objeto_responsive.js";
import responsiveTester from "./dom/prueba_responsive.js";
import { DigitalAlarm, DigitalClock } from "./dom/reloj.js";
import scrollSpy from "./dom/scroll_espia.js";
import ScrollTopBtn from "./dom/scroll_top.js";
import draw from "./dom/sorteo_digital.js";
import { moveBall, shortcuts } from "./dom/teclado.js";
import darkTheme from "./dom/tema_oscuro.js";
import contactFormValidations from "./dom/validaciones_formularios.js";
import smartVideo from "./dom/video_inteligente.js";

const d = document;

d.addEventListener("DOMContentLoaded", (e) => {
  hamburguerMenu(".panel-btn", ".panel", ".menu a");
  DigitalClock(".reloj", ".iniciar-reloj", ".detener-reloj");
  DigitalAlarm("assets/soundradio.mp3", ".iniciar-alarma", ".detener-alarma");
  countdown("countdown", "Dec 25, 2022 00:00:00", "Feliz Navidad Alex gaa 🤗");
  ScrollTopBtn(".scroll-top-btn");
  responsiveMedia(
    "youtube",
    "(min-width: 1024px)",
    `<a href="https://www.youtube.com/embed/desJKYvdq9A" 
        target="_blank" rel="noopener">Ver Video</a>`,
    `<iframe width="560" height="315" src="https://www.youtube.com/embed/ontU9cOg354" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>`
  );
  responsiveMedia(
    "gmaps",
    "(min-width: 1024px)",
    `<a href="https://goo.gl/maps/FMrxyN5djSphesW88" 
        target="_blank" rel="noopener">Ver Mapa</a>`,
    `<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d487.
        4697462280965!2d-76.9438536721297!3d-12.19686497802266!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13
        .1!3m3!1m2!1s0x9105b96bb336fc8f%3A0x670c7a98852db8a7!2sPunto%20De%20Precision%20S.A.C!5e0!3m2!1ses
        -419!2spe!4v1634834346015!5m2!1ses-419!2spe" width="600" height="450" style="border:0;" allowfullscreen="" 
        loading="lazy"></iframe>`
  );
  responsiveTester("responsive-tester");
  userDeviceInfo("user-device");
  webCam("webcam");
  getGeolocation("geolocation");
  searchFilters(".cards-filte", ".card");
  draw("#winner-btn", ".player");
  slider();
  scrollSpy();
  smartVideo();
  contactFormValidations();
});

d.addEventListener("keydown", (e) => {
  shortcuts(e);
  moveBall(e, ".ball", ".stage");
});

darkTheme(".dark-theme-btn", "data-mode");
networkStatus();
speechReader();
