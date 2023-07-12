package org.rdurandk.genericos;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado <T>{
    private List<T> bolsa;
    private int max=5;

    public BolsaSupermercado() {
        this.bolsa = new ArrayList<>();
    }

    public void addProducto(T t){
        if(bolsa.size()<max){
            this.bolsa.add(t);
        }
    }

    public List<T> getProductos(){
        return this.bolsa;
    }

}
