package org.rdurand.pooexcepcion.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {


    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        String numerador = JOptionPane.showInputDialog("Ingrese un entero numerador");
        String denominador = JOptionPane.showInputDialog("Ingrese un entero denominador");
        try {
            double division2 = cal.dividir(numerador,denominador);
            System.out.println(division2);
        }catch (NumberFormatException ne) {2
            System.out.println("Se detecto una excepcion: porfavor ingrese un valor numero: " + ne.getMessage());
            main(args);
        }catch (FormatoNumeroException fe){
            System.out.println("Se detecto una excepcion Ingrese un numero valido: " + fe.getMessage());
            fe.printStackTrace(System.out);
            main(args);
        }catch (DivisionPorZeroException ae){
            System.out.println("Capturamos la excepcion en tiempo de ejecucion: " + ae.getMessage());
            main(args);
        }finally {
            System.out.println("Se ejecuta siempre con o sin excepcion");
        }
        System.out.println("Continuamos con el flujo de nuestra aplicacion");
    }
}
