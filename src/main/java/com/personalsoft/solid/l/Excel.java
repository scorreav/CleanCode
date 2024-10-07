package com.personalsoft.solid.l;

public class Excel extends Report {

    protected Excel(String pName) {
        super(pName);
    }

    @Override
    public byte[] export() {
        return new byte[0];
    }
}
