package org.rdurandk.patrones.decorator.decorador;

import org.rdurandk.patrones.decorator.Formateable;

public abstract class TextoDecorador implements Formateable {
    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
