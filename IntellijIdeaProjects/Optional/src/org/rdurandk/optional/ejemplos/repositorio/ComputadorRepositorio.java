package org.rdurandk.optional.ejemplos.repositorio;

import org.rdurandk.optional.ejemplos.models.Computador;
import org.rdurandk.optional.ejemplos.models.Fabricante;
import org.rdurandk.optional.ejemplos.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{

    private List<Computador> dataSource ;
    public ComputadorRepositorio() {
        this.dataSource = new ArrayList<>();
        Procesador proc = new Procesador("AMD-1980k", new Fabricante("AMD"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(proc);
        dataSource.add(asus);
        dataSource.add(new Computador("MacBOOK Pro", "MVVK2CI"));
        dataSource.add(new Computador("Rog Pro", "MVVK2CI"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        /*for(Computador c:this.dataSource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }*/
        return this.dataSource.stream()
                .filter(el -> el.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();
    }
}
