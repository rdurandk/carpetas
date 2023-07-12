package org.rdurandk.patrones.factory;

public abstract class PizzeriaZonaAbstractFactory {
    public PizzaProducto ordenarPizza(String tipo){
        PizzaProducto pizza = crearPizza(tipo);
        System.out.println("-----Fabricando la pizza: " + pizza.getNombre() + "-----");
        pizza.preparar();
        pizza.cocinar();
        pizza.cortar();
        pizza.empaquetar();
        return pizza;
    }

    protected abstract PizzaProducto crearPizza(String tipo);
}
