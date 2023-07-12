package org.rdurandk.patrones.decorator.decorador;

import org.rdurandk.patrones.decorator.Formateable;

public class ReversaDecorador extends TextoDecorador{
    public ReversaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        StringBuilder sb = new StringBuilder(texto.darFormato());
        return String.valueOf(sb.reverse());
    }
}
