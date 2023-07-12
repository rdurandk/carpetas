package org.rdurandk.tarea.abstractas;

abstract public class Mamifero {
    protected String habitad;
    protected double altura;
    protected double largo;
    protected double peso;
    protected String nombre_cientifico;

    public Mamifero(String habitad, double altura, double largo, double peso, String nombre_cientifico) {
        this.habitad = habitad;
        this.altura = altura;
        this.largo = largo;
        this.peso = peso;
        this.nombre_cientifico = nombre_cientifico;
    }

    public String getHabitad() {
        return habitad;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargo() {
        return largo;
    }

    public double getPeso() {
        return peso;
    }

    public String getNombre_cientifico() {
        return nombre_cientifico;
    }

    abstract public String comer();
    abstract public String dormir();
    abstract public String correr();
    abstract public String comunicarse();

}
