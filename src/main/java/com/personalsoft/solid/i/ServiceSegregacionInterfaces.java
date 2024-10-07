package com.personalsoft.solid.i;

import java.util.List;

/*
    Principio de Segregación de interfaces
    Ninguna clase debe implementar métodos que no utilice
 */
public class ServiceSegregacionInterfaces implements IMethod, ISearch {

    private String global;

    public ServiceSegregacionInterfaces() {
        global = "global";
    }

    @Override
    public String add(int id, String toAdd) {
        return global + toAdd;
    }

    @Override
    public boolean delete(int id) {
        global = "";
        return global.isEmpty();
    }

    @Override
    public boolean update(int id, String newString) {
        global = newString;
        return global.equals(newString);
    }

    @Override
    public String getString(int id) {
        return global;
    }

    @Override
    public List<String> getStringsWithId(int id) {
        return List.of(global);
    }

    @Override
    public List<String> findWithNullId() {
        return List.of(global);
    }

}
