package org.rdurandk.optional.ejemplos.prueba.models;

import java.util.Optional;

public interface Repository<T> {
    Optional<T> filtrar(String nombre);
}
