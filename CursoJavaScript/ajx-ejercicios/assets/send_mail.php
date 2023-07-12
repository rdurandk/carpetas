<?php
//isset si la variables o metodo esta definida
//cuando exista un metodo POST
    if(isset($_POST)){
        //que no envie reportes de errores
        error_reporting(0);
        $name = $_POST["name"];
        $email = $_POST["email"];
        $subject = $_POST["subject"];
        $comments = $_POST["comments"];

        //Obtiene el dominio desde donde se ejecuta esta pagina
        $domain = $_SERVER["HTTP_HOST"];
        $to = "rdurandk1997@gmail.com";
        $subject = "Contacto desde el formulario del Sitio $domain : $subject";
        $message = "
        <p>
        Datos enviados desde el formulario del sitio <b>$domain</b> 
        </p>
        <ul>
            <li>Nombre: <b>$name</b></li>
            <li>Email: <b>$email</b></li>
            <li>Subject: $subject</li>
            <li>Comentarios: $comments></li>
        </ul>
        ";

        //Nota: si no defino header lo envia en texto plano
        $headers = "MIME-Version: 1.0\r\n".//especifica el tipo de contenido que estas enviando
        "Content-type: text/html; charset=utf-8\r\n".//tipo de contenido que sea en formato texto html
        "From: Envio Automatico No Responder <no-reply@$domain>";//para que no vaya a los spams

        //ejecutar un email de php
        $send_mail = mail($to, $subject, $message, $headers);

        if($send_mail){
            $res = [
                "err" => false,
                "message" => "Tus datos han sido enviados",
                
            ];
        }else{
            $res = [
                "err" => true,
                "message" => "Error al enviar datos xd",
    
            ];
        }
        //politica y permiso de cors entre  mi servidor php y un servidor externo
        header("Access-Control-Allow-Origin: *");
        //header("Access-Control-Allow-Origin:https://jonmircha.com");
        //tipo de cabecera que esta respondiendo es en formato json
        header("Content-type: application/json");
        echo json_encode($res);
        exit;
    }
?>