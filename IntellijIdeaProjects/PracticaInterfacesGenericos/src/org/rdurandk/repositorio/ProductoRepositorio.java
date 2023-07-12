package org.rdurandk.repositorio;

import org.rdurandk.excepsiones.DatosNulosException;
import org.rdurandk.excepsiones.DuplicadosDatosException;
import org.rdurandk.interfaces.Tipo;
import org.rdurandk.modulo.Cliente;
import org.rdurandk.modulo.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductoRepositorio extends AbstractCrudRepositorio<Producto>{

    @Override
    public void editar(Producto producto, Integer id) throws DatosNulosException {
        Producto obj = buscarPorId(id);
        if(producto!=null){
            obj.setDescripcion(producto.getDescripcion());
            obj.setPeso(producto.getPeso());
        }
    }

    @Override
    public List<Producto> listar(Tipo tipo, String variable) {
        List<Producto> productos = new ArrayList<>(this.datasource);
        productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                int resultado = 0;
                if(tipo.equals(Tipo.ASC)){
                    resultado = ordenar(variable, o1, o2);
                }else if(tipo.equals(Tipo.DESC)){
                    resultado = ordenar(variable, o2, o1);
                }
                return resultado;
            }
            public int ordenar(String variable, Producto a, Producto b){
                int resultado = 0;
                switch (variable){
                    case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
                    case "peso" -> resultado = a.getPeso().compareTo(b.getPeso());
                }
                return resultado;
            }
        });
        return productos;
    }
    @Override
    public void crear(Producto t)throws DatosNulosException, DuplicadosDatosException {
        if(t==null){
            throw new DatosNulosException("Error el objeto es nulo");
        }
        for(Producto obj:this.datasource){

        }
        this.datasource.add(t);
    }
}
