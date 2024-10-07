package com.personalsoft.solid.l;

public abstract class Report {

    private final String name;

    protected Report(String pName) {
        this.name = pName;
    }

    public abstract byte[] export();

    public String getName() {
        return name;
    }
}
