package com.org.kris.bankgateway.domain;

import org.junit.Assert;
import org.junit.Test;

public class OutgoingRequestTest {

    @Test
    public void testOutgoingRequestCreation(){
        OutgoingRequest outReq = new OutgoingRequest("testCode", "testNumber");
        Assert.assertEquals("testCode", outReq.getSortCode());
        Assert.assertEquals("testNumber", outReq.getAccountNumber());
    }
}
