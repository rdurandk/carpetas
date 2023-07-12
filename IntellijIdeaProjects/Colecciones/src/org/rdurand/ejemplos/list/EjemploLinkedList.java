package org.rdurand.ejemplos.list;

import org.rdurand.ejemplos.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;


public class EjemploLinkedList {
    public static void main(String[] args) {
        //Tiene que ser de propio linked list para implementar sus metodos
        LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada + ", size - " + enlazada.size());
        System.out.println("Esta vacia?: " + enlazada.isEmpty());
        enlazada.add(new Alumno("Pato", 5.0));
        enlazada.add(new Alumno("Cata", 6.0));
        enlazada.add(new Alumno("Luci", 4.0));
        enlazada.add(new Alumno("Jano", 7.0));
        enlazada.add(new Alumno("Andres", 3.0));

        System.out.println(enlazada + ", size - " + enlazada.size());

        enlazada.addFirst(new Alumno("Zeus", 5.0));
        enlazada.addLast(new Alumno("Atenea",6.0));
        System.out.println(enlazada + ", size - " + enlazada.size());

        System.out.println("Primero = " + enlazada.getFirst());
        System.out.println("Ultimo = " + enlazada.getLast());
        //getlast y peeklast la diferencia es que la primera lanza con exception la otra null
        System.out.println("Ultimo = " + enlazada.peekLast());
        System.out.println("Indice 2 = " + enlazada.get(2));

        Alumno zeus = enlazada.removeFirst();//equivalente a pop
        enlazada.removeLast();
        //enlazada.pollLast(); lo mismo que removelast pero devuelve null si no se encuentra
        System.out.println(enlazada + ", size - " + enlazada.size());

        System.out.println("Eliminando Jano");
        enlazada.remove(new Alumno("Jano", 7.0));//evaluado con equal y hashcode
        System.out.println(enlazada + ", size - " + enlazada.size());

        Alumno a = new Alumno("Lucas", 5.0);
        enlazada.addLast(a);
        System.out.println(enlazada + ", size - " + enlazada.size());
        System.out.println("Indice de Lucas = " + enlazada.indexOf(a));
        System.out.println(enlazada.remove(2));

        System.out.println(enlazada + ", size - " + enlazada.size());
        System.out.println("Indice de Lucas = " + enlazada.indexOf(a));

        enlazada.set(3, new Alumno("Lalo", 7.0));
        System.out.println(enlazada + ", size - " + enlazada.size());

        System.out.println("Lista Iterator");//Operaciones con Iterator
        ListIterator<Alumno> li = enlazada.listIterator();
        while(li.hasNext()){
            System.out.println(li.next());
        }
        System.out.println("Previous");
        while(li.hasPrevious()){
            System.out.println(li.previous());
        }

    }
}
