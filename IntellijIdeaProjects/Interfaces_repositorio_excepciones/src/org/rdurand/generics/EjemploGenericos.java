package org.rdurand.generics;

import org.rdurand.poointerfaces.modelo.Cliente;
import org.rdurand.poointerfaces.modelo.ClientePremium;

import java.util.*;

public class EjemploGenericos{
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Alexander", "Durand"));

        Cliente alex = clientes.get(0);

        Cliente[] clientesArreglo = {new Cliente("Luci", "Martinez"),
        new Cliente("Alvaro", "Durand")};


        Integer[] enterosArreglo = {1,2,3};

        List<Cliente> clienteLista = fromArrayToList(clientesArreglo);
        clienteLista.forEach(System.out::println);
        List<Integer> enteroList = fromArrayToList(enterosArreglo);
        enteroList.forEach(System.out::println);

        System.out.println("======");
        List<String> nombres = fromArrayToList(new String[]{"Andres",
                "Pepe", "Bea", "John"}, enterosArreglo);

        nombres.sort((a,b)->{
            return b.compareTo(a);
        });
        nombres.forEach(System.out::println);

        System.out.println();
        List<ClientePremium> clientePremium =  fromArrayToList(
                new ClientePremium[]{new ClientePremium("Mafer", "Durand")});
        clientePremium.forEach(System.out::println);

        System.out.println();
        imprimirClientes(clientes);
        imprimirClientes(clienteLista);
        imprimirClientes(clientePremium);

        System.out.println("Maximo de 1,9 y 4 es: " + maximo(1,9,4));
    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);//convertir arreglo a list
    }
    public static <T extends Number> List<T> fromArrayToList(T[] c){//con extends bounded generics
        return Arrays.asList(c);
    }

    public static <T extends Cliente> List<T> fromArrayToList(T[] c){//
        return Arrays.asList(c);
    }
    public static <T, G> List<T> fromArrayToList(T[] c, G[] g){//
        for(G elemento:g){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){//?extends sirve como comodin quiere decir
        // que sus clases descendientes o hijas(de Cliente) tambien podran ser evaluados en el metodo
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo (T a, T b, T c){
        T max = a;
        if(b.compareTo(max)>0){
            max = b;
        }
        if(c.compareTo(max)>0){
            max = c;
        }
        return max;
    }


}
