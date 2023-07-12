package org.rdurandk.optional.ejemplos;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {

        //Optional no requiere controles de null es decir no necesitamos validar si
        //un parametro o un obj es null;podemos darles otros caminos o otras "opciones"
        String nombre = "Alex" ;
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get());
        }
        System.out.println(opt.isEmpty());

        //Consumer
        opt.ifPresent(value -> {
            System.out.println("Hola " + value);
        });

        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        //disponible desde JAVA 9
        opt.ifPresentOrElse( (valor)-> System.out.println("Hola" + valor),
                ()->  System.out.println("No esta presente"));

        if(opt.isPresent()){
            System.out.println("Hola " + opt.get());
        }else{
            System.out.println("No esta presente");
        }
        Optional<String> optEmpty = Optional.empty();
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent());

    }
}
