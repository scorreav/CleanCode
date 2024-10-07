package com.personalsoft.solid.l;

public class Pdf extends Report {

    protected Pdf(String pName) {
        super(pName);
    }

    @Override
    public byte[] export() {
        return new byte[0];
    }
}
