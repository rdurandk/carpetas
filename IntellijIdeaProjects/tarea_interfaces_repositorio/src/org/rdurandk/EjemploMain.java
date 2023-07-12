package org.rdurandk;

import org.rdurandk.genericos.BolsaSupermercado;
import org.rdurandk.modelos.*;

import java.util.Arrays;
import java.util.List;

public class EjemploMain {
    public static void main(String[] args) {

        BolsaSupermercado<Frutas> bolsaFruta = new BolsaSupermercado<>();
        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<>();
        BolsaSupermercado<Lacteos> bolsaLacteo = new BolsaSupermercado<>();
        BolsaSupermercado<NoPerecibles> bolsaNoPerecible = new BolsaSupermercado<>();

        bolsaFruta.addProducto(new Frutas("manzana", 3.50, 1, "rojo"));
        bolsaFruta.addProducto(new Frutas("fresa", 5, 1, "rojo"));
        bolsaFruta.addProducto(new Frutas("uvas", 6, 1, "morado"));
        bolsaFruta.addProducto(new Frutas("durazno", 8, 1, "amarillo"));
        bolsaFruta.addProducto(new Frutas("naranja", 5, 1, "naranja"));

        bolsaLimpieza.addProducto(new Limpieza("limpia-vidrios", 10, "Amoníaco", 1.5));
        bolsaLimpieza.addProducto(new Limpieza("suavizante ", 5, "Amoníaco", 1));
        bolsaLimpieza.addProducto(new Limpieza("lavandinas", 12, "Amoníaco", 1.2));
        bolsaLimpieza.addProducto(new Limpieza("limpia-baños", 16, "Amoníaco", 2));
        bolsaLimpieza.addProducto(new Limpieza("limpia-pisos", 15, "Amoníaco", 3));

        bolsaLacteo.addProducto(new Lacteos("yogur", 15, 2, 10));
        bolsaLacteo.addProducto(new Lacteos("leche", 3.50, 1, 15));
        bolsaLacteo.addProducto(new Lacteos("helado", 13, 1, 5));
        bolsaLacteo.addProducto(new Lacteos("avena", 10, 1, 20));
        bolsaLacteo.addProducto(new Lacteos("queso", 3, 1, 8));

        bolsaNoPerecible.addProducto(new NoPerecibles("sardinas enlatadas", 4, 2, 140));
        bolsaNoPerecible.addProducto(new NoPerecibles("atun", 6, 2, 120));
        bolsaNoPerecible.addProducto(new NoPerecibles("melocotones enlatados", 8, 5, 60));
        bolsaNoPerecible.addProducto(new NoPerecibles("Fideos", 5, 1, 90));
        bolsaNoPerecible.addProducto(new NoPerecibles("Harina", 3, 1, 200));


        for (Frutas fruta : bolsaFruta.getProductos()) {
            System.out.println("Nombre: " +  fruta.getNombre());
            System.out.println("Precio: " + fruta.getPrecio());
            System.out.println("Peso (gr): " + fruta.getPeso());
            System.out.println("Color: " + fruta.getColor());
            System.out.println();
        }

        System.out.println();
        for (Limpieza prod : bolsaLimpieza.getProductos()) {
            System.out.println("Nombre: " +  prod.getNombre());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Componentes: " + prod.getComponentes());
            System.out.println("Litros: " + prod.getLitros());
            System.out.println();
        }

        System.out.println();
        for (Lacteos prod : bolsaLacteo.getProductos()) {
            System.out.println("Nombre: " +  prod.getNombre());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Cantidad (gr/cc): " + prod.getCantidad());
            System.out.println("Proteinas (gr): " + prod.getProteinas());
            System.out.println();
        }

        System.out.println();
        for (NoPerecibles prod : bolsaNoPerecible.getProductos()) {
            System.out.println("Nombre: " +  prod.getNombre());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Calorias (kCal): " + prod.getCalorias());
            System.out.println("Contenido neto (gr): " + prod.getContenido());
            System.out.println();
        }
    }
}

