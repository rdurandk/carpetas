package org.rdurand.genericsclass;

import java.util.List;

public class EjemploGenericos {

    public static <T> void imprimirCamion(Camion<T> camion){
        for(T o: camion){
            if(o instanceof Animal){
                System.out.println(((Animal)o).getNombre() + " tipo: " + ((Animal)o).getTipo());
            }
            if(o instanceof Maquinaria){
                System.out.println(((Maquinaria)o).getTipo());
            }
            if(o instanceof Automovil){
                System.out.println(((Automovil)o).getMarca());
            }
        }
    }

    public static void main(String[] args) {
        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino","Caballo"));
        transporteCaballos.add(new Animal("Horseman","Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);


        System.out.println();
        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grua Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        System.out.println();
        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);
    }
}
