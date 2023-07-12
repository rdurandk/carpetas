package org.rdurand.tarea2;

public class EjemploProducto {
    public static void main(String[] args) {
        Lacteo lacteo1 = new Lacteo("Flan", 2, 2, 4);
        Lacteo lacteo2 = new Lacteo("Pudding", 3, 2, 3);

        Fruta fruta1 = new Fruta("Naranjas", 5, 1, "naranja");
        Fruta fruta2 = new Fruta("Mandarinas", 3, 1, "amarillo");

        Limpieza limp1 = new Limpieza("Lejia", 8, "Higienizar", 2);
        Limpieza limp2 = new Limpieza("Lavavajilla", 10, "Hipoclorito ", 3);

        NoPerecible nop1 = new NoPerecible("Cafe", 3, 2, 0);
        NoPerecible nop2 = new NoPerecible("Atun", 6, 3, 1);

        Producto[] productos;
        productos = new Producto[8];
        productos[0] = lacteo1;
        productos[1] = lacteo2;
        productos[2] = fruta1;
        productos[3] = fruta2;
        productos[4] = limp1;
        productos[5] = limp2;
        productos[6] = nop1;
        productos[7] = nop2;


        for(int i=0;i<productos.length;i++){
            System.out.println("======"+ productos[i].getClass() + "=====");
            System.out.println(productos[i].getNombre());
            System.out.println(productos[i].getPrecio());
            if(productos[i] instanceof Lacteo){
                System.out.println(((Lacteo)productos[i]).getCantidad());
                System.out.println(((Lacteo)productos[i]).getProteinas());
            } else if (productos[i] instanceof Fruta) {
                System.out.println(((Fruta)productos[i]).getPeso());
                System.out.println(((Fruta)productos[i]).getColor());
            } else if (productos[i] instanceof Limpieza) {
                System.out.println(((Limpieza)productos[i]).getComponentes());
                System.out.println(((Limpieza)productos[i]).getLitros());
            } else if (productos[i] instanceof NoPerecible) {
                System.out.println(((NoPerecible)productos[i]).getContenido());
                System.out.println(((NoPerecible)productos[i]).getCalorias());
            }
        }


    }
}
