package com.designPatternBuilder;

public class Director {

    public void buildBike(Builder builder) {
        builder.pedido("Por confirmar");
        builder.mensaje("Confirma el pedido (1 : Sí), (2 : No): ");
    }
}
