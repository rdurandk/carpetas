package org.rdurand.ejemplo;

import org.rdurand.pooherencia.*;

public class EjemploHerencia {
    public static void main(String[] args) {

        System.out.println("=======Creando la instancion de la clase Alumno=====");
        Alumno alumno = new Alumno();
        alumno.setNombre("Alexander");
        alumno.setApellido("Durand");
        alumno.setInstitucion("Instituto Nacional");
        alumno.setNotaCastellano(6.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);

        System.out.println("=======Creando la instancion de la clase AlumnoInternacional====");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();
        alumnoInt.setNombre("Peter");
        alumnoInt.setApellido("Gosling");
        alumnoInt.setPais("Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);

        System.out.println("====== Creando la instancia de la clase Profesor=====");
        Profesor profesor = new Profesor();
        profesor.setNombre("Luci");
        profesor.setApellido("Perez");
        profesor.setAsignatura("Matematicas");

        System.out.println("===== - ====");
        System.out.println(alumno.getNombre()
                + " " + alumno.getApellido()
                + " " + alumno.getInstitucion());

        System.out.println(alumnoInt.getNombre()
                + " " +alumnoInt.getApellido()
                + " " +alumnoInt.getInstitucion()
                + " " +alumnoInt.getPais());

        System.out.println("Profesor " +profesor.getAsignatura()
                + " " +  profesor.getNombre()
                + " " + profesor.getApellido());

        Class clase = alumnoInt.getClass();

        while(clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            clase = clase.getSuperclass();
        }
    }
}
