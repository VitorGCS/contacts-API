package com.webApp.demo.webApp.businessObjects;

import org.springframework.stereotype.Component;

@Component
public class NullCustomer extends Customer {

    @Override
    public String getContactInformation() {
        return "No Contact available";
    }
}
