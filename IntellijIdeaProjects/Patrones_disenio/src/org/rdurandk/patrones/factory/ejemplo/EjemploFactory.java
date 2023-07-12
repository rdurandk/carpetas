package org.rdurandk.patrones.factory.ejemplo;

import org.rdurandk.patrones.factory.PizzaProducto;
import org.rdurandk.patrones.factory.PizzeriaCaliforniaFactory;
import org.rdurandk.patrones.factory.PizzeriaNewYorkFactory;
import org.rdurandk.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaNewYorkFactory ny = new PizzeriaNewYorkFactory();//usar el tipo mas generico o abstracto
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza "+pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Andres ordena una " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("James ordena " + pizza.getNombre());

        pizza = ny.ordenarPizza("vegetariana");
        System.out.println("Lunes ordena la pizza " + pizza.getNombre());

        pizza = california.ordenarPizza("pepperoni");
        System.out.println("Jon ordena la pizza " + pizza.getNombre());

        System.out.println(pizza);
    }
}
