package org.rdurandk.patrones.composite3;

public class Ejemplo {
    public static void main(String[] args) {
        Componente compPatas = new ComponenteInternosMuebles("patas", 20);
        Componente compRespaldo = new ComponenteInternosMuebles("respaldo", 50);
        Componente compEstante = new ComponenteInternosMuebles("estantes", 50);
        Mueble silla = new Mueble("silla");
        silla.addComp(compPatas);
        silla.addComp(compRespaldo);
        silla.addComp(compEstante);
        System.out.println(silla.calcularCosto());
    }
}
