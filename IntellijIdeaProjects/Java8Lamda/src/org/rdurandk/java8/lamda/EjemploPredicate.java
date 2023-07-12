package org.rdurandk.java8.lamda;

import org.rdurandk.java8.lamda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {
        //Predicate devuelve un boolean cuyo metodo funcional es test
        Predicate<Integer> test = num -> num>10;
        System.out.println(test.test(15));

        Predicate<String> t2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(t2.test("ROLE_USER"));

        //BiPredicate<String, String> t3 = (a,b) -> a.equals(b);
        BiPredicate<String, String> t3 = String::equals;//metodo referencia
        System.out.println(t3.test("alex", "alex"));

        BiPredicate<Integer, Integer> t4 = (i,j) -> j>i;
        boolean r2 = t4.test(5,10);
        System.out.println(r2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("maria");
        b.setNombre("maria");
        BiPredicate<Usuario, Usuario> t5 = (ua,ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a,b));
    }
}
