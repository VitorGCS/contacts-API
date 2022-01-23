package com.webApp.demo.webApp.service;

import com.webApp.demo.webApp.businessObjects.Customer;
import com.webApp.demo.webApp.businessObjects.RealCustomer;

public interface CustomerService {

    Customer findById(int theId);

    void formatAndSave(RealCustomer theRealCustomer);

}
