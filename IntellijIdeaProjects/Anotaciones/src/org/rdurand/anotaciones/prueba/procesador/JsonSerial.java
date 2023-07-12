package org.rdurand.anotaciones.prueba.procesador;


import org.rdurand.anotaciones.prueba.InitMethod;
import org.rdurand.anotaciones.prueba.JsonAnotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class JsonSerial {

    public static void iniciarMetodo(Object object){
        if(Objects.isNull(object)){
            throw new JsonException("Error: el objeto, no puede ser null");
        }
        Method[] metodos = object.getClass().getDeclaredMethods();
        Arrays.stream(metodos)
                .filter(f -> f.isAnnotationPresent(InitMethod.class))
                .forEach(f ->{
                    f.setAccessible(true);
                    try {
                        f.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonException("Error al serializar" + e.getMessage());
                    }
                });
    }
    public static String convertirJson(Object object){
        Field[] atributos = object.getClass().getDeclaredFields();
        iniciarMetodo(object);
        String json = Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAnotation.class))
                .map(f -> {
                    f.setAccessible(true);
                    String nombre = f.getAnnotation(JsonAnotation.class).a().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAnotation.class).a();


                    try {
                        Object valor = f.get(object);
                        return "\"" + nombre + "\"" + ": \"" + valor + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonException("Error al obtener el valor " + e.getMessage());
                    }

                })
                .reduce("{", (a,b) ->{
                    if("{".equals(a)){
                        return a+b;
                    }
                    return a + ", " + b;
                });

        return json;
    }
}
