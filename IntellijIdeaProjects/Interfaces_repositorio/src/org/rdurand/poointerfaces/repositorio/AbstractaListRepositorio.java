package org.rdurand.poointerfaces.repositorio;

import org.rdurand.poointerfaces.modelo.BaseEntity;


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
    public T porId(Integer id) {
        T resultado = null;
        for(T o:dataSource){
            if(o.getId() != null && o.getId().equals(id)){
                resultado = o;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
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
