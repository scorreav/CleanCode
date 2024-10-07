package com.personalsoft.solid.o;

public class Inicio {

    public static void main(String[] args) {
        var circulo = new Circulo(2);
        var cuadrado = new Cuadrado(5);

        var figura = new Figura();
        System.out.println(figura.area(circulo));
        System.out.println(figura.diametro(circulo));
        System.out.println(figura.area(cuadrado));
    }
}
