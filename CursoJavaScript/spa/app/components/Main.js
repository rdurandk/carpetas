export function Main(){
    const $main = document.createElement("main");
    $main.id= "main";

    //solo agrega grid fluid a los hash que sean diferentes de search
    if(!location.hash.includes("#/search")){
        $main.classList.add("grid-fluid");
    }
    
    return $main;
}