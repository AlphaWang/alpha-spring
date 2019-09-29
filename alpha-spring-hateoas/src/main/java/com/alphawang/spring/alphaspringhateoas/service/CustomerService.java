package com.alphawang.spring.alphaspringhateoas.service;

import com.alphawang.spring.alphaspringhateoas.dto.Customer;
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
        final Customer customerOne = new Customer(10L, "Jane", "ABC Company");
        final Customer customerTwo = new Customer(20L, "Bob", "XYZ Company");
        final Customer customerThree = new Customer(30L, "Tim", "CKV Company");

        customerMap = Stream.of(customerOne, customerTwo, customerThree)
              .collect(Collectors.toMap(Customer::getCustomerId, Function.identity()));

    }
    
    public Customer getById(Long id) {
        return Optional.ofNullable(customerMap.get(id))
                        .map(Customer::copy)
                        .orElse(new Customer(0L, "NULL", "NULL"));
    }
    
    public List<Customer> getAll() {
        return customerMap.values().stream()
                            .map(Customer::copy)
                            .collect(Collectors.toList());
    }
    

}
