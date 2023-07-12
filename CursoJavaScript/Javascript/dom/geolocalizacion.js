const d = document;
const n = navigator;
export default function getGeolocation(id){

    const $id = d.getElementById(id);

    const options = {
            enableHighAccuracy: false,
            timeout: 5000,
            maximumAge: 0
        };

    const success = e =>{
        let coords = e.coords;
        //console.log(e);
        
        $id.innerHTML = `
        <p>Tu posicion actual es: </p>
        <ul>
        <li>Latitud: <b>${coords.latitude}</b></li>
        <li>Latitud: <b>${coords.longitude}</b></li>
        <li>Presicion: <b>${coords.accuracy}</b>metros</li>
        </ul>
        <a href="https://www.google.com/maps/@${coords.latitude},${coords.longitude},20z"
        target="_blank" rel="noopener">Ver en Google Maps</a>
        `;
        
 
    };

    const error = err =>{
        $id.innerHTML= `<p><mark>Error ${err.code}: ${err.message}</mark></p>`;
        console.log(`Error ${err.code}: ${err.message}`);
    };

    n.geolocation.getCurrentPosition(success,error,options);
}