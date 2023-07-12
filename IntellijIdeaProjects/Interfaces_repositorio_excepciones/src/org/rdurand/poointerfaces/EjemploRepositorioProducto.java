package org.rdurand.poointerfaces;

import org.rdurand.poointerfaces.modelo.Producto;
import org.rdurand.poointerfaces.repositorio.Direccion;
import org.rdurand.poointerfaces.repositorio.MultiplesInterfaces;
import org.rdurand.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.rdurand.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.rdurand.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try{
        MultiplesInterfaces<Producto> repo = new ProductoListRepositorio();//al tipo mas generico
        repo.crear(new Producto("mesa", 58.52));
        repo.crear(new Producto("silla", 18));
        repo.crear(new Producto("lampara", 15.5));
        repo.crear(new Producto("notebook", 400.89));
        //repo.crear(new Producto("notebook", 400.89));
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);

        System.out.println("=====paginable=====");
        List<Producto> paginable = repo.listar(0,3);
        paginable.forEach(System.out::println);

        System.out.println("=====ordenable ASC=====");
        List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
        productosOrdenAsc.forEach(System.out::println);

        System.out.println("====editar y mostrar po ID====");
        Producto lamparaActualizar = new Producto("lampara escritorio", 23);
        lamparaActualizar.setId(3);
        repo.editar(lamparaActualizar);
        System.out.println(repo.porId(3));
        System.out.println("ordenado DESC");
        repo.listar("precio", Direccion.DESC)
                .forEach(System.out::println);

        System.out.println("=====eliminar=====");
        repo.eliminar(4);
        repo.eliminar(3);
        productos.forEach(System.out::println);

        System.out.println("Existen " + repo.total() + " productos registrados");
        }catch (LecturaAccesoDatoException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }catch (AccesoDatosException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
