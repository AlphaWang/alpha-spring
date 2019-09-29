package com.alphawang.spring.alphaspringhateoas.service;

import com.alphawang.spring.alphaspringhateoas.dto.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private Map<Long, Customer> customerMap;

    public CustomerService() {
        final Customer customerOne = new Customer(10L, "Jane", "ABC Company", list(1001L, 1002L));
        final Customer customerTwo = new Customer(20L, "Bob", "XYZ Company",list(2001L));
        final Customer customerThree = new Customer(30L, "Tim", "CKV Company", null);

        customerMap = Stream.of(customerOne, customerTwo, customerThree)
              .collect(Collectors.toMap(Customer::getCustomerId, Function.identity()));

    }
    
    public Customer getById(Long id) {
        return Optional.ofNullable(customerMap.get(id))
                        .map(Customer::copy)
                        .orElse(new Customer(0L, "NULL", "NULL", null));
    }
    
    public List<Customer> getAll() {
        return customerMap.values().stream()
                            .map(Customer::copy)
                            .collect(Collectors.toList());
    }
    
    private <T> List  list(T... items) {
        if (items == null) {
            return new ArrayList();
        }
        return Stream.of(items).collect(Collectors.toList());
    }
    

}
