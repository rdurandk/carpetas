package org.rdurand.poointerfaces.repositorio;

import org.rdurand.poointerfaces.modelo.BaseEntity;
import org.rdurand.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.rdurand.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import org.rdurand.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.rdurand.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements MultiplesInterfaces<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if(id == null || id<=0){
            throw new LecturaAccesoDatoException("Id invalido, debe ser > 0");
        }
        T resultado = null;
        for(T o:dataSource){
            if(o.getId() != null && o.getId().equals(id)){
                resultado = o;
                break;
            }
        }
        if(resultado == null){
            throw new LecturaAccesoDatoException("No se encontro el registro con el id: " + id);
        }
        return resultado;
    }





    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException{
        this.dataSource.remove(this.porId(id));
    }


    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    @Override
    public int total(){
        return this.dataSource.size();
    }
}
