package org.rdurand.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length));//ordena por largo
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellido", "Roe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.does@gmail.com");
        persona.put("edad", "30");
        //Las llaves no se pueden repetir el valor si

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "usa");
        direccion.put("estado", "california");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");

        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);

    }
}
