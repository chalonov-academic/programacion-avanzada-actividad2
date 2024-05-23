package com.designPatternBridge;

public class BicicletaRutaCrono implements BicicletaRuta {
    private String tipo = "Crono";

    @Override
    public String ensamblar() {
        this.tipo = tipo;
        return tipo;
    }
}
