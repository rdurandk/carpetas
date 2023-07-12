package org.rdurand.ejemplo;

import org.rdurand.pooherencia.Alumno;
import org.rdurand.pooherencia.AlumnoInternacional;
import org.rdurand.pooherencia.Persona;
import org.rdurand.pooherencia.Profesor;

public class EjemploHerenciaConstructores {
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
        System.out.println("Imprimiendo datos en comun del tipo persona:");
        System.out.println("nombre: " + persona.getNombre()
                + " apellido: " + persona.getApellido()
                + " edad: " + persona.getEdad()
                + " email: " + persona.getEmail());

        if(persona instanceof Alumno){
            System.out.println("Imprimiendo los datos del tipo Alumno:");
            System.out.println("Institucion: " + ((Alumno) persona).getInstitucion());
            System.out.println("Nota matematicas: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("Nota Historia: " + ((Alumno) persona).getNotaHistoria());
            System.out.println("Nota Castellano: " + ((Alumno) persona).getNotaCastellano());

            if(persona instanceof AlumnoInternacional){
                System.out.println("Imprimiendo los datos del tipo Alumno Internacional:");
                System.out.println("Nota idiomas: " + ((AlumnoInternacional) persona).getNotaIdiomas());
                System.out.println("Pais: " + ((AlumnoInternacional)persona).getPais());
            }
            System.out.println("=======sobre escritura promedio========");
            System.out.println("Promedio: " + ((Alumno) persona).calcularPromedio());
            System.out.println("=======sobre escritura promedio========");
        }
        if(persona instanceof Profesor){
            System.out.println("Imprimiendo los datos del tipo Profesor:");
            System.out.println("Asignatura: " +((Profesor) persona).getAsignatura());
        }

        System.out.println("=======sobre escritura saludar========");
        System.out.println(persona.saludar());
        System.out.println("===============================");
    }
}
