package com.designPatternState;

public class EstadoPedidoRealizado implements Estado{

    @Override
    public void cambiarEstado(Contexto contexto) {
        contexto.setEstado(this);
    }

    @Override
    public String mensajePedido() {
        return "Confirma el pedido (1 : Sí), (2 : No): ";
    }

    @Override
    public String toString() {
        return "Pedido a confirmar";
    }
}
