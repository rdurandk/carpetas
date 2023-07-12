package org.rdurand.tarea;

public class EjemploGerente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Alexander","Durand","77390505","Lima-Peru",2000,190000000);
        System.out.println(gerente);

        System.out.println();
        Gerente gerente2 = new Gerente("Alvaro","Bazan","06598787","Lima-Peru",2500,190000000);
        gerente2.setPresupuesto(150000000);
        gerente2.aumentarRemuneracion(15);
        System.out.println(gerente2);


    }
}
