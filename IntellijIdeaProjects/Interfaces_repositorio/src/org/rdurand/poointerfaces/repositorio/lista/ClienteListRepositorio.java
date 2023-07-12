package org.rdurand.poointerfaces.repositorio.lista;

import org.rdurand.poointerfaces.modelo.Cliente;
import org.rdurand.poointerfaces.repositorio.AbstractaListRepositorio;
import org.rdurand.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {
    @Override
    public void editar(Cliente cliente) {
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
        //se podria reemplazar con expresion lambda pero
//una expresion lamda no deberia existir  un metodo
        listaCliente.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC){
                resultado = ordenar(campo,a,b);
            }else if(dir == Direccion.DESC){
                resultado = ordenar(campo,b,a);
            }

            return resultado;
        });
        return listaCliente;
    }

    public  int ordenar(String campo, Cliente a, Cliente b){
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


}
