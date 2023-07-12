package org.rdurandk.modulo;

import java.util.Objects;

public class Cliente extends BaseEntity{
    private String nombre;
    private String apellido;
    private Integer edad;

    public Cliente(String nombre, String apellido, int edad) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return " id='" +this.getId() + "'" +
                " nombre='" + nombre + "'" +
                " apellido='" + apellido + '\'' +
                " edad='" + edad + '\'' +
                "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(edad, cliente.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, edad);
    }
}
