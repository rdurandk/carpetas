package org.rdurandk.patrones.decorator.decorador;

import org.rdurandk.patrones.decorator.Formateable;

public class MayusculaDecorador extends TextoDecorador {

    public MayusculaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}
