package com.webApp.demo.webApp.businessObjects;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class RealCustomer extends Customer {

    public RealCustomer(String fullName, String email){
        this.fullName = fullName;
        this.email = email;
    }

    @Override
    public String getContactInformation() {
        return String.format("%s - %s", this.fullName, this.email);
    }
}
