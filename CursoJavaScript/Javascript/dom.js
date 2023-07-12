console.log("=======INTRODUCCION======")

/*
console.log("=======Elementos del Documento==========");
console.log(document)
console.log(document.head)
console.log(document.body)
console.log(document.documentElement)
console.log(document.doctype)
console.log(document.title)
console.log(document.links)
console.log(document.images)
console.log(document.forms)
console.log(document.scripts)
setTimeout  (() =>{
    console.log(document.getSelection().toString());
},3000);
document.write("<h2>Probando desde el dom.js</h2>");

*/


console.log("==========Nodo Elementos y Selectores=========")

console.log(document.getElementsByTagName("li"))
console.log(document.getElementsByClassName("card"));
console.log(document.getElementById("menu"));
console.log(document.querySelector("#menu"))
console.log(document.querySelector("a"));
console.log(document.querySelectorAll("a"));
document.querySelectorAll("a").forEach(el => console.log(el));
document.querySelectorAll(".card").forEach(el => console.log(el))
console.log(document.querySelectorAll(".card")[2]);


console.log("=====ATRIBUTOS Y DATAS ATTRIBUTES=====")

console.log(document.documentElement.lang);
console.log(document.querySelector(".link-dom").href)
console.log(document.querySelector(".link-dom").getAttribute("href"))

document.documentElement.lang = "en";
console.log(document.documentElement.lang);
//otra forma de agregar un lang
document.documentElement.setAttribute("lang", "es-Español Peru")
console.log(document.documentElement.lang);

const $linkDOM = document.querySelector(".link-dom")

$linkDOM.setAttribute("target", "_blank");
$linkDOM.setAttribute("rel", "noopener");

$linkDOM.removeAttribute("rel");
console.log($linkDOM.hasAttribute("rel"));

//Data- Attributes
console.log($linkDOM.getAttribute("data-description"))
console.log($linkDOM.getAttribute("data-prueba"))
$linkDOM.setAttribute("data-description", "Data Model");
console.log($linkDOM.dataset)
//otro modo de cambiar el valor del atributo
$linkDOM.dataset.description = "Data Model2"
console.log($linkDOM.dataset)

console.log("=======ESTILOS Y VARIABLES=====")
console.log($linkDOM.style);
console.log($linkDOM.getAttribute("style"))
console.log($linkDOM.style.backgroundColor);
console.log($linkDOM.style.color);
console.log(window.getComputedStyle($linkDOM).getPropertyValue("color"));
$linkDOM.style.setProperty("text-decoration", "none")
$linkDOM.style.setProperty("display", "block")
$linkDOM.style.width = "50%";
$linkDOM.style.textAlign = "center"
$linkDOM.style.marginLeft = "auto";
$linkDOM.style.marginRight = "auto";
$linkDOM.style.padding = "15px"
$linkDOM.style.borderRadius = "15px"
console.log($linkDOM.getAttribute("style")) 

const $html = document.documentElement;
$body = document.body;

let varDarkColor = getComputedStyle($html).getPropertyValue("--dark-color");
varYellowColor = getComputedStyle($html).getPropertyValue("--yelow-color");

console.log(varYellowColor);
console.log(varDarkColor);

$body.style.backgroundColor = varDarkColor;
$body.style.color = varYellowColor;

$html.style.setProperty("--dark-color", "#5c58a7")
varDarkColor = getComputedStyle($html).getPropertyValue("--dark-color");
$body.style.setProperty("background-color", varDarkColor);

const $seccion1 = document.querySelector("#seccion1");
const $seccion2 = document.querySelector("#seccion2");
const $seccion3 = document.querySelector("#seccion3");
const $seccion4 = document.querySelector("#seccion4");
const $seccion5 = document.querySelector("#seccion5");

$seccion1.setAttribute("style", "color: #b92f60");
$seccion2.setAttribute("style", "color: #b92f60");
$seccion3.setAttribute("style", "color: #b92f60");
$seccion4.setAttribute("style", "color: #b92f60");
$seccion5.setAttribute("style", "color: #b92f60");

