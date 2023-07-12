package org.rdurandk;

import org.rdurandk.excepsiones.DatosNulosException;
import org.rdurandk.excepsiones.DuplicadosDatosException;
import org.rdurandk.excepsiones.Error;
import org.rdurandk.interfaces.MultiplesInterfaces;
import org.rdurandk.interfaces.Tipo;
import org.rdurandk.modulo.Cliente;
import org.rdurandk.repositorio.ClienteRepositorio;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try{
            MultiplesInterfaces<Cliente> repo = new ClienteRepositorio();
            Cliente cliente1 = new Cliente("Alexander", "Durand", 25);
            System.out.println("crear");
            repo.crear(cliente1);
            repo.crear(new Cliente("Mafer", "Durand", 23));
            repo.crear(new Cliente("Alvaro", "Durand", 16));
            repo.crear(new Cliente("Jazmin", "Durand", 24));
            repo.crear(new Cliente("Jazmin", "Durand", 23));
            System.out.println(repo.listar());

            System.out.println("editar");
            repo.editar(new Cliente("Alex", "Durand", 25), 1);
            repo.editar(new Cliente("Jazmin", "Durand", 23), 4);
            repo.editar(new Cliente("Mafer", "Durand", 22), 2);
            System.out.println(repo.listar());

            System.out.println("buscarpoId");
            System.out.println(repo.buscarPorId(2));

            System.out.println("ordenarAsc");
            System.out.println(repo.listar(Tipo.ASC, "edad"));

            System.out.println("ordenarDesc");
            System.out.println(repo.listar(Tipo.DESC, "nombre"));

            repo.crear(new Cliente("Brandom", "Torres", 29));
            System.out.println(repo.listar());

            System.out.println("eliminar");
            repo.eliminar(8);
            System.out.println(repo.listar());
        }catch (DatosNulosException e){
            System.err.println("Nulos: " + e.getMessage());;
        }catch (DuplicadosDatosException e){
            System.err.println("Duplicados" +e.getMessage());
        }catch (Error e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
