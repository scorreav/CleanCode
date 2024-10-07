package com.personalsoft.solid.i;

public interface IMethod {
    String add(int id, String toAdd);
    boolean delete(int id);
    boolean update(int id, String newString);
    String getString(int id);
}
