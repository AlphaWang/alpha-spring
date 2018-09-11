package com.alphawang.spring.core.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultVo<T> {
    private int code;
    private String msg;
    private T data;
}
