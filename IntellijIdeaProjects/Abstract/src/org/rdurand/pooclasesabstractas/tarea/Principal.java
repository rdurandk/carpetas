package org.rdurand.pooclasesabstractas.tarea;

public class Principal {

   
    public static void main(String[] args) {
        
        Planta planta = new Planta();
        AnimalCarnivoro animalC = new AnimalCarnivoro();
        
        planta.alimentarse();
        animalC.alimentarse();
    }
    
}
