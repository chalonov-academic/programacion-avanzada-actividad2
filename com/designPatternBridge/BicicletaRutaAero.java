package com.designPatternBridge;

public class BicicletaRutaAero implements BicicletaRuta{
    private String tipo = "Aero";

    @Override
    public String ensamblar() {
        this.tipo = tipo;
        return tipo;
    }
}
