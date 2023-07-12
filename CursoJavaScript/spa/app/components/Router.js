import { ajax } from "../helpers/ajax.js";
import api from "../helpers/wp_api.js";
import { ContactForm } from "./ContactForm.js";
import { Post } from "./Post.js";
import { PostCard } from "./PostCard.js";
import { SearchCard } from "./SearchCard.js";


export async function Router() {
    const d = document;
    const w = window;
    const $main = d.getElementById("main");
    let { hash } = location;
    //console.log(hash);

    $main.innerHTML = null;

    if (!hash || hash === "#/") {
        await ajax({
            url: api.POSTS,
            cbSuccess: (posts) => {
                console.log(posts);
                let html = "";
                posts.forEach(post => html += PostCard(post));
                //d.querySelector(".loader").style.display = "none";
                $main.innerHTML = html;
            }
        });
        //console.log(api.POST);
    } else if (hash.includes("#/search")) {
        let query = localStorage.getItem("wpSearch");
        
        if (!query) {
            d.querySelector(".loader").style.display = "none";
            return false;
        }
        //caso contrario
        await ajax({
            url: `${api.SEARCH}${query}`,
            cbSuccess: (search) => {
                console.log(search);
                let html = "";
                //si nuestro array search no busco ningun valor respecto al input
                if (search.length === 0) {
                    html = `
                    <p class="error">
                    No existen resultado de busqueda para el termino
                    <mark>${query}</mark>
                    </p>
                    `;
                } else {
                    search.forEach(post => html += SearchCard(post));
                }
                $main.innerHTML = html;
            }
        })
    } else if (hash === "#/contacto") {
        $main.appendChild(ContactForm())
    } else {

        await ajax({
            url: `${api.POST}/${localStorage.getItem("wpPostId")}`,
            cbSuccess: (post) => {
                console.log(post);
                $main.innerHTML = Post(post);
            }
        });

    }
    //tiene que estar en modo async para que no repita
    d.querySelector(".loader").style.display = "none";
}