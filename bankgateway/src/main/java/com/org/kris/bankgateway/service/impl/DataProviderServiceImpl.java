package com.org.kris.bankgateway.service.impl;

import com.org.kris.bankgateway.configuration.ApplicationConfigProperties;
import com.org.kris.bankgateway.configuration.model.Provider;
import com.org.kris.bankgateway.domain.IncomingRequest;
import com.org.kris.bankgateway.domain.OutgoingRequest;
import com.org.kris.bankgateway.domain.Entry;
import com.org.kris.bankgateway.domain.ValidatedData;
import com.org.kris.bankgateway.service.DataProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

@Service
public class DataProviderServiceImpl implements DataProviderService {

    @Autowired
    ApplicationConfigProperties properties;

    @Autowired(required = false)
    private RestTemplate restTemplate;

    @Override
    public ValidatedData getAccountStatus(IncomingRequest request) {
        Provider[] providerArray = getProviders(request.getProviders());
        return new ValidatedData(getEntriesFromProviders(request, providerArray));
    }

    Entry[] getEntriesFromProviders(IncomingRequest request, Provider[] providerArray){
        Entry[] entries = new Entry[providerArray.length];
        int index = 0;
        for(Provider provider: providerArray){
            //makes an external call to provider URL
            ResponseEntity<Entry> response = restTemplate.postForObject(
                    provider.getUrl(),
                    new OutgoingRequest(request.getSortCode(),
                            request.getAccountNumber()),
                    ResponseEntity.class);
            entries[index] = response.getBody();
            index++;
        }
        return entries;
    }

    Provider[] getProviders(String[] providers){
        Provider[] providerArray = null;
        if (providers != null && providers.length > 0){
            providerArray = new Provider[providers.length];
            int index = 0;
            for (String providerName:providers){
                if(Objects.nonNull(properties.getProviderMap().get(providerName)))
                providerArray[index] = properties.getProviderMap().get(providerName);
                index++;
            }
        }else{
            providerArray = properties.getProviders().toArray(new Provider[properties.getProviders().size()]);
        }
        return providerArray;
    }
}
