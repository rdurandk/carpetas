package org.rdurand.app.hogar;

import org.rdurand.app.jardin.Perro;
import static org.rdurand.app.hogar.Persona.saludar;
public class EjemploHogar {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro perro = new Perro();
        String saludo = saludar();
    }
}
