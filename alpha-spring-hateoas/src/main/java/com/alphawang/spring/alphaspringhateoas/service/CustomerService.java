package com.alphawang.spring.alphaspringhateoas.service;

import com.alphawang.spring.alphaspringhateoas.dto.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    public Customer getById(Long id) {
        return Customer.builder()
                       .id(id)
                       .name("Alpha" + id)
                       .companyName("github")
                       .build(); 
    }
    

}
