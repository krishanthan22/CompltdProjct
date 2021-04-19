package com.org.kris.bankgateway.controller;

import com.org.kris.bankgateway.domain.Entry;
import com.org.kris.bankgateway.domain.IncomingRequest;
import com.org.kris.bankgateway.domain.ValidatedData;
import com.org.kris.bankgateway.service.DataProviderService;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BankAccountControllerTest {

    @InjectMocks
    BankAccountController mockController;

    @Mock
    DataProviderService mockService;

    @Test
    public void testGetAccountStatus(){
        Entry[] entry = new Entry[]{new Entry("provider1", true)};
        ValidatedData data = new ValidatedData(entry);
        when(mockService.getAccountStatus(any(IncomingRequest.class))).thenReturn(data);
        IncomingRequest reqeust = new IncomingRequest("testCode", "testNo", null);
        Assert.assertEquals("provider1", mockController.validate(reqeust).getResult()[0].getProvider());
        Assert.assertEquals(true, mockController.validate(reqeust).getResult()[0].getIsValid());
    }
}
