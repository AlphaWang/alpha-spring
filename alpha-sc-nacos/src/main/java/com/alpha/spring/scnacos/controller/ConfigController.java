package com.alpha.spring.scnacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {


    /**
     * For Nacos Config:
     * - dataId: cart_front_api.properties
     * - group: DEFAULT_GROUP
     * - content: cart.page.itemCount
     *
     * curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=cart_front_api.properties&group=DEFAULT_GROUP&content=cart.page.itemCount=70"
     */
    
    @Value("${cart.page.itemCount:10}")
    private String itemCount;

    @RequestMapping("cart-count")
    public String getItemCount() {
        return itemCount;
    }
    
}
