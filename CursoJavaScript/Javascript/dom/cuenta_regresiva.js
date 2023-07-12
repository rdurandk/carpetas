const d = document;
export default function countdown(id, limitDate, finalMessage) {
    
    const $countdown = d.getElementById(id);
    const $countdownDate = new Date(limitDate).getTime();

    let countdownTempo = setInterval(() => {
        let now = new Date().getTime();
        let limitMls = $countdownDate - now;
        let MlsDay = 86400000;
        let MlsHour = 3600000;
        let MlsMin = 60000;
        let MlsSec = 1000
        let day = Math.floor(limitMls / MlsDay);
        let hour = ("0" + Math.floor((limitMls % MlsDay) / MlsHour)).slice(-2);
        let min = ("0" + Math.floor((limitMls % MlsHour) / MlsMin)).slice(-2);
        let sec = ("0" + Math.floor((limitMls % MlsMin) / MlsSec)).slice(-2);

        $countdown.innerHTML = `<h3>Faltan: ${day}dias ${hour}horas ${min}minutos ${sec}segundos </h3>`
 
        if(limitMls < 0){
            clearInterval(countdownTempo);
            $countdown.innerHTML=`${finalMessage}`;
        }

    }, 1000)

}