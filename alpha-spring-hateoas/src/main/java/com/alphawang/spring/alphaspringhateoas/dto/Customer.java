package com.alphawang.spring.alphaspringhateoas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
@AllArgsConstructor
public class Customer extends ResourceSupport {
    private Long customerId;
    private String name;
    private String companyName;

    public Customer copy() {
        return new Customer(customerId, name, companyName);
    }
}
