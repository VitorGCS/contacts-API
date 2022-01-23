package com.webApp.demo.webApp.controllers;

import com.webApp.demo.webApp.businessObjects.Customer;
import com.webApp.demo.webApp.businessObjects.RealCustomer;
import com.webApp.demo.webApp.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService theCustomerService) { customerService = theCustomerService;}

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<String> getCustomerContactInf(@PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);
        return ResponseEntity.ok().body(customer.getContactInformation());
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Boolean> addCustomer(@RequestBody RealCustomer theRealCustomer) {
        customerService.formatAndSave(theRealCustomer);
        return ResponseEntity.ok().body(true);
    }
}
