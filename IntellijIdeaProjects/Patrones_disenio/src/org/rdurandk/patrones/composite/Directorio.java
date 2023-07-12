package org.rdurandk.patrones.composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente{//objeto individual
    private List<Componente> hijos = new ArrayList<>();;//para la recursividad
    public Directorio(String nombre, Double tamanio) {
        super(nombre, tamanio);
    }
    public Directorio(String nombre) {
        super(nombre);
    }
    public Directorio addComponente(Componente c){
        this.hijos.add(c);
        return this;
    }
    public void removeComponent(Componente c){
        this.hijos.remove(c);
    }
    @Override
    public String mostrar(int nivel) {
        StringBuilder sb = new StringBuilder("\t".repeat(nivel));
        sb.append(getNombre())
                .append("/")
                .append("\ttamanioTotal= " + calcularTamanio())
                .append("\n");
        for(Componente hijo: this.hijos){//aqui empieza una recursividad
            sb.append(hijo.mostrar(nivel+1));//mostrara el nombre de cada hijo(recursiva)
                if(hijo instanceof Archivo){//condicion para no saltar dos veces al final
                        sb.append("\n");
                }
        }
        return sb.toString();
    }
    @Override
    public boolean buscar(String nombre) {
        if(this.nombre.equalsIgnoreCase(nombre)){
            return true;
        }
        /*for(Componente hijo:this.hijos){
            if(hijo.buscar(nombre)){
                return true;
            }
        }*/
        return hijos.stream().anyMatch(hijo -> hijo.buscar(nombre));
    }

    @Override
    public Double calcularTamanio() {
        double tamanioTotal=0;
        for(Componente componente:this.hijos){//aqui empieza una recursividad
            tamanioTotal += componente.calcularTamanio();
        }
        return tamanioTotal;
    }
}
