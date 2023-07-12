package org.rdurandk.interfaces;

import org.rdurandk.excepsiones.Error;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T buscarPorId(Integer id) throws Error;
    void crear(T t) throws Error;
    void editar(T t, Integer id)throws Error;
    void eliminar(Integer id)throws Error;
}
