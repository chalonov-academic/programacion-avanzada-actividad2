package com.designPatternBridge;

public class BicicletasRutaEnsambladora extends FabricaBicicletasRuta{

    public BicicletasRutaEnsambladora(BicicletaRuta bicicletaRuta){
        super(bicicletaRuta);
    }

    @Override
    public String vender() {
        return bicicletaRuta.ensamblar();
    }
}
