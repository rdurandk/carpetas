package org.rdurand.pooclasesabstractas.form;

import org.rdurand.pooclasesabstractas.form.elementos.*;
import org.rdurand.pooclasesabstractas.form.elementos.select.Opcion;
import org.rdurand.pooclasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6,12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5,9);
        experiencia.addValidador(new LargoValidador(5,15));

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python").setSelected())
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "Php"));


        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name=\""+this.nombre+"\" value=\""+this.valor+"\">";
            }
        };


        saludar.setValor("Hola que tal este campo esta desahibilitado");
        username.setValor("");
        password.setValor("");
        email.setValor("jon.doegmail.com");
        edad.setValor("28e");
        experiencia.setValor("...mas de 10 años de experiencia....");
        //java.setSelected(true);


        /*List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);*/
        List<ElementoForm> elementos =  Arrays.asList(username,
                password,email,edad,experiencia,lenguaje,saludar);


        System.out.println();
        for(ElementoForm e:elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }

        elementos.forEach(e ->{
            if(!e.esValido()){
                e.getErrores().forEach(System.out::println);//forEach(err ->{System.out.println(err);
            }
        });

    }
}
