package org.rdurand.pooclasesabstractas.tarea;

public class Planta extends SerVivo{
    
    //es necesario ponerle el metodo abstracto
    @Override
    public void alimentarse(){
        System.out.println("La planta se alimenta atraves de la fotosintesis");
    }
}
