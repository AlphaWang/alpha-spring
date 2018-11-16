package com.alphawang.spring.core.aop.aspectj.introducction;

public class SmartSeller implements Seller {
    @Override 
    public void sell(String product) {
        System.out.println("SmartSeller.sell " + product);
    }
}
