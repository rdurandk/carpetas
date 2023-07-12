package org.rdurandk.java8.lamda;

import org.rdurandk.java8.lamda.aritmetica.Aritmetica;
import org.rdurandk.java8.lamda.aritmetica.Calculadora;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {
        //Con nuestra propia interfaz functional (Aritmetica)
        //Aritmetica suma = (a,b) -> a+b;
        Aritmetica suma = Double::sum;
        Aritmetica resta = (a,b) -> a-b;
        Calculadora cal = new Calculadora();
        System.out.println(cal.computar(10,6.2, suma));
        System.out.println(cal.computar(10,6.2, resta));
        System.out.println(cal.computar(10,5,(a,b)-> a*b));

        BiFunction<Double, Double, Double> b1 = (a,b) -> a*b;
        System.out.println(cal.computarConBiFunction(10,6, b1));
    }
}
