package org.rdurand.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Vuelo implements Comparable<Vuelo>{
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaHoraLlegada;
    private int numPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fechaHoraLlegada,  int numPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.numPasajeros = numPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public String getFormatoFecha() {
        SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMMM dd HH:mm 'del' yyyy", Locale.ENGLISH);
        return df.format(fechaHoraLlegada);
    }

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    @Override
    public String toString() {
        return "\n"+"Vuelo='" + nombre + '\'' +
                ", Origen='" + origen + '\'' +
                ", Destino='" + destino + '\'' +
                ", FechaHoraLlegada=" + getFormatoFecha() +
                ", NumPasajeros=" + numPasajeros ;
    }

    @Override
    public int compareTo(Vuelo o) {
        return this.fechaHoraLlegada.compareTo(o.fechaHoraLlegada);
    }
}
