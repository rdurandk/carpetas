package org.rdurandk.modulo;

public class BaseEntity {
    private Integer id;
    private static int ultimoId;

    public BaseEntity(){
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }
}
