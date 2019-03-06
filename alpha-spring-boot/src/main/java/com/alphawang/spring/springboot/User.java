package com.alphawang.spring.springboot;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private Long id;
    private String name;
}
