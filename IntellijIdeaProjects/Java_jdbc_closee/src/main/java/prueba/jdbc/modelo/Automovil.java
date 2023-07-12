package prueba.jdbc.modelo;

import java.util.Date;

public class Automovil {
    private Integer id;
    private String nombre;
    private Double precio;
    private Date fecha;
    private Sucursal sucursal;

    public Automovil() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return id +
                " | " + nombre +
                " | " + precio +
                " | " + fecha +
                " | " + sucursal.getId() +
                " | " + sucursal.getNombre();

    }
}