console.log("=======CLASES CSS =======")
const $card = document.querySelector(".card");
console.log($card);
console.log($card.className)
console.log($card.classList)
console.log($card.classList.contains("rotate-45"));
$card.classList.add("rotate-45");
$card.classList.remove("rotate-45");
$card.classList.toggle("rotate-45");
console.log($card.classList.contains("rotate-45"));
/*
setInterval(()=>{
    $card.classList.toggle("rotate-45");
},1000)
*/

//$card.classList.replace("rotate-45", "rotate-135")

$card.classList.add("opacity-80", "sepia")

console.log("==== TEXTO Y HTML=====")

const $whatis = document.getElementById("que-es");

console.log($whatis)

let text = `
<p>
    El Modelo de Objetos del Documento (<b><i>DOM - Document Object Model </i></b>) es un                    
API para documentos HTML y XML.
    </p>
    <p>
    Éste provée una representación estructural del documento, permitiendo modificar su contenido y presentación visual mediante código JS.
    </p>
    <p>
        <mark> El DOM no es parte de la especificación de JavaScript, es una API para los navegadores.</mark>
    </p>
`
//$whatis.innerText = text;
$whatis.textContent = text;
$whatis.innerHTML = text;
//esto hara que separe los parrafos
//$whatis.outerHTML = text;

console.log("==== TRAVERSING RECORRIENDO DOM=====")

const $cards = document.querySelector(".cards");

console.log($cards);
console.log($cards.children);
console.log($cards.children[2]);
console.log($cards.parentElement);
console.log($cards.firstElementChild);
console.log($cards.previousElementSibling);
console.log($cards.nextElementSibling);
//me devolvera la misma seccion
console.log($cards.children[3].closest("section"));

console.log("CREANDO ELEMENTOS Y FRAGMENTOS");

const $figure = document.createElement("figure");
$img = document.createElement("img");
$figcaption = document.createElement("figcaption")
$figcaptionText = document.createTextNode("Animals");
const $figure2 = document.createElement("figure");



$img.setAttribute("src", "https://placeimg.com/200/200/animals");
$img.setAttribute("alt", "Animal");
//agregar un hijo(appende child agregara una etiqueta hija a una etiqueta padre)
$figcaption.appendChild($figcaptionText)
$figure.appendChild($img);
$figure.appendChild($figcaption);
$cards.appendChild($figure);
//en la etiqueta figura tendra la clase card
$figure.classList.add("card");

//agregaremos otra figura de otro modo
$figure2.innerHTML= `
<img src="https://placeimg.com/200/200/people" alt="people">
<figcaption>People</figcaption>
`;
$figure2.classList.add("card");
$cards.appendChild($figure2);

//

const estaciones = ["Primavera", "Invierno", "Verano"];
 $ul = document.createElement("ul");

 document.write("<h3>Estaciones del Año</h3>");

document.body.appendChild($ul);

estaciones.forEach((el) =>{
    const $li = document.createElement("li");
    $li.textContent = el;
    $ul.appendChild($li)
});

//


const continentes = ["Africa", "America", "Europa", "Asia", "Oceania"];
 $ul2 = document.createElement("ul");

 document.write("<h3>Continentes del Mundo</h3>")
 document.body.appendChild($ul2);

$ul2.innerHTML = "";

continentes.forEach((el)=> $ul2.innerHTML += `<li>${el}</li>`)


//

const meses = [
    "Enero",
    "Febrero",
    "Marzo",
    "Abril",
    "Mayo",
    "Junio",
    "Julio",
    "Agosto",
    "Septiembre",
    "Octubre",
    "Noviembre",
    "Diciembre"
];

document.write("<h3>Meses Del Año</h3>")
const $ul3 = document.createElement("ul");
 $fragmento = document.createDocumentFragment();

meses.forEach((el) =>{
    const $li3 = document.createElement("li");
    $li3.textContent = el;
    $fragmento.appendChild($li3);
});

document.body.appendChild($ul3);
$ul3.appendChild($fragmento);

//

console.log("====TEMPLATE HTML ====")


