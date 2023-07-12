package org.rdurandk.patrones.observer3;

public interface SujetoClima {
    void suscribir(Observador observador);
    void desuscribir(Observador observador);
    void notificarObservadores();
}
