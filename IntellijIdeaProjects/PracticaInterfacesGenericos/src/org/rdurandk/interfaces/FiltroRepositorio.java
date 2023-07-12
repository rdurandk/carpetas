package org.rdurandk.interfaces;

import java.util.List;

public interface FiltroRepositorio<T> {
    List<T> listar(Tipo tipo, String variable);
}
