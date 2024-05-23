package com.designPatternBridge;

public class BicicletaRutaEscalada implements BicicletaRuta{
    private String tipo = "Escalada";

    @Override
    public String ensamblar() {
        this.tipo = tipo;
        return tipo;
    }

}
