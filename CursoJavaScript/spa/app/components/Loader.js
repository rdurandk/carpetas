export function Loader(){
    const $loader = document.createElement("img");

    $loader.setAttribute("src", "../assets/ball-triangle.svg");
    $loader.alt = "Cargando...";
    $loader.classList.add("loader");
    return $loader;
}