package com.alphawang.spring.alphaspringhateoas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
@AllArgsConstructor
public class Order extends ResourceSupport {
    private Long orderId;
    private Double price;
    private int quantity;

    public Order copy() {
        return new Order(orderId, price, quantity);
    }
}
