package com.org.kris.bankgateway.domain;

public class ValidatedData {
    private Entry[] result;

    public ValidatedData(Entry[]result){
        this.result=result;
    }

    public Entry[] getResult() {
        return result;
    }
}
