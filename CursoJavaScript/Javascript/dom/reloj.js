const d=document;

export function DigitalClock(clock, btnPlay, btnStop){

    let IntervalTiempo;

    d.addEventListener("click", e=>{
        if(e.target.matches(btnPlay)){
            
            IntervalTiempo = setInterval(()=>{
                let hora = new Date().toLocaleTimeString();
                d.querySelector(clock).innerHTML = `${hora}`;
            },1000)
            e.target.disabled = true;
        }
        if(e.target.matches(btnStop)){
            clearInterval(IntervalTiempo);
            d.querySelector(clock).innerHTML = null;
            d.querySelector(btnPlay).disabled=false;
        }
    });
    
}



export function DigitalAlarm(sound, btnPlay, btnStop){

    let IntervalAlarma;
    const $alarm = d.createElement("audio");
    $alarm.src = sound;
    d.addEventListener("click", e=>{
        if(e.target.matches(btnPlay)){
            IntervalAlarma = setInterval(()=>{
                $alarm.play();
            })
        }
        if(e.target.matches(btnStop)){
            clearInterval(IntervalAlarma);
            $alarm.pause();
            //esto es para un stop
            //$audio.currentTime =0;
        }
    });
    
}