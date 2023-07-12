package org.rdurandk.optional.ejemplos.prueba;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {
        String nombre = "Alex";
        Optional<String> opt = Optional.of("Alex");
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get());
        }
        System.out.println(opt.isEmpty());
        opt.ifPresent((valor) -> System.out.println("Hola  " + valor));
        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println("opt = "+opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get());
        }else{
            System.out.println("No esta presente");
        }
        opt.ifPresentOrElse((valor)-> System.out.println("Hola " + valor), () -> System.out.println("No esta presente"));
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
    }
}
