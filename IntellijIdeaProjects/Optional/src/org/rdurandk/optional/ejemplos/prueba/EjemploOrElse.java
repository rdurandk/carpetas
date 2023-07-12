package org.rdurandk.optional.ejemplos.prueba;

import org.rdurandk.optional.ejemplos.prueba.models.Compu;
import org.rdurandk.optional.ejemplos.prueba.models.CompuRepository;
import org.rdurandk.optional.ejemplos.prueba.models.Repository;

public class EjemploOrElse {
    public static void main(String[] args) {
        Repository<Compu> repo = new CompuRepository();

        Compu cp = repo.filtrar("rogs").orElse(valorDefecto());
        System.out.println(cp);

        cp = repo.filtrar("rog").orElseGet(()->valorDefecto());
        System.out.println(cp);

    }
    public static Compu valorDefecto(){
        System.out.println("Valor por defecto: ");
        return new Compu("Sonic", "SONIC20120");
    }
}
