package org.rdurand.tarea;

public class Empleado extends Persona{

    private double remuneracion;
    private static int empleadoId;

    public Empleado(String nombre, String apellido, String dni, String direccion, double remuneracion){
        super(nombre,apellido,dni,direccion);
        this.remuneracion = remuneracion;
        ++this.empleadoId;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void aumentarRemuneracion(int porcentaje){

        double aumento = remuneracion * porcentaje/100;
        remuneracion += aumento;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nempleadoId= " + empleadoId+
                "\nremuneracion= " +remuneracion;
    }
}
