package org.rdurandk.patrones.decorator2.decorador;

import org.rdurandk.patrones.decorator2.Configurable;

public abstract class CafeDecorador implements Configurable {
    protected Configurable cafe;

    public CafeDecorador(Configurable cafe) {
        this.cafe = cafe;
    }
}
