package org.rdurandk.patrones.factory.producto;

import org.rdurandk.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {//clase concreta

    public PizzaNewYorkItaliana(){
        super();
        nombre = "Pizza Italiana New York";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate italiano carne";
        ingredientes.add("Queso Mozarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Jamon");
        ingredientes.add("Choricillo");
        ingredientes.add("Champiñones");
    }
    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30min a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos grandes");
    }
}
