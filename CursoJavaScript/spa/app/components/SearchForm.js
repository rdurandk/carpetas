export function SearchForm() {
    const d = document,
        $form = d.createElement("form"),
        $input = d.createElement("input");

    $form.classList.add("search-form");
    $input.name = "search";
    $input.type = "search";
    $input.placeholder = "Buscar...";
    $input.autocomplete = "off";
    $form.appendChild($input);


    //para que el valor del input se quede al presionar enter
    if (location.hash.includes("#/search")) {
        $input.value = localStorage.getItem("wpSearch");
    }


    //REMOVE SEARCH
    d.addEventListener("search", e => {
        if (!e.target.matches("input[type='search']")) {
            return false
        } else {
            //caso contrario
            if (!e.target.value) localStorage.removeItem("wpSearch")
        };

    })

    d.addEventListener("submit", e => {
        if (!e.target.matches(".search-form")) return false;
        //caso contrario
        e.preventDefault();
        localStorage.setItem("wpSearch", e.target.search.value);
        location.hash = `#/search?search=${e.target.search.value}`;
    });
    return $form;
}