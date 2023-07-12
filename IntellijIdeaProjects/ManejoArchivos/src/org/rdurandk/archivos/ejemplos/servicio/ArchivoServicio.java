package org.rdurandk.archivos.ejemplos.servicio;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {
    public void crearArchivo(String nombre){
        File archivo = new File(nombre);//nombre del archivo
        try {
            FileWriter escritor = new FileWriter(archivo, true);//crear archivo
            //segundo parametro es un boolean sirve para anexar un archivo que existe
            BufferedWriter buffer = new BufferedWriter(escritor);//como un Filewriter
            //buffer si queremos utilizar textos de mayor capacidad
            buffer.append("Hola que tal\n")//retorna un writter
                    .append("Esto es un prueba escritura...\n")
                    .append("Hasta luego Aleex\n");
            buffer.close();//debe cerrar el recurso
            System.out.println("Archivo creado con exito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearArchivo2(String nombre){
        File archivo = new File(nombre);//nombre del archivo
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))){
            //try parentesis es para consumir un recurso y no es necesario cerrarlo manualmente
            //printwriter servira para escribir como si fuera un consola
            buffer.println("Hola que tal");//retorna un void
            buffer.println("Esto es un prueba escritura...");
            buffer.printf("Hasta luego %s", "Alexander");
            System.out.println("Archivo creado con exito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String leerArchivo(String nombre){
        StringBuilder sb = new StringBuilder();//para guardar el contenido del archivo
        File archivo = new File(nombre);
        String linea = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));//para leer
            while((linea = reader.readLine()) != null){//itera linea por linea
                sb.append(linea + "\n");
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public String leerArchivo2(String nombre){
        StringBuilder sb = new StringBuilder();//para guardar el contenido del archivo
        File archivo = new File(nombre);
        String linea = "";
        try {
            Scanner scanner = new Scanner(archivo);//para leer
            while(scanner.hasNext()){//itera linea por linea
                linea += scanner.next() + "\n";
            }
            sb.append(linea);
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
