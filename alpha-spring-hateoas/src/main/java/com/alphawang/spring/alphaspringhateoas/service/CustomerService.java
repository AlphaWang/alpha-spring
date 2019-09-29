package com.alphawang.spring.alphaspringhateoas.service;

import com.alphawang.spring.alphaspringhateoas.controller.CustomerController;
import com.alphawang.spring.alphaspringhateoas.dto.Customer;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    public Customer getById(Long id) {
        Customer customer = Customer.builder()
                       .customerId(id)
                       .name("Alpha" + id)
                       .companyName("github")
                       .build();

        /**
         * "_links": {
         *   "self": {
         *     "href": "http://localhost:8080/customers/100"
         *   }
         * }
         */
//        customer.add(new Link("http://localhost:8080/customers/" + id) );

        // save as above.
        Link link = ControllerLinkBuilder.linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
        customer.add(link);
        
        return customer;
    }
    

}
