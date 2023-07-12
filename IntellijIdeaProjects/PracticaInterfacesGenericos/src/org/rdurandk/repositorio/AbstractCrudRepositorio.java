package org.rdurandk.repositorio;

import org.rdurandk.excepsiones.DatosNulosException;
import org.rdurandk.excepsiones.DuplicadosDatosException;
import org.rdurandk.interfaces.MultiplesInterfaces;
import org.rdurandk.modulo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCrudRepositorio<T extends BaseEntity> implements MultiplesInterfaces<T> {
    protected List<T> datasource;
    public AbstractCrudRepositorio(){
        this.datasource = new ArrayList<>();
    }

    @Override
    public List<T> listar(){
        return this.datasource;
    }
    @Override
    public T buscarPorId(Integer id) throws DatosNulosException {
        T obj = null;
        for(T t:datasource){
            if(t.getId() == id){
                obj = t;
            }
        }
        if(obj == null){
            throw new DatosNulosException("No se encontro el objeto con el id: " + id);
        }
        return obj;
    }


    @Override
    public void eliminar(Integer id)throws DatosNulosException{
        T obj = null;
        for(T t:this.datasource){
            if(t.getId().equals(id)){
                obj = t;
            }
        }
        if(obj==null){
            throw new DatosNulosException("Error al eliminar un id inexistente");
        }
        this.datasource.remove(obj);
    }

    public Integer total(){
        return this.datasource.size();
    }


}
