package org.rdurandk.modulo;

public class Producto extends BaseEntity{
    private String descripcion;
    private Double peso;

    public Producto(String descripcion, double peso) {
        super();
        this.descripcion = descripcion;
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return " id=" +this.getId()+
                " descripcion='" + descripcion + '\'' +
                " peso=" + peso+"\n";
    }
}
