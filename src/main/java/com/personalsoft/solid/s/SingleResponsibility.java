package com.personalsoft.solid.s;
/*
    Principio de Responsabilidad Única
    Una clase solo debe tener una única responsabilidad y razón para cambiar.

    Facilita a:
     - La comprensión
     - El mantenimiento
     - Modificaciones
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class SingleResponsibility {

    private final List<Integer> employees;
    
    public SingleResponsibility() {
        employees = new ArrayList<>();
    }

    public Optional<Integer> findEmployee(int id) {
        return employees.stream()
                .filter(integer -> id == integer)
                .findFirst();
    }

    public void addEmployee(int employeeId) {
        employees.add(employeeId);
    }

    public boolean modifyEmployee(int pastId, int newId) {
        boolean rta = false;

        for (int i = 0; i < employees.size() && Boolean.FALSE.equals(rta); i++) {
            if(employees.get(i) == pastId) {
                employees.set(i, newId);
                rta = true;
            }
        }

        return rta;
    }

    public Consumer<List<Integer>> generateReport = integers -> integers.forEach(listEmployees -> System.out.println("Employee N° " + listEmployees));

    public void reporte() {
        for (Integer empleado: employees)
            System.out.println(empleado);
    }

}
