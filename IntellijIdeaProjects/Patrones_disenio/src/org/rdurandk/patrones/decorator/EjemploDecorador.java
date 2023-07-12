package org.rdurandk.patrones.decorator;

import org.rdurandk.patrones.decorator.decorador.MayusculaDecorador;
import org.rdurandk.patrones.decorator.decorador.ReemplazarEspaciosDecorador;
import org.rdurandk.patrones.decorator.decorador.ReversaDecorador;
import org.rdurandk.patrones.decorator.decorador.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Alexander");
        System.out.println(texto.darFormato());

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        System.out.println(mayuscula.darFormato());

        ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        System.out.println(reversa.darFormato());

        ReemplazarEspaciosDecorador espacio = new ReemplazarEspaciosDecorador(reversa);
        System.out.println(espacio.darFormato());

        SubrayadoDecorador subrayado = new SubrayadoDecorador(espacio);
        System.out.println(subrayado.darFormato());


    }
}
