package com.designPatternBuilder;

public class BikeBuilder implements Builder{
    private String pedido;
    private String tipo;
    private String marca;
    private String especialidad;
    private String color;
    private String mensaje;

    @Override
    public BikeBuilder pedido(String pedido) {
        this.pedido = pedido;
        return this;
    }

    @Override
    public BikeBuilder tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public Builder marca(String marca) {
        this.marca = marca;
        return this;
    }

    @Override
    public Builder especialidad(String especialidad) {
        this.especialidad = especialidad;
        return this;
    }

    @Override
    public Builder color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public Builder mensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public Bike build(){
        return new Bike(pedido, marca, tipo, especialidad, color, mensaje);
    }
}
