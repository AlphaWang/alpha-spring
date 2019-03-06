package com.alphawang.spring.mvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    
    private Long testId;
}
