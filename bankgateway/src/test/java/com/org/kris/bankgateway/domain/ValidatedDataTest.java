package com.org.kris.bankgateway.domain;

import org.junit.Assert;
import org.junit.Test;

public class ValidatedDataTest {

    @Test
    public void testValidatedDataCreation(){

        ValidatedData data = new ValidatedData(null);
        Assert.assertNull(data.getResult());
        Entry [] entry = new Entry[]{new Entry("provider1", true)};
        data = new ValidatedData(entry);
        Assert.assertNotNull(data.getResult());
    }
}
