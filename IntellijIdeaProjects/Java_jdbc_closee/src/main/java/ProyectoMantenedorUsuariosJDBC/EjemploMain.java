package ProyectoMantenedorUsuariosJDBC;

import ProyectoMantenedorUsuariosJDBC.modelo.Usuario;
import ProyectoMantenedorUsuariosJDBC.repositorio.Repositorio;
import ProyectoMantenedorUsuariosJDBC.repositorio.UsuarioRepositorioImpl;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjemploMain {
    public static void main(String[] args) {
        Repositorio<Usuario> repo= new UsuarioRepositorioImpl();
        int opcionIndice = 0;

        do{
            Map<String, Integer> operaciones = new HashMap();
            operaciones.put("Actualizar", 1);
            operaciones.put("Eliminar", 2);
            operaciones.put("Agregar", 3);
            operaciones.put("Listar", 4);
            operaciones.put("Salir", 5);

            Object[] opArreglo = operaciones.keySet().toArray();

            Object opcion = JOptionPane.showInputDialog(null,
                    "Seleccione un Operación",
                    "Mantenedor de Usuarios",
                    JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
            } else {
                opcionIndice = operaciones.get(opcion.toString());
                int id;
                String usuario;
                String password;
                String email;
                Usuario u = null;
                // aca un if o switch para las distintas operaciones.
                switch (opcionIndice){
                    case 1:
                        System.out.println("Actualizar");
                        id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id"));
                        usuario = JOptionPane.showInputDialog("Ingrese usuario a actualizar");
                        password = JOptionPane.showInputDialog("Ingrese contraseña a actualizar");
                        email = JOptionPane.showInputDialog("Ingrese email a actualizar");
                        u = new Usuario();
                        u.setUsername(usuario);
                        u.setPassword(password);
                        u.setEmail(email);
                        u.setId(id);
                        repo.actualizar(u);
                        System.out.println("Usuario Actualizado");
                        break;
                    case 2:
                        System.out.println("Eliminar");
                        id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un id"));
                        repo.eliminar(id);
                        System.out.println("Usuario Eliminado");
                        break;
                    case 3:
                        System.out.println("Agregar");
                        usuario = JOptionPane.showInputDialog("Ingrese usuario a crear");
                        password = JOptionPane.showInputDialog("Ingrese su contraseña");
                        email = JOptionPane.showInputDialog("Ingrese su email");
                        u = new Usuario();
                        u.setUsername(usuario);
                        u.setPassword(password);
                        u.setEmail(email);
                        repo.crear(u);
                        System.out.println("Usuario Creado con exito");
                        break;
                    case 4:
                        System.out.println("Listar");
                        repo.listar().forEach(System.out::println);
                        break;
                    case 5:
                        System.out.println("Salir");
                        break;
                }
            }
        }while(opcionIndice!=5);
    }
}
