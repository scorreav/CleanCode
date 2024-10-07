package com.personalsoft.solid.l;

import java.util.Arrays;

/*
    Principio de Substitución de Liskov
    Cada subclase o clase derivada debe ser sustituible por su clase base o padre sin afectar la ejecución del programa

    La clase hija no debe afectar el comportamiento del padre
 */
public class SubstitutionLiskov {

    public void sendReport(int typeReport, String name) {
        Report report;

        if(typeReport == 1)
            report = new Excel(name);
        else
            report = new Pdf(name);

        System.out.println(Arrays.toString(report.export()));
    }
}
