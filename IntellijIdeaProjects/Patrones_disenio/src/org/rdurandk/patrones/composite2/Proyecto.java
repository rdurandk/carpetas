package org.rdurandk.patrones.composite2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto implements ItemProyecto{
    private String nombreP;
    private Responsable responsable;
    private List<ItemProyecto> itemProyecto = new ArrayList<>();

    public Proyecto(String nombreP, Responsable responsable) {
        this.nombreP = nombreP;
        this.responsable = responsable;
    }

    public void addItemProyecto(ItemProyecto item){
        if(!itemProyecto.contains(item)){
            itemProyecto.add(item);
        }
    }

    public String getNombre() {
        return nombreP;
    }

    @Override
    public int getTiempo() {
        int tiempoTotal=0;
        for(ItemProyecto item:itemProyecto){
            tiempoTotal += item.getTiempo();
        }
        return tiempoTotal;
    }

    @Override
    public void imprimir() {
        System.out.println(this.nombreP + " HORAS " + getTiempo());
        for(ItemProyecto item:itemProyecto){
            if(item instanceof Proyecto){
                System.out.println();
            }
            System.out.print("\t");
            item.imprimir();
        }
    }
}
