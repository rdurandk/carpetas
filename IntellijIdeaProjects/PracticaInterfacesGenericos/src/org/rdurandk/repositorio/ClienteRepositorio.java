package org.rdurandk.repositorio;

import org.rdurandk.excepsiones.DatosNulosException;
import org.rdurandk.excepsiones.DuplicadosDatosException;
import org.rdurandk.interfaces.Tipo;
import org.rdurandk.modulo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteRepositorio extends AbstractCrudRepositorio<Cliente>{

    @Override
    public void editar(Cliente t, Integer id) throws DatosNulosException {
        Cliente cli = buscarPorId(id);
        if(t!=null){
            cli.setNombre(t.getNombre());
            cli.setApellido(t.getApellido());
            cli.setEdad(t.getEdad());
        }
    }

    @Override
    public List<Cliente> listar(Tipo tipo, String variable) {
        List<Cliente> clientes = new ArrayList<>(this.datasource);
        clientes.sort(new Comparator<Cliente>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {
                int resultado = 0;
                if(tipo.equals(Tipo.ASC)){
                    resultado = ordenar(variable, o1, o2);
                }else if(tipo.equals(Tipo.DESC)){
                    resultado = ordenar(variable, o2, o1);
                }
                return resultado;
            }
            public int ordenar(String variable, Cliente a, Cliente b){
                int resultado = 0;
                switch (variable){
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
                    case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
                    case "edad" -> resultado = a.getEdad().compareTo(b.getEdad());
                }
                return resultado;
            }
        });
        return clientes;
    }

    @Override
    public void crear(Cliente t)throws DatosNulosException, DuplicadosDatosException {
        if(t==null){
            throw new DatosNulosException("Error el objeto es nulo");
        }
        if(this.datasource.contains(t)){
            throw new DuplicadosDatosException("Error datos duplicados en el obj");
        }
        this.datasource.add(t);
    }
}
