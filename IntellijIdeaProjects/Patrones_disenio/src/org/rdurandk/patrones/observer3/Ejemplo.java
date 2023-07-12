package org.rdurandk.patrones.observer3;

public class Ejemplo {
    public static void main(String[] args) {
        Observador user1 = new Usuario("Alex");
        Observador user2 = new Usuario("Silvia");
        Observador user3 = new Usuario("Jessica");
        EstacionClima clima = new EstacionClima();
        clima.suscribir(user1);
        clima.suscribir(user2);
        clima.suscribir(user3);
        clima.setNombreClima("Soleado");
    }
}
