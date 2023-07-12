package org.rdurandk.patrones.composite3;

public class ComponenteInternosMuebles implements Componente{
    private String nombre;
    private int precio;

    public ComponenteInternosMuebles(String nombre, int precio) {//objetos compuestos por el objeto individual
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public int calcularCosto() {
        return getPrecio();
    }
}
