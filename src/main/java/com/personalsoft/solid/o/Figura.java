package com.personalsoft.solid.o;

/*
    Principio Abierto/Cerrado
    Las entidades debe estar abiertas para extensión pero cerradas para su modificación.

    Agregar nuevas funcionalidades sin la modificación del código.

    Código de mantener en el largo plazo
 */
public class Figura {

    public double area (IOperacionesFigura  iOperacionesFigura) {
        return iOperacionesFigura.area();
    }

    public double diametro (IOperacionesFigura  iOperacionesFigura) {
        return iOperacionesFigura.diametro();
    }
}
