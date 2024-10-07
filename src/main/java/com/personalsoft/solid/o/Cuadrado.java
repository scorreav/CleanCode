package com.personalsoft.solid.o;

public class Cuadrado  implements IOperacionesFigura {

    private final double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double diametro() {
        return 0;
    }
}
