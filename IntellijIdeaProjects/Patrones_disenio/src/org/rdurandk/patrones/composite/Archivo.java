package org.rdurandk.patrones.composite;

public class Archivo extends Componente {//composiciones del objeto individual

    public Archivo(String nombre, Double tamanio) {
        super(nombre, tamanio);
    }

    @Override
    public String mostrar(int nivel) {
        return "\t".repeat(nivel) + nombre;
    }

    @Override
    public boolean buscar(String nombre) {
        return this.nombre.equalsIgnoreCase(nombre);
    }

    @Override
    public Double calcularTamanio() {
        return this.tamanio;
    }
}
