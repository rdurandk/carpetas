package org.rdurandk.patrones.composite2;

public class ProgramarProyecto {
    private Proyecto miProyeto;
    private Responsable responsable1,responsable2,responsable3,responsable4,
    responsable5,responsable6,responsable7,responsable8,responsable9,responsable10,
    responsable11,responsable12,responsable13,responsable14,responsable15,responsable16;
    public ProgramarProyecto(){
        creaResponsables();
        creaProyectoPrincipal();
        creaSubProAnalisis();
        creaSubProDiseno();
        creaSubProDesarrollo();
        creaSubPruebas();
        creaSubProImplementacion();
        miProyeto.imprimir();
    }
    public void creaResponsables(){
        responsable1 = new Responsable("ALEXANDER DURAND", 7898989);
        responsable2 = new Responsable("DANIEL LOZADA", 6567575);
        responsable3 = new Responsable("JENIFFER GONZALES", 5454566);
        responsable4 = new Responsable("JORGE PEREZ", 7546564);
        responsable5 = new Responsable("CARLOS RODRIGUEZ", 7657777);
        responsable6 = new Responsable("ARMANDO GOMEZ", 3453345);
        responsable7 = new Responsable("DEIBIS JIMENEZ", 7564456);
        responsable8 = new Responsable("CRISTIAN BANNOY", 7564458);
        responsable9 = new Responsable("LICETH GUIZA", 2344554);
        responsable10 = new Responsable("EDWIN JIMENEZ", 2342334);
        responsable11 = new Responsable("LORENA GIRALDO", 4356366);
        responsable12 = new Responsable("CAROL MARTINEZ", 7686868);
        responsable13 = new Responsable("LEIDY PEREZ", 3453678);
        responsable14 = new Responsable("JUAN PABLO", 2347694);
        responsable15 = new Responsable("DIANA LANCHJEROS", 2354894);
        responsable16 = new Responsable("JEISON LENNIS", 2347000);
    }
    public void creaProyectoPrincipal(){
        miProyeto = new Proyecto("CREAR UN SOFTWARE", responsable1);
    }
    public void creaSubProAnalisis(){
        Proyecto subProyecto = new Proyecto("ANALISIS", responsable2);
        Entregable entregable = new Entregable("DOCUMENTO DE ANALISIS");

            Tarea tarea1 = new Tarea("IDENTIFICACION DE INTERESADOS", responsable3);
                Tarea subtarea1 = new Tarea("IDENTIFICAR USUARIOS", responsable4,36);
                Tarea subtarea2 = new Tarea("IDENTIFICAR TECNICOS", responsable5, 12);
            tarea1.addItemTarea(subtarea1);
            tarea1.addItemTarea(subtarea2);
            Tarea tarea2 = new Tarea("LEVANTAMIENTO DE REQUERIMIENTOS", responsable6);
                Tarea subtarea3 = new Tarea("IDENTIFICAR USUARIOS", responsable6 ,72);
                Tarea subtarea4 = new Tarea("IDENTIFICAR TECNICOS", responsable6,24);
            tarea2.addItemTarea(subtarea3);
            tarea2.addItemTarea(subtarea4);
            Tarea tarea3 = new Tarea("ANALISIS DE REQUERIMIENTOS", responsable7,72);

        subProyecto.addItemProyecto(entregable);
        subProyecto.addItemProyecto(tarea1);
        subProyecto.addItemProyecto(tarea2);
        subProyecto.addItemProyecto(tarea3);

        miProyeto.addItemProyecto(subProyecto);

    }
    public void creaSubProDiseno(){
        Proyecto subProyecto = new Proyecto("DISEÑO", responsable2);
        Entregable entregable = new Entregable("DOCUMENTO DE DISENO");

            Tarea tarea1 = new Tarea("DISEÑO DE CASOS DE USO", responsable8,34);
            Tarea tarea2 = new Tarea("DISEÑO DE SECUENCIAS", responsable8,24);
            Tarea tarea3 = new Tarea("DIAGRAMAS DE UML", responsable8,30);

        subProyecto.addItemProyecto(entregable);
        subProyecto.addItemProyecto(tarea1);
        subProyecto.addItemProyecto(tarea2);
        subProyecto.addItemProyecto(tarea3);

        miProyeto.addItemProyecto(subProyecto);
    }
    public void creaSubProDesarrollo(){
        Proyecto subProyecto = new Proyecto("DESARROLLO", responsable2);
        Entregable entregable = new Entregable("CODIGO FUENTE");

            Tarea tarea1 = new Tarea("DEFINICION DE LENGUAJES A USAR", responsable9,12);
            Tarea tarea2 = new Tarea("DESARROLLAR CODIGO", responsable10);
                Tarea subtarea1 = new Tarea("CODIGO DE CAPA DE DATOS", responsable11,120);
                Tarea subtarea2 = new Tarea("CODIGO DE CAPA DE LOGICA", responsable12,180);
                Tarea subtarea3 = new Tarea("CODIGO DE CAPA DE PRESENTACION", responsable13,120);
            tarea2.addItemTarea(subtarea1);
            tarea2.addItemTarea(subtarea2);
            tarea2.addItemTarea(subtarea3);

        subProyecto.addItemProyecto(entregable);
        subProyecto.addItemProyecto(tarea1);
        subProyecto.addItemProyecto(tarea2);

        miProyeto.addItemProyecto(subProyecto);
    }
    public void creaSubPruebas(){
        Proyecto subProyecto = new Proyecto("PRUEBAS", responsable2);
        Entregable entregable = new Entregable("DOCUMENTO DE ACEPTACION");
            Tarea tarea1 = new Tarea("REALIZACION DE PRUEBAS TECNICAS", responsable14,24);
            Tarea tarea2 = new Tarea("REALIZACION DE PRUEBAS DE USUARIO", responsable15,36);

        subProyecto.addItemProyecto(entregable);
        subProyecto.addItemProyecto(tarea1);
        subProyecto.addItemProyecto(tarea2);

        miProyeto.addItemProyecto(subProyecto);
    }
    public void creaSubProImplementacion() {
        Proyecto subProyecto = new Proyecto("IMPLEMENTACION", responsable2);
        Entregable entregable = new Entregable("SOFTWARE FUNCIONANDO");
        Tarea tarea1 = new Tarea("CONFIGURACION DEL SERVIDOR", responsable16,24);
        Tarea tarea2 = new Tarea("IMPLEMENTACION DE SOFTWARE", responsable2,24);

        subProyecto.addItemProyecto(entregable);
        subProyecto.addItemProyecto(tarea1);
        subProyecto.addItemProyecto(tarea2);

        miProyeto.addItemProyecto(subProyecto);
    }
}
