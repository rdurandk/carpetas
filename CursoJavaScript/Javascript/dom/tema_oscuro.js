const d= document;
const ls= localStorage;
export default function darkTheme(btn, darkTema){
    
    const $darkBtn = d.querySelector(btn);
    const $selectores = d.querySelectorAll("[data-dark]");
    let moon = "🌙";
    let sun = "☀️"
    const LightMode = () =>{
        $selectores.forEach((el)=>el.classList.remove(darkTema));
        $darkBtn.textContent = moon;
        ls.setItem("theme", "light");
    }
    const DarkMode = () =>{
        $selectores.forEach((el) =>el.classList.add(darkTema));
        $darkBtn.textContent = sun;
        ls.setItem("theme", "dark");
    }

    d.addEventListener("click", e=>{
        if(e.target.matches(btn)){
            if($darkBtn.textContent === moon){
                DarkMode();
            }else{
                LightMode();
            }
        }
    });

    d.addEventListener("DOMContentLoaded", e=>{
        if(ls.getItem("theme")===null) ls.setItem("theme", "light");
        if(ls.getItem("theme")==="light") LightMode();
        if(ls.getItem("theme")==="dark") DarkMode();
    });

}