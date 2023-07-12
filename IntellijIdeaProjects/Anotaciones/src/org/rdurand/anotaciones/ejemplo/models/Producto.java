package org.rdurand.anotaciones.ejemplo.models;

import org.rdurand.anotaciones.ejemplo.Init;
import org.rdurand.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {
    @JsonAtributo()//anotamos al json
    private String nombre;
    @JsonAtributo(nombre = "precioLong")
    //nombre hace referencia al Json Atributo
    private Long precio;

    private LocalDate fecha;

    @Init
    private void init(){
        this.nombre = Arrays.stream(nombre.split(" "))
                .map(s -> String.valueOf(s.charAt(0)).toUpperCase() +
                            s.substring(1).toLowerCase())
                .reduce("",(a,b) ->a+" "+b);
                //.collect(Collectors.joining(" "));
        //collector joining - junta elementos en uno solo en lugar de reduce

        /*String.valueOf(nuevoValor.charAt(0)).toUpperCase() +
        nuevoValor.substring(1).toLowerCase();*/
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
