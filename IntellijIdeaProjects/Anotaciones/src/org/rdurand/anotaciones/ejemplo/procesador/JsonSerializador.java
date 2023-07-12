package org.rdurand.anotaciones.ejemplo.procesador;

import org.rdurand.anotaciones.ejemplo.Init;
import org.rdurand.anotaciones.ejemplo.JsonAtributo;
import org.rdurand.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonSerializador {

    public static void inicializarObjecto(Object object){
        if(Objects.isNull(object)){//si el obj es null
            throw new JsonSerializadorException("El objeto a serializar no puede ser un null");
        }
        Method[] metodos = object.getClass().getDeclaredMethods();//obtener los metodos declarados

        Arrays.stream(metodos).filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m-> {
                    m.setAccessible(true);
                    try {
                        m.invoke(object);//invoca el metodo
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar, no se puede iniciar el obj"
                        + e.getMessage());
                    }
                });
    }
    public static String convertirJson(Object object){

        if(Objects.isNull(object)){//si el obj es null
            throw new JsonSerializadorException("El objeto a serializar no puede ser un null");
        }
        inicializarObjecto(object);
        Field[] atributos = object.getClass().getDeclaredFields();//obtener los campos declarados
        return Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))//en este caso nombre y precio
                .map(f -> {
                    f.setAccessible(true);
                    String campoNombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")//evalua el default
                            ? f.getName()//obtiene los campos de Producto
                            : f.getAnnotation(JsonAtributo.class).nombre();//obtiene el nombre por defecto en JsonAtributto
                    try {
                        Object campoValor = f.get(object);
                        if(f.getAnnotation(JsonAtributo.class).capitalizar() &&
                                campoValor instanceof String){
                            String nuevoValor = (String) campoValor;
                            nuevoValor = Arrays.stream(nuevoValor.split(""))
                                    .map(s -> {
                                        return String.valueOf(s.charAt(0)).toUpperCase() +
                                        s.substring(1).toLowerCase();
                                    })
                                    .collect(Collectors.joining(" "));
                            //collector joining - junta elementos en uno solo en lugar de reduce

                            /*String.valueOf(nuevoValor.charAt(0)).toUpperCase() +
                            nuevoValor.substring(1).toLowerCase();*/
                            f.set(object, nuevoValor);
                        }
                        return "\"" + campoNombre + "\":\"" + f.get(object) + "\"";

                    } catch (IllegalAccessException e) {//reemplazar por no checkeada
                        throw new JsonSerializadorException("Error al serializar a JSON: "+e.getMessage());
                    }
                })
                .reduce("{", (a,b)->{
                    if("{".equals(a)){
                        return a+b;
                    }
                    return a + ", " + b;
                }).concat("}");
    }
}
