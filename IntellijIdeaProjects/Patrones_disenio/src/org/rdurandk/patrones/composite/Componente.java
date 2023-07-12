package org.rdurandk.patrones.composite;


/*se utiliza cuando se necesita representar una jerarquía de objetos de manera recursiva como una estructura de árbol.
Este patrón permite tratar tanto a los objetos individuales como a las composiciones de objetos de manera uniforme*/

public abstract class Componente {
    protected String nombre;
    protected Double tamanio;

    public Componente(String nombre, Double tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }
    public Componente(String nombre) {//2 sobrecargas de constructor para el directorio
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    abstract public String mostrar(int nivel);
    abstract public boolean buscar(String nombre);
    abstract public Double calcularTamanio();

}
