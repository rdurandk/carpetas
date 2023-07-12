package org.rdurandk.patrones.composite3;

import org.rdurandk.patrones.composite3.Componente;

import java.util.ArrayList;
import java.util.List;

public class Mueble implements Componente {//objeto individual

    private String nombre;
    private List<Componente> componente = new ArrayList<>();

    public Mueble(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void addComp(Componente comp){
        this.componente.add(comp);
    }

    @Override
    public int calcularCosto() {
        int costoTotal=0;
        for(Componente componente:componente){
            costoTotal += componente.calcularCosto();
        }
        return costoTotal;
    }
}
