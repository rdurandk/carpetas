package org.rdurand.anotaciones.prueba;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAnotation {
    String a() default "";
}
