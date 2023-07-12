package org.rdurandk.patrones.observer2;

public class Usuario implements Observer{//observador
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String mensaje) {
        System.out.println(this.nombre + " recibio un mensaje: " + mensaje);
    }
}
