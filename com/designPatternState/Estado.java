package com.designPatternState;

public interface Estado {
    public void cambiarEstado(Contexto contexto);
    public String mensajePedido();
}