$template = document.getElementById("template-card").content;
$fragmento1 = document.createDocumentFragment();
cardContent = [
    {
        title: "Tecnología",
        img:"https://placeimg.com/200/200/tech"
    },
    {
        title: "Animales",
        img:"https://placeimg.com/200/200/animals"
    },
    {
        title: "Arquitectura",
        img:"https://placeimg.com/200/200/arch"
    },
    {
        title: "Gente",
        img:"https://placeimg.com/200/200/people"
    },
    {
        title: "Naturaleza",
        img:"https://placeimg.com/200/200/nature"
    }
];

cardContent.forEach((el) =>{
    $template.querySelector("img").setAttribute("src", el.img);
    $template.querySelector("img").setAttribute("alt", el.title);
    $template.querySelector("figcaption").textContent = el.title;

    //clonamos nuestro template(false = externo, true = interno)
    let $clone = document.importNode($template, true);

    $fragmento1.appendChild($clone);
})

$cards.appendChild($fragmento1);

console.log("====MODIFICANDO ELEMENTOS====")

const $newCard = document.createElement("figure");
//clonaremos toda la seccion(true=todo el contenido)
$cloneCards = $cards.cloneNode(true);

$newCard.innerHTML = `
<img src="https://placeimg.com/200/200/any" alt="Any">
<figcaption>Any</figcaption>
`;

$newCard.classList.add("card");

//remplazar nuestra imagen people por any
//$cards.replaceChild($newCard, $cards.children[2]);
//insertar antes de la primera figura
//$cards.insertBefore($newCard, $cards.firstElementChild)

//para eliminar la figura people
//$cards.removeChild($cards.children[2]);

//insertaremos nuestra imagen clonada en el body
document.body.appendChild($cloneCards);

console.log("====MODIFICANDO ELEMENTOS (COOL STYLE)")

/* 
.insertAdjacent...
    .insertAdjacentElement(position,el)
    .insertAdjacentHTML(position,html)
    .insertAdjacentText(position,text)

posiciones:
    beforebegin (hermano anterior)
    afterbegin (primer hijo)
    beforeend (ultimo hijo)
    afterend  (hermano siguiente)
*/

//EN REFERENCIA ALA CLASE ANTERIOR $newCard

const $newCard2 = document.createElement("figure");

$newCard2.classList.add("card");

let $contenCard = `
<img src="https://placeimg.com/200/200/any" alt="Any">
<figcaption></figcaption>
`;


//$newCard2.insertAdjacentHTML("beforeend", $contenCard);
//HACERLO DIRECTAMENTE DESDE LA SECCION
$newCard2.innerHTML= $contenCard;
$cards.insertAdjacentElement("afterend", $newCard2 );
$newCard2.querySelector("figcaption").insertAdjacentText("afterbegin", "ANY");

//CARACTERISITICAS PARA COLOCAR NUESTRA NEWCARD A LA SECCION 
//$cards.prepend($newCard2);
//$cards.before($newCard2);
//$cards.append($newCard2);
//$cards.after($newCard2);


console.log("==MANEJADORES DE EVENTOS===")

function holaMundo(){
    alert("Hola Mundo");
    console.log(event);  
};
const $eventoSemantico = document.getElementById("evento-semantico");
const $eventoMultiple = document.getElementById("evento-multiple");

$eventoSemantico.onclick = holaMundo;
$eventoSemantico.onclick = function (e){
 alert("Hola Manejador de Evento Semanticos")
 console.log(e);
 console.log(event);
};

$eventoMultiple.addEventListener("click", holaMundo)
$eventoMultiple.addEventListener("click", (e)=>{
    alert("Hola Manejador de Evento Multiples")
    console.log(e);
    console.log(e.type);
    console.log(e.target);
})

console.log("==Eventos con Parametros y Remover Eventos==")

function saludar(nombre= "Desconocid@"){
    alert(`Hola ${nombre}`)
    console.log(event)
}
$eventoMultiple.addEventListener("click", () =>{
saludar(),
saludar("Alex")
});

const $eventoRemover = document.getElementById("evento-remover");

const removerDobleClick = (e) =>{
    alert(`Removiendo el evento de tipo ${e.type}`);
    console.log(e);
    $eventoRemover.removeEventListener("dblclick", removerDobleClick);
};

