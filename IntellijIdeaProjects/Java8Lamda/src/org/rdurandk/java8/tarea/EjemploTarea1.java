package org.rdurandk.java8.tarea;

public class EjemploTarea1 {
    public static void main(String[] args) {
        EspacioComasPuntos interfaz = (frase) ->{
            return frase.replace(",", "").
                    replace(" ", "").
                    replace(".", "").
                    toUpperCase();
        };

        String resultado = interfaz.frase("Hola, mundo. que tal estamos hoy. es un buen dia, para programar");
        System.out.println(resultado);
    }
}
