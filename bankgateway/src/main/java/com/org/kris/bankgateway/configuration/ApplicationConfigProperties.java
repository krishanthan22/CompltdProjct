package com.org.kris.bankgateway.configuration;

import com.org.kris.bankgateway.configuration.model.Provider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@ConfigurationProperties
public class ApplicationConfigProperties {

    private List<Provider> providers = new ArrayList<>();

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public Map<String, Provider> getProviderMap(){
        Map<String, Provider> providerMap = getProviders().stream()
                .collect( Collectors.toMap(Provider::getName,
                        Function.identity()) );
        return providerMap;
    }

    @Override
    public String toString() {
        return "ApplicationConfigProperties{" +
                "providers=" + providers +
                '}';
    }
}
