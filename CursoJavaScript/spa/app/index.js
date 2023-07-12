import api from "./helpers/wp_api.js";
import { App } from "./App.js";
const d = document;
const w = window;
document.addEventListener("DOMContentLoaded", App);

window.addEventListener("hashchange", () => {
    //page = 1 para que cuando cambiemos de hash de home a search o otro;
    //nos cargue la misma primera pagina y no toda la page que fue cargada anteriormente
    api.page = 1;
    App();
});