package org.rdurandk.api.stream.ejemplos.tarea;

public class Producto {
    private double precio;
    private int cantidad;

    public Producto(double precio, int cantidad){
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
