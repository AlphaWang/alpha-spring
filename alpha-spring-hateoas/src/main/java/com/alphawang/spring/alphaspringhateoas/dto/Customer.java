package com.alphawang.spring.alphaspringhateoas.dto;

import java.util.List;
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
    
    List<Long> orders;

    public Customer copy() {
        return new Customer(customerId, name, companyName, orders);
    }
}
