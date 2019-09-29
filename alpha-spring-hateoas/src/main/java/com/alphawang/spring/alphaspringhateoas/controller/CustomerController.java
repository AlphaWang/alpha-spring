package com.alphawang.spring.alphaspringhateoas.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.alphawang.spring.alphaspringhateoas.dto.Customer;
import com.alphawang.spring.alphaspringhateoas.dto.Order;
import com.alphawang.spring.alphaspringhateoas.service.CustomerService;
import com.alphawang.spring.alphaspringhateoas.service.OrderService;
import com.sun.tools.corba.se.idl.constExpr.Or;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public List<Customer> getAll() {
        List<Customer> customers = customerService.getAll();
        customers.forEach(LinkBuilder::addCustomerLink);
        
        return customers;
    }
    
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getById(customerId);

        LinkBuilder.addCustomerLink(customer);

        return customer;
    }



}
