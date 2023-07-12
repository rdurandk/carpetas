package org.rdurandk.patrones.factory.producto;

import org.rdurandk.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {//clase concreta

    public PizzaNewYorkVegetariana() {
        super();
        nombre = "Pizza vegetariana New York";
        masa = "Masa integral vegana";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Berenjenas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25min a 150°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas");
    }
}
