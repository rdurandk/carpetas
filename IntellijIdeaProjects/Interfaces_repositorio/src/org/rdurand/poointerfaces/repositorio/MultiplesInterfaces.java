package org.rdurand.poointerfaces.repositorio;

public interface MultiplesInterfaces<T> extends CrudRepositorio<T>, OrdenableRepositorio<T>,
        PaginableRepositorio<T>, ContableRepositorio{

}
