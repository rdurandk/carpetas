import { PostCard } from "../components/PostCard.js";
import { SearchCard } from "../components/SearchCard.js";
import { ajax } from "./ajax.js";
import api from "./wp_api.js"
export async function InfiniteScroll() {
    const d = document,
        w = window;

    let query = localStorage.getItem("wpSearch"),
        apiURL,
        Component;//High Order Component


    w.addEventListener("scroll", async e => {
        let { scrollTop, clientHeight, scrollHeight } = d.documentElement,
            { hash } = window.location;

        console.log(scrollTop, clientHeight, scrollHeight, hash);
        if (scrollTop + clientHeight >= scrollHeight) {
            api.page++;

            if (!hash || hash === "#/") {
                
                apiURL = `${api.POSTS}&page=${api.page}`;
                Component = PostCard;
                console.log("home")

                
            } else if (hash.includes("#/search")) {
               
                apiURL = `${api.SEARCH}${query}&page=${api.page}`;
                Component = SearchCard;
                console.log("search")

            } else {
                return false;
            }

            d.querySelector(".loader").style.display = "block";
            await ajax({
                url: apiURL,
                cbSuccess: (posts) => {
                    console.log(posts);
                    let html = "";
                    posts.forEach(post => html += Component(post));
                    d.getElementById("main").insertAdjacentHTML("beforeend", html);
                }
            })
            d.querySelector(".loader").style.display = "none";
        }
    });
}