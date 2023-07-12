package org.rdurand.poointerfaces.repositorio.lista;

import org.rdurand.poointerfaces.modelo.Producto;
import org.rdurand.poointerfaces.repositorio.AbstractaListRepositorio;
import org.rdurand.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        if(p!=null){
            p.setDescripcion(producto.getDescripcion());
            p.setPrecio(producto.getPrecio());
        }
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        //sort sirve para ordenar un arraylist de un objeto
        List<Producto> listaProducto = new ArrayList<>(this.dataSource);
        listaProducto.sort(new Comparator<>() {//se podria reemplazar con expresion lambda pero
            //una expresion lamda no deberia existir mas de un metodo si no solo 1
            @Override
            public int compare(Producto a, Producto b) {

                int resultado = 0;
                if(dir == Direccion.ASC){
                    resultado = this.ordenar(a,b);
                }else if(dir == Direccion.DESC){
                    resultado = this.ordenar(b,a);
                }
                return resultado;
            }

            private int ordenar(Producto a, Producto b){
                int resultado = 0;
                switch (campo){
                    case "id" ->
                            resultado = a.getId().compareTo(b.getId());
                    case "descripcion" ->
                            resultado = a.getDescripcion().compareTo(b.getDescripcion());
                    case "precio" ->
                            resultado = a.getPrecio().compareTo(b.getPrecio());
                }
                return resultado;
            }
        });
        return listaProducto;
    }
}
