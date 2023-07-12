<?php

if(isset($_FILES["file"])){
    $name = $_FILES["file"]["name"];
    $file = $_FILES["file"]["tmp_name"];
    $destino = "files/$name";
    $upload = move_uploaded_file($file, $destino);

    if($upload){
        $res = array(
            "error" => false,
            "status" => http_response_code(200),
            "statusText" => "Archivo Subido con exito",
            "file" => $_FILES["file"]
        );
    }else{
        $res = array(
            "error" => true,
            "status" => http_response_code(404),
            "statusText" => "Error al subir el arhico en el servidor",
            "file" => $_FILES["file"]
        );
    }

    echo json_encode($res);
}
?>