package com.alphawang.spring.alphaspringhateoas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long id;
    private String name;
    private String companyName;

}
