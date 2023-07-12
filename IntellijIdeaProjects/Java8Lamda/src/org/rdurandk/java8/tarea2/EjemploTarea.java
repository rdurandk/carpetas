package org.rdurandk.java8.tarea2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class EjemploTarea {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Function<String, Map> resultado = (frase) ->{
            String palabras[] = frase.split(" ");
            String palabrasB[] = frase.split(" ");
            String palabraMasRepetida = "";
            int contadorMax=0;
            for(int i=0;i<palabras.length;i++){
                String palabra = palabras[i];
                int contador = 0;
                for(int j=0;j<palabrasB.length;j++){
                    if(palabra.equalsIgnoreCase(palabrasB[j])){
                        contador++;
                    }
                }
                if(contador>contadorMax){
                    contadorMax = contador;
                    palabraMasRepetida = palabra;
                }
            }
            if(palabraMasRepetida == ""){
                System.out.println("No hay palabras repetidas");
            }
            map.put(palabraMasRepetida, contadorMax);
            return map;
        };

        String frase = "Hola mundo que tal hola alex hola juan, que tal mundo, hola a todos";
        resultado.apply(frase).forEach((k, v) -> System.out.println("La palabra " + k + " tiene mas repetidas, " + v + " veces."));

    }

}
