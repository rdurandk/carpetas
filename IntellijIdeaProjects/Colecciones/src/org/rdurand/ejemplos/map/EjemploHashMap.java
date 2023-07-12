package org.rdurand.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {
        Map<String, Object> persona = new HashMap<>();//creamos un llave String y un valor String
        //Las llaves no se pueden repetir el valor si
        persona.put(null, "1234");
        persona.put(null, 1234);
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellido", "Roe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.does@gmail.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "usa");
        direccion.put("estado", "california");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");

        persona.put("direccion", direccion);//poniendo un valor map en otro map

        System.out.println("persona = " + persona);

        Object nombre = persona.get("nombre"); //el valor de nombre puede ser cualquier object
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido"); //debemos hacer cast si queremos
        // especificar que tipo de obj es
        System.out.println("apellido = " + apellido);


        System.out.println("apellidoPaterno = " + persona.get("apellidoPaterno"));
        System.out.println();
        Map<String, String> direccionPersona = (Map<String, String>)persona.get("direccion") ;
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.get("barrio");
        String barrio2 = direccionPersona.getOrDefault("barrio", "Los angeles");
        System.out.println("El pais de john es: " + pais);
        System.out.println("La ciudad de john es: " + ciudad);
        System.out.println("El barrio de john es: " + barrio);
        System.out.println("El barrio de john es: " + barrio2);

        //String apellidoPaterno = persona.remove("apellidoPaterno");
        boolean b = persona.remove("apellidoPaterno", "Doe");
        System.out.println("eliminado " + b);
        System.out.println("persona = " + persona);

        boolean b2 = persona.containsKey("apellidoPaterno");
        System.out.println("b2 = " + b2);

        b2 = persona.containsValue("john.does@gmail.com");
        System.out.println("b2 = " + b2);

        System.out.println("====values====");
        Collection<Object> valores = persona.values();
        for(Object v:valores){
            System.out.println("v = " + v);
        }

        System.out.println("=====keyset=====");
        Set<String> llaves = persona.keySet();
        for(String k:llaves){
            System.out.println("k = " + k);
        }

        System.out.println("====entry=====");
        for(Map.Entry<String, Object> par:persona.entrySet()){
            if(par.getValue() instanceof Map){
                Map<String, String> entryMap = (Map<String, String>) par.getValue();
                System.out.println("Direccion:  ");
                for(Map.Entry<String,String> parDir: entryMap.entrySet()){
                    System.out.println(parDir.getKey() + " => " + parDir.getValue());
                }
            }
            System.out.println(par.getKey() + " => " + par.getValue());
        }

        System.out.println("=====keyset=====");
        for(String llave: persona.keySet()){
            Object valor = persona.get(llave);
            if(valor instanceof Map){
                Object nom = persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El pais de " +  nom + ": " + direccionMap.get("pais"));
                System.out.println("La ciudad de " +  nom + ": "  + direccionMap.get("ciudad"));
                System.out.println("El barrio de " +  nom + ": "  + direccionMap.get("barrio"));
            }else {
                System.out.println("valor= " + valor);
            }
        }

        System.out.println("=====foreach===");
        persona.forEach((key,value)->{
            System.out.println(key + " = " + value);
        });

        System.out.println();
        System.out.println("total: " + persona.size());
        System.out.println("contiene elementos = " + !persona.isEmpty());
        persona.replace("nombre", "Andres");
        boolean b3 = persona.replace("nombre", "Juan","Andres");
        System.out.println("b3 = " + b3);
        b3 = persona.replace("nombre", "Andres","Alex");
        System.out.println("b3 = " + b3);
        System.out.println("persona = " + persona);
    }
}
