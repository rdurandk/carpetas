package org.rdurand.poointerfaces.repositorio.lista;

import org.rdurand.poointerfaces.modelo.Cliente;
import org.rdurand.poointerfaces.repositorio.AbstractaListRepositorio;
import org.rdurand.poointerfaces.repositorio.Direccion;
import org.rdurand.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import org.rdurand.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.rdurand.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void crear(Cliente t) throws EscrituraAccesoDatosException {

        if(t == null){
            throw new EscrituraAccesoDatosException("Error al insertar un objeto null");
        }

        if(this.dataSource.contains(t)){//esto actuara dependiendo del equals y hash code
            throw new RegistroDuplicadoAccesoDatoException("Error el objeto con id "
                    + t.getId() + " existe en el repositorio");
        }

        this.dataSource.add(t);
    }

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente c = this.porId(cliente.getId());
        if(c!=null){
            c.setNombre(cliente.getNombre());
            c.setApellido(cliente.getApellido());

        }
    }


    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        //sort sirve para ordenar un arraylist de un objeto
        List<Cliente> listaCliente = new ArrayList<>(this.dataSource);
        listaCliente.sort(new Comparator<>() {//se podria reemplazar con expresion lambda pero
            //una expresion lamda no deberia existir mas de un metodo si no solo 1
            @Override
            public int compare(Cliente a, Cliente b) {

                int resultado = 0;
                if(dir == Direccion.ASC){
                    resultado = this.ordenar(a,b);
                }else if(dir == Direccion.DESC){
                    resultado = this.ordenar(b,a);
                }
                return resultado;
            }

            private int ordenar(Cliente a, Cliente b){
                int resultado = 0;
                switch (campo){
                    case "id" ->
                            resultado = a.getId().compareTo(b.getId());
                    case "nombre" ->
                            resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" ->
                            resultado = a.getApellido().compareTo(b.getApellido());
                }
                return resultado;
            }
        });
        return listaCliente;
    }



}
