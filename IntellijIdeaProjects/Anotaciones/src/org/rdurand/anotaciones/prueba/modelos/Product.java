package org.rdurand.anotaciones.prueba.modelos;

import org.rdurand.anotaciones.prueba.InitMethod;
import org.rdurand.anotaciones.prueba.JsonAnotation;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Product {
    @JsonAnotation
    private Integer id;
    @JsonAnotation
    private String descripcion;
    @JsonAnotation
    private Integer precio;

    private static Integer aumentarId=0;
    public Product(String descripcion, Integer precio){
        this.id = ++aumentarId;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    @InitMethod
    public void capitalizar(){
        this.descripcion = Arrays.stream(descripcion.split(" "))
                .map(f -> String.valueOf(f.charAt(0)).toUpperCase() + f.substring(1).toLowerCase())
                .reduce("",(a,b)-> a+ " " + b);
                //.collect(Collectors.joining(" "));
    }
}
