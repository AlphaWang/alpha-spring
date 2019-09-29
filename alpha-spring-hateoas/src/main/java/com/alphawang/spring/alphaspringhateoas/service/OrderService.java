package com.alphawang.spring.alphaspringhateoas.service;

import com.alphawang.spring.alphaspringhateoas.dto.Customer;
import com.alphawang.spring.alphaspringhateoas.dto.Order;
import com.sun.tools.corba.se.idl.constExpr.Or;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static Map<Long, Order> orderMap;
    private static Map<Long, List<Order>> customerOrderMap;
    
    static {
        Order order1 = new Order(1001L, 150.00, 25);
        Order order2 = new Order(1002L, 250.00, 15);
        Order order3 = new Order(2001L, 550.00, 325);
        Order order4 = new Order(2002L, 450.00, 525);

        orderMap = Stream.of(order1, order2, order3, order4)
                            .collect(Collectors.toMap(Order::getOrderId, Function.identity()));

        customerOrderMap = new HashMap<>();
        customerOrderMap.put(10L, Stream.of(order1, order2).collect(Collectors.toList()));
        customerOrderMap.put(20L, Stream.of(order3).collect(Collectors.toList()));
        customerOrderMap.put(30L, new ArrayList<>());
    }
    
    public List<Order> getCustomerOrders(Long customerId) {
        List<Order> orders = customerOrderMap.get(customerId);
        if (orders == null) {
            return new ArrayList<>();
        }
        
        return orders.stream().map(Order::copy).collect(Collectors.toList());
    }
    
    public Order getOrderById(Long id) {
        return Optional.ofNullable(orderMap.get(id))
                       .map(Order::copy)
                       .orElse(new Order(0L, -1.0, -1));
    }
    
    
}
