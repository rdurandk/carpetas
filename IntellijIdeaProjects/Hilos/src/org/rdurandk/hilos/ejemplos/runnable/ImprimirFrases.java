package org.rdurandk.hilos.ejemplos.runnable;

//import static org.rdurandk.hilos.ejemplos.EjemploSincronizacionThread.imprimirFrases;

import org.rdurandk.hilos.ejemplos.EjemploSincronizacionThread;

public class ImprimirFrases implements Runnable{

    private String frase1, frase2;

    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        EjemploSincronizacionThread.imprimirFrases(this.frase1, this.frase2);
    }
}
