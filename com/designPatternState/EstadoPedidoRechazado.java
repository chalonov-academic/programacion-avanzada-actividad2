package com.designPatternState;

public class EstadoPedidoRechazado implements Estado{

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
        return "Pedido Rechazado";
    }
}
