package com.designPatternState;

public class EstadoCompraRealizada implements Estado{

    @Override
    public void cambiarEstado(Contexto contexto) {
        contexto.setEstado(this);
    }

    @Override
    public String mensajePedido() {
        return "Escriba salir() para cerrar el chat";
    }

    @Override
    public String toString() {
        return "Compra Realizada";
    }
}
