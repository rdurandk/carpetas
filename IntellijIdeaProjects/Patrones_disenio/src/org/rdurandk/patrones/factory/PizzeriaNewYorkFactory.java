package org.rdurandk.patrones.factory;

import org.rdurandk.patrones.factory.producto.PizzaNewYorkItaliana;
import org.rdurandk.patrones.factory.producto.PizzaNewYorkPepperoni;
import org.rdurandk.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{

    @Override
    protected PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPepperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
        return producto;
    }
}
