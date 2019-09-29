package com.alphawang.spring.alphaspringhateoas.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.alphawang.spring.alphaspringhateoas.dto.Order;
import com.alphawang.spring.alphaspringhateoas.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/{customerId}")
    public List<Order> getCustomerOrders(@PathVariable Long customerId) {
        List<Order> orders = orderService.getCustomerOrders(customerId);
        
        orders.forEach(order -> LinkBuilder.addOrderLink(customerId, order));
        
        return orders;
    }
    
    
    @RequestMapping("/{customerId}/{orderId}")
    public Order getOrder(@PathVariable Long customerId, @PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        LinkBuilder.addOrderLink(customerId, order);
        
        return order;
    }
    
    

}
