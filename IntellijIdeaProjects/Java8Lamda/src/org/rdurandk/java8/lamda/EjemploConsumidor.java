package org.rdurandk.java8.lamda;

import org.rdurandk.java8.lamda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumidor {
    public static void main(String[] args) {

        //Una expresion lambda se traduce a una interfaz funcional
        //consumer es una interfaz funcional que no devuelve nada
        Consumer<Date> consumidor = (fecha) -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());
        BiConsumer<String, Integer>  consumidorBi = (nombre,edad) ->{
            System.out.println("Mi nombre es: " + nombre);
            System.out.println("Mi edad es: " + edad);
        };
        consumidorBi.accept("Alex", 25);
        Consumer<String> consumidor2 = System.out::println;//referencia de metodo
        consumidor2.accept("Hola mundo lambda");
        List<String> nombres = Arrays.asList("andres", "pepe", "luz", "paco");
        nombres.forEach(System.out::println);

        //Suplier Esta es una interfaz funcional cuyo método funcional es get().
        //Supplier<Usuario> crearUsuario = () -> new Usuario();
        Supplier<Usuario> crearUsuario = Usuario::new;//referencia de metodo
        Usuario usuario = crearUsuario.get();//con get devolvemos el valor
        BiConsumer<Usuario, String> asignarNombre = (persona, nombre) ->{
            persona.setNombre(nombre);
        };
        //BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;//referencia de metodo
        asignarNombre.accept(usuario, "Alex");
        System.out.println(usuario.getNombre());
        Supplier<String> proveedor = () -> {
            return "Hola mundo lambda supplier";
        };
        System.out.println(proveedor.get());
    }
}
