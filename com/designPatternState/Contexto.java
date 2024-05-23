package com.designPatternState;

public class Contexto {
    private  Estado estado;

    public Contexto(){
        estado = null;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
