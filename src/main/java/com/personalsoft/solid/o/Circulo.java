package com.personalsoft.solid.o;

public class Circulo implements IOperacionesFigura {

    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return 3.1415 * Math.pow(radio, 2);
    }

    @Override
    public double diametro() {
        return 0;
    }
}
