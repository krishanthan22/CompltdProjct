package com.org.kris.bankgateway.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EntryTest {

    @Test
    public void testEntryCreation(){
        Entry temp = new Entry("provider1", false);
        Assert.assertEquals("provider1", temp.getProvider());
        Assert.assertEquals(false, temp.getIsValid());
    }
}
