package com.alphawang.spring.alphaspringhateoas.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.alphawang.spring.alphaspringhateoas.dto.Customer;
import com.alphawang.spring.alphaspringhateoas.dto.Order;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class LinkBuilder {

    public static void addCustomerLink(Customer customer) {
        if (customer != null) {
            /**
             * "_links": {
             *   "self": {
             *     "href": "http://localhost:8080/customers/100"
             *   }
             * }
             */
            // customer.add(new Link("http://localhost:8080/customers/" + id) );

            // save as above.
            Link selfLink = ControllerLinkBuilder.linkTo(CustomerController.class)
                                                 .slash(customer.getCustomerId())
                                                 .withSelfRel();

            Link orderLink = ControllerLinkBuilder.linkTo(methodOn(OrderController.class).getCustomerOrders(customer.getCustomerId()))
                                                  .withRel("allOrders");
            customer.add(selfLink);
            customer.add(orderLink);


        }
    }

    public static void addOrderLink(Long customerId, Order order) {
        Link selfLink = ControllerLinkBuilder.linkTo(methodOn(OrderController.class).getOrder(customerId, order.getOrderId())).withSelfRel();
        Link testLink = ControllerLinkBuilder.linkTo(methodOn(OrderController.class).getOrder(customerId, order.getOrderId())).withRel("test");
        order.add(selfLink);
        order.add(testLink);
    }

    public static Link buildOrdersLink(Long customerId) {
        Link selfLink = ControllerLinkBuilder.linkTo(methodOn(OrderController.class).getCustomerOrders(customerId)).withSelfRel();
        return selfLink;
    }

}
