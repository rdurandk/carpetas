package org.rdurandk.patrones.observer2;

public interface Observer {
    //patrón de diseño Observer puede ser aplicado es cuando tenemos un sistema en el que múltiples
    //objetos necesitan ser notificados cuando otro objeto cambia de estado.
    void update(String mensaje);
}
