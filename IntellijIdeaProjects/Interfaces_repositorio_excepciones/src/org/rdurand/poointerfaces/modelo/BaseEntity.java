package org.rdurand.poointerfaces.modelo;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;

    private static int ultimoId;
    public BaseEntity() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
