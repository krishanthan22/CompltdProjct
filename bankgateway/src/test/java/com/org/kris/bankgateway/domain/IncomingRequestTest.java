package com.org.kris.bankgateway.domain;

import org.junit.Assert;
import org.junit.Test;

public class IncomingRequestTest {

    @Test
    public void testIncomingRequestCreation(){
        IncomingRequest request = new IncomingRequest("1234", "6789",null);
        Assert.assertEquals("1234",request.getSortCode());
        Assert.assertEquals("6789",request.getAccountNumber());
        Assert.assertNull(request.getProviders());
    }
}
