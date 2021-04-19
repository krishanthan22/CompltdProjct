package com.org.kris.bankgateway.service;

import com.org.kris.bankgateway.domain.IncomingRequest;
import com.org.kris.bankgateway.domain.ValidatedData;


public interface DataProviderService {
    ValidatedData getAccountStatus(IncomingRequest request);
}
