import stripeKeys from "./stripe-keys.js";

//console.log(stripeKeys);

const d = document;
const $bebidas = d.getElementById("bebidas");
const $template = d.getElementById("bebidas-template").content;
const $fragment = d.createDocumentFragment();
const fetchOptions = {
    headers: {
        Authorization: `Bearer ${stripeKeys.secret}`,
    }
}

let prices, products;

const moneyFormat = (num) => `S/${num.slice(0, -2)}.${num.slice(-2)}`;
Promise.all([
    fetch("https://api.stripe.com/v1/products", fetchOptions),
    fetch("https://api.stripe.com/v1/prices", fetchOptions)
])
    //Map crea un nuevo array con los resultados de la llamada a la función indicada 
    .then((res) => Promise.all(res.map(response => response.json())))
    .then(json => {
        console.log(json);
        let products = json[0].data;
        let prices = json[1].data;
        console.log(products, prices);

        prices.forEach(el => {
            let productData = products.filter(product => product.id === el.product)
            console.log(productData)

            $template.querySelector("img").setAttribute("src", productData[0].images[0]);
            $template.querySelector("img").setAttribute("alt", productData[0].name);

            $template.querySelector(".bebida").setAttribute("data-price", el.id);
            $template.querySelector("img").setAttribute("data-price", el.id);
            $template.querySelector("figcaption").setAttribute("data-price", el.id);

            $template.querySelector("figcaption").innerHTML = `
         ${productData[0].name}
         <br>
         ${moneyFormat(el.unit_amount_decimal)} ${el.currency.toUpperCase()}
        `;

            let $clone = d.importNode($template, true);
            $fragment.appendChild($clone);
        });

        $bebidas.appendChild($fragment);
    })
    .catch(err => {
        console.log(err);
        let message = err.statusText || "Ocurrio un error al conectar con la API";
        $bebidas.innerHTML = `<p>Error: ${err.status}: ${message}</p>`
    })


d.addEventListener("click", e => {

    //e.target sera la etiqueta figure y todo lo que venga adentro
    if (e.target.matches(".bebida") || e.target.matches(".bebida *")) {
        let price = e.target.getAttribute("data-price");
        console.log(price);

        //El metodo Stripe viene en la libreria que importamos en nuestro html
        Stripe(stripeKeys.public)
            .redirectToCheckout({
                lineItems: [{ price, quantity: 1 }],
                mode: "subscription",
                successUrl:
                    "http://127.0.0.1:5500/ajx-ejercicios/assets/stripe-success.html",
                cancelUrl: "http://127.0.0.1:5500/ajx-ejercicios/assets/stripe-cancel.html"
            })
            .then((res) => {
                console.log(res);
                if (res.error) {
                    $bebidas.insertAdjacentHTML("afterend", res.error.message);
                }
            })

    }
})

