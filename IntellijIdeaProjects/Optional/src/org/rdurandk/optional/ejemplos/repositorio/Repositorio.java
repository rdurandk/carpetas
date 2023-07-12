package org.rdurandk.optional.ejemplos.repositorio;

import org.rdurandk.optional.ejemplos.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<T> filtrar(String nombre);
}
