package com.designPatternBuilder;

public class Bike {
    private final String pedido;
    private final String tipo;
    private final String marca;
    private final String especialidad;
    private final String color;
    private final String mensaje;

    Bike(String pedido, String marca, String tipo, String especialidad, String color, String mensaje){
        this.pedido = pedido;
        this.marca = marca;
        this.tipo = tipo;
        this.especialidad = especialidad;
        this.color = color;
        this.mensaje = mensaje;
    }

    public String toString(){
        return """
        ¬Pedido de producto (Bicicleta)¬Estado: %s¬- marca: %s¬- tipo: %s¬- especialidad: %s¬- color: %s¬¬%s
        """.formatted(pedido, marca, tipo, especialidad, color, mensaje).replace("\n", "¬");
    }
}
