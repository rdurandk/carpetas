package org.rdurandk;

public class EjemploMain {
    public static void main(String[] args) {
        new Thread(new AlfanumericoTarea(Tipo.NUMERO)).start();
        new Thread(new AlfanumericoTarea(Tipo.LETRA)).start();
    }
}
