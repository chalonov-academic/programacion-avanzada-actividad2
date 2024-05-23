package com.designPatternBuilder;

public interface Builder {
    Builder pedido(String pedido);
    Builder tipo (String tipo);
    Builder marca (String marca);
    Builder especialidad (String especialidad);
    Builder color (String color);
    Builder mensaje (String mensaje);
}
