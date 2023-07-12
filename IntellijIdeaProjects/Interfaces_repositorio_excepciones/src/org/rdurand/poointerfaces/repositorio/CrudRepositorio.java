package org.rdurand.poointerfaces.repositorio;

import org.rdurand.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.rdurand.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id)throws AccesoDatosException;
    void crear(T t) throws AccesoDatosException;
    void editar(T t) throws AccesoDatosException;
    void eliminar(Integer id) throws AccesoDatosException;
}
