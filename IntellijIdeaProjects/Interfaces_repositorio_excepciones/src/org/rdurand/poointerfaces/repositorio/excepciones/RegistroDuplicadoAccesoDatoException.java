package org.rdurand.poointerfaces.repositorio.excepciones;

public class RegistroDuplicadoAccesoDatoException extends EscrituraAccesoDatosException{
    public RegistroDuplicadoAccesoDatoException(String mensaje){
        super(mensaje);
    }
}
