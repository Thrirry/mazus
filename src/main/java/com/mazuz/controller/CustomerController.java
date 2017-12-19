package com.mazuz.controller;

import com.mazuz.domain.Customer;
import com.mazuz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("api/customer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @RequestMapping("api/customer/second")
    public List<Customer> getAllCustomerSecond(){
        return customerService.getAllCustomerSecond();
    }

    @RequestMapping("api/customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/api/customer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/customer/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
        customerService.updateCustomer(id, customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/customer/{id}")
    public void deleteProduct(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }



}
