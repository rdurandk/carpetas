package org.rdurandk.java.jdbc.repositorio;

import java.util.List;

public interface Repositorio<T> {//consulta la BD

    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id);
}
