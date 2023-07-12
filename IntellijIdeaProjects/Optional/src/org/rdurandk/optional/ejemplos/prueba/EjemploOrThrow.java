package org.rdurandk.optional.ejemplos.prueba;

import org.rdurandk.optional.ejemplos.prueba.models.Compu;
import org.rdurandk.optional.ejemplos.prueba.models.CompuRepository;
import org.rdurandk.optional.ejemplos.prueba.models.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

public class EjemploOrThrow {
    public static void main(String[] args) {
        Repository<Compu> pc = new CompuRepository();
        Compu cp = pc.filtrar("Asus").orElseThrow(()->  new NoSuchElementException());
        System.out.println(cp);

        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .map(doc -> doc.substring(doc.lastIndexOf(".")+1))
                .orElseThrow();

        System.out.println(extension);

    }
}
