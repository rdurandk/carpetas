package org.rdurand.poosobrecarga;
import static org.rdurand.poosobrecarga.Calculadora.*;
public class EjemploSobrecarga {
    public static void main(String[] args) {


        System.out.println("sumar int: " + sumar(10,5));
        System.out.println("sumar float: " + sumar(10.0f,5F));
        System.out.println("sumar float-int: " + sumar(10f,5));
        System.out.println("sumar int-float: " + sumar(10,5.0F));
        System.out.println("sumar double: " + sumar(10.0,5D));
        System.out.println("sumar string: " + sumar("10","5"));
        System.out.println("sumar tres int: " + sumar(10,5,3));
        System.out.println("sumar n int: " + sumar(10,5,3,4));
        System.out.println("sumar float + n int: " + sumar(10.5F,5,9,15));
        System.out.println("sumar 3 double: " + sumar(3.0,5.4,10.9));

        System.out.println("sumar long: " + sumar(10L,5L));
        System.out.println("sumar int: " + sumar(10,'@'));
        System.out.println("sumar float-int: " + sumar(10F, '@'));

    }
}
