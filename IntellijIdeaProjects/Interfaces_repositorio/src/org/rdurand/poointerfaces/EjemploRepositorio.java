package org.rdurand.poointerfaces;

import org.rdurand.poointerfaces.modelo.Cliente;
import org.rdurand.poointerfaces.repositorio.*;
import org.rdurand.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        MultiplesInterfaces<Cliente> repo = new ClienteListRepositorio();//al tipo mas generico
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Bea", "Gonzales"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Alexander", "Durand"));


        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("=====paginable=====");
        List<Cliente> paginable = repo.listar(0,3);
        paginable.forEach(System.out::println);

        System.out.println("=====ordenable=====");
        List<Cliente> ordenable = repo.listar("apellido", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("====editar y mostrar po ID====");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        System.out.println(repo.porId(2));
        System.out.println("ordenado DESC");
        repo.listar("apellido", Direccion.DESC)
                .forEach(System.out::println);

        System.out.println("=====eliminar=====");
        repo.eliminar(4);
        clientes.forEach(System.out::println);

        repo.crear(new Cliente("Brandon", "Torres"));
        System.out.println(repo.listar());
        System.out.println("Existen " + repo.total() + " clientes registrados");
    }
}
