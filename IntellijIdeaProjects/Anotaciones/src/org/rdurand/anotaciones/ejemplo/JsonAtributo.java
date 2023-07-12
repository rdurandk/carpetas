package org.rdurand.anotaciones.ejemplo;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)//sobre atributos
@Retention(RetentionPolicy.RUNTIME)//en que contexto
public @interface JsonAtributo {
    String nombre() default  "";
    boolean capitalizar() default false;
}
