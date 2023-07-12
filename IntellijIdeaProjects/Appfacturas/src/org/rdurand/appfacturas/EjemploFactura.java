package org.rdurand.appfacturas;
import org.rdurand.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Alexander");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese la descripcion de la factura: ");
        Factura factura = new Factura(s.nextLine(), cliente);

        Producto producto;
        System.out.println();

        for(int i=0;i<2;i++){
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");

            ItemFactura item = new ItemFactura(s.nextInt(), producto);
            factura.addItemFactura(item);

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura);
    }
}
