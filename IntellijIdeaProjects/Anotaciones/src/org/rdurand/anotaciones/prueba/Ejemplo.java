package org.rdurand.anotaciones.prueba;

import org.rdurand.anotaciones.prueba.modelos.Product;
import org.rdurand.anotaciones.prueba.procesador.JsonSerial;

public class Ejemplo {
    public static void main(String[] args) {
        Product p = new Product("Mesa rEdonda de sala", 500);
        System.out.println("json = " + JsonSerial.convertirJson(p));
    }
}
