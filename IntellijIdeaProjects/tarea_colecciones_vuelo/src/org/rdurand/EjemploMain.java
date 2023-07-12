package org.rdurand;

import org.rdurand.modelo.Vuelo;

import java.util.*;

public class EjemploMain {
    public static void main(String[] args) {

        List<Vuelo> vuelos = new LinkedList<>();
        vuelos.add(new Vuelo("AAL 933", "New York", "Santiago",
                setDate(2021,07,29,5,39), 62 ));
        vuelos.add(new Vuelo("LAT-755", "Sao Paulo", "Santiago",
                setDate(2021,07,31,4,45), 47 ));
        vuelos.add(new Vuelo("SKU-621", "Rio De Janeiro", "Santiago",
                setDate(2021,07,30,16,00), 52 ));
        vuelos.add(new Vuelo("DAL-147", "Atlanta", "Santiago",
                setDate(2021,07,29,13,22), 59 ));
        vuelos.add(new Vuelo("AVA-241", "Bogota", "Santiago",
                setDate(2021,07,31,14,05), 25 ));
        vuelos.add(new Vuelo("AMX-10", "Mexico City", "Santiago",
                setDate(2021,07,31,5,20), 29 ));
        vuelos.add(new Vuelo("IBE-6833", "Londres", "Santiago",
                setDate(2021,07,30,8,45), 55 ));
        vuelos.add(new Vuelo("LAT-2479", "Frankfurt", "Santiago",
                setDate(2021,07,29,7,41), 51 ));
        vuelos.add(new Vuelo("SKU-803", "Lima", "Santiago",
                setDate(2021,07,29,10,35), 48 ));
        vuelos.add(new Vuelo("LAT-533", "Los Angeles", "Santiago",
                setDate(2021,07,29,9,14), 59 ));
        vuelos.add(new Vuelo("LAT-1447", "Guayaquil", "Santiago",
                setDate(2021,07,31,8,33), 31 ));
        vuelos.add(new Vuelo("CMP-1111", "Panama City", "Santiago",
                setDate(2021,07,31,15,15), 29 ));
        vuelos.add(new Vuelo("LAT-705", "Madrid", "Santiago",
                setDate(2021,07,30,8,14), 47 ));
        vuelos.add(new Vuelo("AAL-957", "Miami", "Santiago",
                setDate(2021,07,29,22,53), 60 ));
        vuelos.add(new Vuelo("ARG-5091", "Buenos Aires", "Santiago",
                setDate(2021,07,31,9,57), 32 ));
        vuelos.add(new Vuelo("LAT-1283", "Cancun", "Santiago",
                setDate(2021,07,31,4,00), 35 ));
        vuelos.add(new Vuelo("LAT-579", "Barcelona", "Santiago",
                setDate(2021,07,29,7,45), 61 ));
        vuelos.add(new Vuelo("AAL-945", "Dallas-Fort Worth", "Santiago",
                setDate(2021,07,30,7,12), 58 ));
        vuelos.add(new Vuelo("LAT-501", "Paris", "Santiago",
                setDate(2021,07,29,18,29), 49 ));
        vuelos.add(new Vuelo("LAT-405", "Montevideo", "Santiago",
                setDate(2021,07,30,15,45), 39 ));


        LinkedList<Vuelo> vueloLinked = new LinkedList<>(vuelos);
        System.out.println("----vuelos ordenados de forma ASC----");
        vueloLinked.sort(Comparator.comparing(Vuelo::getFechaHoraLlegada));
        System.out.println(vuelos + "\n");

        Vuelo ultimoVuelo = vueloLinked.getLast();
        System.out.println("El ultimo vuelo en llegar es: " + ultimoVuelo.getNombre() + ": " + ultimoVuelo.getOrigen() +
                ", aterriza el " + ultimoVuelo.getFormatoFecha());

        vueloLinked.sort(Comparator.comparing(Vuelo::getNumPasajeros));
        Vuelo menorPasajeros = vueloLinked.getFirst();
        System.out.println("El vuelo con menor numero de pasajeros es: "  + menorPasajeros.getNombre() + ": " +
                menorPasajeros.getOrigen() + " con " + menorPasajeros.getNumPasajeros() + " pasajeros");
    }

    public static Date setDate(int anio, int mes, int dia, int hora, int min){
        Calendar calendario = Calendar.getInstance();
        calendario.set(anio,mes,dia);
        calendario.set(Calendar.HOUR_OF_DAY, hora);
        calendario.set(Calendar.MINUTE, min);
        Date fecha = calendario.getTime();
        return fecha;
    }
}
