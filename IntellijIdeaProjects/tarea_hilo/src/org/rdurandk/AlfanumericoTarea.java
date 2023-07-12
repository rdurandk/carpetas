package org.rdurandk;

import java.sql.SQLOutput;

public class AlfanumericoTarea implements Runnable{
    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        if(tipo==Tipo.NUMERO){
            for(int i=1;i<=10;i++){
                System.out.println(i);
            }
        }else if(tipo==Tipo.LETRA){
            System.out.println('A');
            System.out.println('B');
            System.out.println('C');
            System.out.println('D');
            System.out.println('E');
            System.out.println('F');
            System.out.println('G');
            System.out.println('H');
            System.out.println('I');
            System.out.println('J');
            System.out.println('K');
            System.out.println('L');
            System.out.println('M');
            System.out.println('N');
            System.out.println('O');
            System.out.println('P');
            System.out.println('Q');
            System.out.println('R');
            System.out.println('S');
            System.out.println('T');
            System.out.println('U');
            System.out.println('W');
            System.out.println('X');
            System.out.println('Y');
            try {
                Thread.sleep(100);//asi el numero 10 no mostrara como ultimo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println('Z');
        }
    }
}
