package com.org.kris.bankgateway.domain;

public class Entry {

    private String provider;
    private boolean isValid;

    public Entry(String provider, boolean isValid){
        this.provider = provider;
        this.isValid = isValid;
    }

    public String getProvider() {
        return provider;
    }

    public boolean getIsValid() {
        return isValid;
    }
}