$eventoRemover.addEventListener("dblclick", removerDobleClick);

console.log("==FLUJOS DE EVENTOS BURBUJA,CAPTURA Y  CLASE STOP PROPAGATION===")
const $divsEventos = document.querySelectorAll(".eventos-flujos div");
 $linkEventos = document.querySelector(".eventos-flujos a");

function flujoEventos(e){
    console.log(`Hola ${this.className}, el click lo origino: ${e.target.className}`);
    //stopprogration hara que no se extienda o progage mas
    //e.stopPropagation();
}

console.log($divsEventos)

$divsEventos.forEach((div) =>{
    //div.addEventListener("click", flujoEventos);
    //FASE DE BURBUJA
    //div.addEventListener("click", flujoEventos, false);
    //FALSE DE CAPTURA
    //div.addEventListener("click", flujoEventos, true);
    //una sola vez se ejecuta
    /*
    div.addEventListener("click", flujoEventos,{
        capture:false,
        once: true,
    }); 
    */
});

$linkEventos.addEventListener("click", (e)=>{
    alert(`Hola soy tu amigo y docente digital JonMircha`);
    e.preventDefault();
    //NO REQUIERE UN STOP PROPAGATION
});


console.log("===DELEGACION DE EVENTOS==")
//con este nuevo evento no necesitaremos un stop propagacion ya que no existe un elemento padre

document.addEventListener("click", (e)=>{
    console.log("Click en", e.target);

    if(e.target.matches(".eventos-flujos div")){
    flujoEventos(e);
    }
    
    if(e.target.matches(".eventos-flujos a")){
    alert(`Hola soy tu amigo y docente digital JonMircha`);
    e.preventDefault();
    }
})

console.log("==(BOOM)PROPIEDADES Y EVENTOS===")
/*
window.addEventListener("resize", (e) =>{
    console.clear();
    console.log("**EVENTO RESIZE***");
    console.log(window.innerWidth);
    console.log(window.innerHeight);
    console.log(window.outerWidth)
    console.log(window.outerHeight)
    console.log(e);
})

*/

window.addEventListener("scroll", (e) =>{
    console.clear();
    console.log("**EVENTO SCROLL***");
    console.log(window.scrollX);
    console.log(window.scrollY);
    console.log(e);
});

/*
window.addEventListener("load", e=>{
    
    console.log("**EVENTO LOAD***");
    console.log(window.screenX)
    console.log(window.screenY)
    console.log(e);
})



*/
document.addEventListener("DOMContentLoaded", (e)=>{
    
    console.log("**EVENTO DOOMContentLoad***");
    console.log(window.screenX)
    console.log(window.screenY)
    console.log(e);
})
console.log("===CLASE METODOS BOOM==")

//window.confirm("Confirmacion")
//window.prompt("Aviso");
const $btnAbrir = document.getElementById("abrir-ventana");
const $btnCerrar = document.getElementById("cerrar-ventana");
const $btnImprimir = document.getElementById("imprimir-ventana");

let ventana;

$btnAbrir.addEventListener("click", e=>{
 ventana = window.open("https://jonmircha.com");
})
$btnCerrar.addEventListener("click", e=>{
 //window.close();
 ventana.close();
})
$btnImprimir.addEventListener("click", e=>{
    window.print();
})

console.log("*********OBJETO URL (location)********")
console.log(location);
console.log(location.origin);
console.log(location.protocol);
console.log(location.host);
console.log(location.hostname);
console.log(location.port);
console.log(location.href);
//valor de la url despues de un hash
console.log(location.hash);
//cuando pasas valores en la url
console.log(location.search);
console.log(location.pathname);

console.log(history);
console.log("*********OBJETO NAVEGADOR********")
console.log(navigator)
console.log(navigator.connection);
console.log(navigator.geolocation)
console.log(navigator.mediaDevices);
console.log(navigator.mimeTypes)
console.log(navigator.online)
console.log(navigator.serviceWorker);
console.log(navigator.storage)
console.log(navigator.usb)
console.log(navigator.userAgent)
