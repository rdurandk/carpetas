package org.rdurandk.patrones.composite2;

import java.util.ArrayList;
import java.util.List;

public class Tarea implements ItemProyecto{

    private String nombre;
    private int numHora=0;
    private Responsable responsable;
    private List<ItemProyecto> itemTarea = new ArrayList<>();

    public Tarea(String nombre, Responsable responsable) {
        this.nombre = nombre;
        this.responsable = responsable;

    }
    public Tarea(String nombre, Responsable responsable, int numHora) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.numHora = numHora;
    }

    public String getNombre() {
        return nombre;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void addItemTarea(ItemProyecto item){
        if(!itemTarea.contains(item)){
            itemTarea.add(item);
        }
    }

    @Override
    public int getTiempo() {
        int tiempoTotal = numHora;
        for(ItemProyecto item: itemTarea){
            tiempoTotal += item.getTiempo();
        }
        return tiempoTotal;
    }

    @Override
    public void imprimir() {
        System.out.println("\t"+this.nombre + " HORAS " + getTiempo());
        for(ItemProyecto item:itemTarea){
            System.out.print("\t\t");
            item.imprimir();
        }
    }
}
