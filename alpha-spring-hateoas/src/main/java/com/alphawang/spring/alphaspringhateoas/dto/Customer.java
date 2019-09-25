package com.alphawang.spring.alphaspringhateoas.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
public class Customer extends ResourceSupport {
    private Long customerId;
    private String name;
    private String companyName;

}
