package org.rdurand.poointerfaces.imprenta;

import org.rdurand.poointerfaces.imprenta.modelo.*;
import static org.rdurand.poointerfaces.imprenta.modelo.Imprimible.imprimir;
import static org.rdurand.poointerfaces.imprenta.modelo.Genero.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo("Resumen Laboral...",new Persona("Joe", "Doe"), "Ing Sistemas");
        cv.addExperiencia("java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador FULL STACK")
                .addExperiencia("Angular");

        Libro libro = new Libro(new Persona("Erich","Gama"),"Patron de diseño. ELem. Reusables POO",PROGRAMACION);
        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron Observador"))
                .addPagina(new Pagina("Patron Factory"))
                .addPagina(new Pagina("Patron Composite"))
                .addPagina(new Pagina("Patron Fascade"))
                .addPagina(new Libro(new Persona("Alex", "Durand"), "PROGRAMACION REACT", PROGRAMACION));
                //el ultimo tmb es valido ya que implementa de imprimible

        Informe inf = new Informe("Estudio sobre microservicios", new Persona("Martin","Fowler"),
                new Persona("James", "Gosling"));

        Imprimible.imprimir(cv);
        System.out.println();
        Imprimible.imprimir(inf);
        System.out.println();
        Imprimible.imprimir(libro);


        Imprimible imp1 = new Imprimible(){
            @Override
            public String imprimir(){
                return "Hola que tal, imprimiendo de una clase anonima";
            }
        };
        imprimir(imp1);

        Imprimible imp2 = new Imprimible() {

        };

        System.out.println(Imprimible.TEXTO_DEFECTO);
        System.out.println(imp2.imprimir());
    }

}
