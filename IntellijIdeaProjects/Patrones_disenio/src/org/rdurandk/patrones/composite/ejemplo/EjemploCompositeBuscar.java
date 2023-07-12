package org.rdurandk.patrones.composite.ejemplo;

import org.rdurandk.patrones.composite.Archivo;
import org.rdurandk.patrones.composite.Directorio;

public class EjemploCompositeBuscar {
    public static void main(String[] args) {
        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx", 302D));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx",205.3));

        java.addComponente(stream);
        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx", 400.5));
        doc.addComponente(new Archivo("logo.jpeg", 90D));

        boolean encontrado = doc.buscar("patron-composite.docx");
        System.out.println("Encontrado \"patron-composite.docx\": " +encontrado);

        encontrado = doc.buscar("Api Stream");
        System.out.println("Encontrado Api Stream: " + encontrado);

        encontrado = doc.buscar("logo.jpeg");
        System.out.println("Encontrado logo.jpeg: " + encontrado);
        //System.out.println(doc.mostrar(0));
    }
}
