package com.personalsoft.solid.o;

public class Triangulo implements IOperacionesFigura {

    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public double diametro() {
        return 0;
    }
}
