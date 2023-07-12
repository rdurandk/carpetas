package org.rdurand.tarea;

public class Cliente extends Persona{
    private int clienteId;
    public Cliente(String nombre, String apellido, String dni, String direccion){
        super(nombre,apellido,dni,direccion);
        this.clienteId++;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nclienteId= " + clienteId;
    }
}
