<?php


if(isset($_FILES["file"])){
  
  $name = $_FILES["file"]["name"];
  $type = $_FILES["file"]["type"];
  $file =  $_FILES["file"]["tmp_name"];
  $destino = "files/$name";
  $upload = move_uploaded_file($file, $destino);

  

  if($upload){
    $res = array(
      "error" => false,
      "status" => http_response_code(200),
      "statusText" => "Archivo subido con exito :)",
      "files" => $_FILES["file"]
    );
  }else{
    $res = array(
      "error" => true,
      "status" => http_response_code(400),
      "statusText" => "Ocurrio un error en el servidor",
      "files" => $_FILES["file"]
    );
  }
  
  echo json_encode($res);
}






























/*
if(isset($_FILES["file"])) {
  $name = $_FILES["file"]["name"];
  $file = $_FILES["file"]["tmp_name"];
  $error = $_FILES["file"]["error"];
  $destination = "files/$name";
  $upload = move_uploaded_file($file, $destination);

    if($upload) {
    $res = array(
      "err" => false,
      "status" => http_response_code(200),
      "statusText" => "Archivo $name subido con éxito",
      "files" => $_FILES["file"]
    );
  } else {
    $res = array(
      "err" => true,
      "status" => http_response_code(400),
      "statusText" => "Error al subir el archivo $name",
      "files" => $_FILES["file"]
    );
  }

  echo json_encode($res);
    
}
*/
?>