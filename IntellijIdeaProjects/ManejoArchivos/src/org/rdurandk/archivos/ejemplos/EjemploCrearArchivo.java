package org.rdurandk.archivos.ejemplos;

import org.rdurandk.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\alex\\Documents\\IntellijIdeaProjects\\" + //ruta donde va crear un archivo
                "ManejoArchivos\\src\\org\\rdurandk\\archivos\\ejemplos\\servicio\\archivo\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo2(nombreArchivo);

    }
}
