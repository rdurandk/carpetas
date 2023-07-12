package org.rdurandk.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class tarea4 {
    public static void main(String[] args) {
        Producto prod1 = new Producto(30,2);
        Producto prod2 = new Producto(50,3);
        Producto prod3 = new Producto(20,4);

        List<Producto> productoList = Arrays.asList(prod1, prod2, prod3);
        double suma = productoList.stream()
                .mapToDouble(prod -> prod.getPrecio() * prod.getCantidad())
                .sum();
        System.out.println("Gran total: " + suma);
    }
}
