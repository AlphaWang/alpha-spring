package com.alphawang.spring.alphaspringhateoas.controller;

import com.alphawang.spring.alphaspringhateoas.dto.Customer;
import com.alphawang.spring.alphaspringhateoas.service.CustomerService;
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
        customers.forEach(this::addCustomerLink);
        
        return customers;
    }
    
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getById(customerId);

        addCustomerLink(customer);

        return customer;
    }

    private void addCustomerLink(Customer customer) {
        if (customer != null) {
            /**
             * "_links": {
             *   "self": {
             *     "href": "http://localhost:8080/customers/100"
             *   }
             * }
             */
            // customer.add(new Link("http://localhost:8080/customers/" + id) );

            // save as above.
            Link link = ControllerLinkBuilder.linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
            customer.add(link);
        }
    }

}
