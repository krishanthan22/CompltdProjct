package com.org.kris.bankgateway.service;

import com.org.kris.bankgateway.configuration.ApplicationConfigProperties;
import com.org.kris.bankgateway.configuration.model.Provider;
import com.org.kris.bankgateway.domain.Entry;
import com.org.kris.bankgateway.domain.IncomingRequest;
import com.org.kris.bankgateway.service.impl.DataProviderServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataProviderServiceImplTest {

    @InjectMocks
    private DataProviderServiceImpl service;

    @Mock
    private RestTemplate mockTemplate;

    @Mock
    private ApplicationConfigProperties properties;

    @Test
    public void testGetAccountStatus(){
        String[] providerData = new String[]{"provider1"};
        IncomingRequest incomingRequest = new IncomingRequest("1234","12345", providerData);

        Entry entry = new Entry("provider1", true);
        Provider resultProvider = new Provider();
        resultProvider.setName("provider1");
        resultProvider.setUrl("test.com");

        Map<String, Provider> providerMap = new HashMap<>();
        providerMap.put("provider1",resultProvider);

        when(properties.getProviderMap()).thenReturn(providerMap);

        when(mockTemplate.postForObject(Mockito.any(String.class),
                Mockito.any(Object.class), Mockito.any(Class.class))).
                thenReturn( new ResponseEntity<>(entry, HttpStatus.OK));
        Assert.assertTrue(service.getAccountStatus(incomingRequest).getResult().length == 1);
        Assert.assertTrue(service.getAccountStatus(incomingRequest).getResult()[0].getIsValid());

    }

}
