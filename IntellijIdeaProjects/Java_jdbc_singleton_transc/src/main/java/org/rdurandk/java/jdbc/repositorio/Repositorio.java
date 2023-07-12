package org.rdurandk.java.jdbc.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {//consulta la BD

    List<T> listar() throws SQLException;
    T porId(Long id) throws SQLException;
    void guardar(T t) throws SQLException;
    void eliminar(Long id) throws SQLException;
}
