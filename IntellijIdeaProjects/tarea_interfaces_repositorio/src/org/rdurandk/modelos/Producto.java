package org.rdurandk.modelos;

public class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    private static int ultimoId;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = ++ultimoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
