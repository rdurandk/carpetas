package org.rdurand.tarea;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;

    public Persona(String nombre, String apellido, String dni, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre +
                "\napellido='" + apellido +
                "\ndni='" + dni +
                "\ndireccion='" + direccion;
    }
}
