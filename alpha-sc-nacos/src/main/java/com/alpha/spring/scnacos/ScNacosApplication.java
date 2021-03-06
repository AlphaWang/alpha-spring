package com.alpha.spring.scnacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScNacosApplication.class, args);
    }

    @NacosInjected
    private ConfigService configService;

    @NacosConfigListener(dataId = "cart_front_api.properties")
    public void onMessage(String config) {
        System.out.println("NACOS UPDATED 2 " + config);
    }
}
