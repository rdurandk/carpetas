package org.rdurandk.patrones.observer.ejemplos;

import org.rdurandk.patrones.observer.Corporacion;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver((observable, obj) -> {
            System.out.println("Jon" + observable);
        });

        google.addObserver((observable, obj)  -> {
            System.out.println("Andres" + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Maria" + observable);
        });

        google.modificarPrecio(2000);
    }
}
