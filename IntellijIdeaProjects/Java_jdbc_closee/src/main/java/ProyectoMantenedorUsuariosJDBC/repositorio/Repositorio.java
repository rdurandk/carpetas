package ProyectoMantenedorUsuariosJDBC.repositorio;

import java.util.List;

public interface Repositorio<T> {

    void actualizar(T t);
    void eliminar(Integer id);
    void crear(T t);
    List<T> listar();

}
