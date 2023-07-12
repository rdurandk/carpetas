package org.rdurand.poointerfaces.imprenta.modelo;

public interface Imprimible {
    //en Interfaces se puede crear atributos pero constantes(final) y static
    final static String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";
    default String imprimir(){
        return TEXTO_DEFECTO;
    }
    //cuando es default no sera necesario implementar un cuerpo a las clases concretas
    //pero igual puedes hacerlo como es el caso

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
        //este cuerpo sera reemplazado si es @OVERRIDE
    }

}
