package org.rdurandk.optional.ejemplos.prueba.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompuRepository implements Repository<Compu>{

    private List<Compu> datasource ;
    public CompuRepository(){
        this.datasource = new ArrayList<>();
        Compu c1 = new Compu("Asus Rog" , "Strix G512");
        Compu c2 = new Compu("Lenovo GA" , "Len 18080");
        this.datasource.add(c1);
        this.datasource.add(c2);
    }
    @Override
    public Optional<Compu> filtrar(String nombre) {
        return this.datasource.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();
    }
}
