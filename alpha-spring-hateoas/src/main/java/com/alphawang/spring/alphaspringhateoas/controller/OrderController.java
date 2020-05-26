package com.alphawang.spring.alphaspringhateoas.controller;

import com.alphawang.spring.alphaspringhateoas.dto.Order;
import com.alphawang.spring.alphaspringhateoas.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * List is NOT ResourceSupport, 所以不能正常加入 `_links` 字段；只能加入 `links`；
     * 可改用 Resources 包装。
     * 
     */
    @RequestMapping("/{customerId}")
    public List<Order> getCustomerOrders(@PathVariable Long customerId) {
        List<Order> orders = orderService.getCustomerOrders(customerId);
        
        orders.forEach(order -> LinkBuilder.addOrderLink(customerId, order));
        
        return orders;
    }

    @RequestMapping(value = "resources/{customerId}", produces = { "application/hal+json" })
    public Resources<Order> getCustomerOrderResources(@PathVariable Long customerId) {
        List<Order> orders = orderService.getCustomerOrders(customerId);

        orders.forEach(order -> LinkBuilder.addOrderLink(customerId, order));
        Link selfLink = LinkBuilder.buildOrdersLink(customerId);

        return new Resources<>(orders,   // `_embedded`
                               selfLink); // `_links`
    }
    
    
    @RequestMapping("/{customerId}/{orderId}")
    public Order getOrder(@PathVariable Long customerId, @PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        LinkBuilder.addOrderLink(customerId, order);
        
        return order;
    }
    
    

}
