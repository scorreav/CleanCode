package com.personalsoft.solid.d;

/*
    Principio de Inversión de dependencias
    Establece que los módulos de alto nivel no deben depender de los módulos de nivel inferior, sino que ambos deben depender de abstracciones
 */
public class InversionDependencias {

    public static void main(String[] args) {
        var iInfo = new InfoByXML();
        var monitor = new Monitor("./data/info.json", iInfo);
        monitor.show();
    }
}
