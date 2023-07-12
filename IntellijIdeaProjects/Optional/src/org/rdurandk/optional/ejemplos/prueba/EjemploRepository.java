package org.rdurandk.optional.ejemplos.prueba;

import org.rdurandk.optional.ejemplos.prueba.models.Compu;
import org.rdurandk.optional.ejemplos.prueba.models.CompuRepository;
import org.rdurandk.optional.ejemplos.prueba.models.Repository;

import java.util.Optional;

public class EjemploRepository {
    public static void main(String[] args) {
        Repository<Compu> repo = new CompuRepository();
        /*Optional<Compu> opt = repo.filtrar("Rogs");
        if(opt.isPresent()){
            System.out.println(opt.get());
        }else{
            System.out.println("No se encontro");
        }*/
        repo.filtrar("rog").ifPresentOrElse((valor)-> System.out.println(valor),
                ()-> System.out.println("No se encontro"));
    }
}
