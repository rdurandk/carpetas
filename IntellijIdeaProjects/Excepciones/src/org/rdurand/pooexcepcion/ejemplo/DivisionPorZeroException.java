package org.rdurand.pooexcepcion.ejemplo;

public class DivisionPorZeroException extends Exception{//hacemos que el error sea checked(obligatorio capturar el tipo de error)
    public DivisionPorZeroException(String mensaje){
        super(mensaje);
    }
}
