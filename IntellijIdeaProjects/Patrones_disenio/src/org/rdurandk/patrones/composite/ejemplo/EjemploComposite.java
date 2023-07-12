package org.rdurandk.patrones.composite.ejemplo;

import org.rdurandk.patrones.composite.Archivo;
import org.rdurandk.patrones.composite.Directorio;

public class EjemploComposite {
    public static void main(String[] args) {
        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx", 302D));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx",205.3));

        java.addComponente(stream);
        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx", 400.5));
        doc.addComponente(new Archivo("logo.jpeg", 90.5));

        System.out.println(doc.mostrar(0));
    }
}
