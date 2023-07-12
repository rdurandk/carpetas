package org.rdurandk.archivos.ejemplos;

import org.rdurandk.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\alex\\Documents\\IntellijIdeaProjects\\" + //ruta donde va leer
                "ManejoArchivos\\src\\org\\rdurandk\\archivos\\ejemplos\\servicio\\archivo\\java.txt";

        ArchivoServicio servicio = new ArchivoServicio();
        System.out.println(servicio.leerArchivo(nombreArchivo));
    }
}
