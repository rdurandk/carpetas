package org.rdurand.app.jardin;


//import org.rdurand.app.hogar.Persona;
//import org.rdurand.app.hogar.Gato;
import org.rdurand.app.hogar.*;
//import static org.rdurand.app.hogar.Persona.saludar;
//import static org.rdurand.app.hogar.Persona.GENERO_MASCULINO;
//import static org.rdurand.app.hogar.Persona.GENERO_FEMENINO;
import static org.rdurand.app.hogar.Persona.*;
import static org.rdurand.app.hogar.ColorPelo.*;
public class EjemploPaquetes {
    public static void main(String[] args) {

        Persona p = new Persona();
        p.setNombre("Alexander");
        p.setApellido("Durand");
        p.setColorPelo(CAFE);
        System.out.println(p.getNombre());


        Perro perro = new Perro();
        perro.nombre = "tobby";
        perro.raza = "Buldog";

        String jugando = perro.jugar(p);
        System.out.println("jugando = " + jugando);
        String saludo = saludar();
        System.out.println("saludo = " + saludo);
        String generoMujer = GENERO_FEMENINO;
        String generoMasculino = GENERO_MASCULINO;
        System.out.println("generoMasculino = " + generoMasculino);
    }
}
