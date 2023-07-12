const d = document;
const w = window;
export default function ScrollTopBtn(btn){
    
    const $scrollBtn = d.querySelector(btn);
    
    w.addEventListener("scroll", (e) =>{  
        let scrollTop = w.pageYOffset || d.documentElement.scrollTop;    
        //Cualquiera de los 3 son iguales
        //console.log(w.pageYOffset, d.documentElement.scrollTop, w.scrollY);
        if(scrollTop > 300){     
            $scrollBtn.classList.remove("hidden");
        }else{
            $scrollBtn.classList.add("hidden");
        }
    });
    d.addEventListener("click", e=>{
        
        if(e.target.matches(btn)){
            //con esta funcion de scroll devolveremos a su eje Y a 0
            w.scrollTo({
                behavior: "smooth",
                top: 0
            })
        }
    });
}