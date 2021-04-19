package com.org.kris.bankgateway.controller;

import com.org.kris.bankgateway.domain.IncomingRequest;
import com.org.kris.bankgateway.domain.ValidatedData;
import com.org.kris.bankgateway.service.DataProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

    @Autowired
    DataProviderService providerService;

    @PostMapping("/validateAccount")
    public ValidatedData validate(@RequestBody IncomingRequest incomingRequest) {
        return providerService.getAccountStatus(incomingRequest);
    }
}
