package org.rdurandk.patrones.factory.producto;

import org.rdurandk.patrones.factory.PizzaProducto;

public class PizzaNewYorkPepperoni extends PizzaProducto {//clase concreta

    public PizzaNewYorkPepperoni() {
        super();
        nombre = "Pizza pepperoni New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra pepperoni");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40min. a 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos");
    }
}
