package org.rdurandk.patrones.decorator2.decorador;

import org.rdurandk.patrones.decorator2.Cafe;
import org.rdurandk.patrones.decorator2.Configurable;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe(7, "Cafe Moca");
        ConCremaDecorador conCrema = new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche = new ConLecheDecorador(conCrema);
        ConChocolateDecorador conChoco = new ConChocolateDecorador(conLeche);
        System.out.println("El precio del cafe moca es: " + conChoco.getPrecioBase());
        System.out.println("Los ingrediente del cafe moca es: " + conChoco.getIngredientes());

        Configurable capuchino = new Cafe(4f,"Cafe capuchino");
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new ConLecheDecorador(conCrema);
        System.out.println("El precio del cafe capuchino es: " + conLeche.getPrecioBase());
        System.out.println("Los ingrediente del cafe capuchino es: " + conLeche.getIngredientes());
    }
}
