package org.rdurand.ejemplo;

import org.rdurand.pooherencia.Alumno;
import org.rdurand.pooherencia.AlumnoInternacional;
import org.rdurand.pooherencia.Persona;
import org.rdurand.pooherencia.Profesor;

public class EjemploHerenciaToString {
    public static void main(String[] args) {

        System.out.println("=======Creando la instancion de la clase Alumno=====");
        Alumno alumno = new Alumno("Alexander","Durand",25,"Instituto Nacional");
        alumno.setNotaCastellano(6.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);
        alumno.setEmail("rdurandk@gmail.com");

        System.out.println("=======Creando la instancia de la clase AlumnoInternacional====");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Peter","Gosling","Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);
        alumnoInt.setEmail("peter@correo.com");

        System.out.println("====== Creando la instancia de la clase Profesor=====");
        Profesor profesor = new Profesor("Luci","Perez","Matematicas");
        profesor.setEdad(37);
        profesor.setEmail("profesor949@correo.com");

        System.out.println("===== - ====");

        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);
    }
    public static void imprimir(Persona persona){
        System.out.println("======================");
        System.out.println(persona);
    }
}
