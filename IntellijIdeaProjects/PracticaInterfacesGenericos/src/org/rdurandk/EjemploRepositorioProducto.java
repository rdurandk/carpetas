package org.rdurandk;

import org.rdurandk.excepsiones.DatosNulosException;
import org.rdurandk.excepsiones.DuplicadosDatosException;
import org.rdurandk.excepsiones.Error;
import org.rdurandk.interfaces.MultiplesInterfaces;
import org.rdurandk.interfaces.Tipo;
import org.rdurandk.modulo.Producto;
import org.rdurandk.repositorio.ProductoRepositorio;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try{
            MultiplesInterfaces<Producto> repo = new ProductoRepositorio();

            System.out.println("Crear");
            repo.crear(new Producto("teclado", 15));
            repo.crear(new Producto("mouse", 10));
            repo.crear(new Producto("monitor", 60));
            repo.crear(new Producto("auriculares", 12));
            System.out.println(repo.listar());

            System.out.println("BuscarPorId");
            System.out.println(repo.buscarPorId(4));

            System.out.println("editar");
            repo.editar(new Producto("auriculares", 20), 4);
            System.out.println(repo.listar());

            System.out.println("Ordenar");
            System.out.println(repo.listar(Tipo.ASC, "peso"));

            System.out.println("eliminar");
            repo.eliminar(4);
            System.out.println(repo.listar());
        }catch (DatosNulosException e){
            System.out.println("Nulos: " + e.getMessage());
        }catch (DuplicadosDatosException e){
            System.out.println("Duplicados: " + e.getMessage());
        }catch (Error e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
