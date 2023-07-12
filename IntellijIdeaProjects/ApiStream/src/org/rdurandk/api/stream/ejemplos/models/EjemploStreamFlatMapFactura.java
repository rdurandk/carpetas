package org.rdurandk.api.stream.ejemplos.models;

import org.rdurandk.api.stream.ejemplos.models.Factura;
import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Jhon", "Doe");
        Usuario u2 = new Usuario("Pepe", "Perez");

        u1.addFactura(new Factura("compras tecnologias"));
        u1.addFactura(new Factura("compras muebles"));

        u2.addFactura(new Factura("bicicletas"));
        u2.addFactura(new Factura("notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(u1,u2);
        usuarios.stream()
                .map(u -> u.getFacturas())//Usuario::getFacturas
                //al devolver una lista es un tipo collection que puede ser evaluado por un stream
                .flatMap(lf -> lf.stream())//List::stream
                .forEach(f -> System.out.println(f.getDescripcion() + " - " + f.getUsuario()));

        /*usuarios.forEach(el->{
            for(Factura fac:el.getFacturas()){
                System.out.println(fac.getDescripcion());
            }
        });*/
    }
}
