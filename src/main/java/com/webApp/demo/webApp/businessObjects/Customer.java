package com.webApp.demo.webApp.businessObjects;

import lombok.Data;

@Data
public abstract class Customer {
    String fullName;
    String email;

    public abstract String getContactInformation();

}
