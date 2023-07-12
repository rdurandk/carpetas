package org.rdurandk.patrones.observer3;

import java.util.ArrayList;
import java.util.List;

public class EstacionClima implements SujetoClima{//observable
    private List<Observador> observadores = new ArrayList<>();
    private String nombre;

    @Override
    public void suscribir(Observador observador) {
        this.observadores.add(observador);
    }

    @Override
    public void desuscribir(Observador observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for(Observador obs:this.observadores){
            obs.actualizar(nombre);
        }
    }
    public void setNombreClima(String nombre){
        this.nombre = nombre;
        notificarObservadores();
    }
}
