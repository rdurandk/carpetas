package org.rdurandk.api.stream.ejemplos;

import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamLisToStream {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres", "Guzman"));
        lista.add(new Usuario("Luci", "Martinez"));
        lista.add(new Usuario("Pepe", "Fernandez"));
        lista.add(new Usuario("Cata", "Mena"));
        lista.add(new Usuario("Exequiel", "Doe"));
        lista.add(new Usuario("Bruce", "Lee"));
        lista.add(new Usuario("Bruce", "Williss"));
        Stream<String> nombresStream = lista.stream()
                .map(u ->u.getNombre().toUpperCase()
                    .concat(" ")
                    .concat(u.getApellido()).toUpperCase())
                .filter(nombres -> nombres.contains("doe".toUpperCase()))
                //aplicamos contains porque tenemos el nombre y apellido
                .map(nombres -> nombres.toLowerCase())
                .peek(System.out::println);

        System.out.println(nombresStream.count());
    }
}
