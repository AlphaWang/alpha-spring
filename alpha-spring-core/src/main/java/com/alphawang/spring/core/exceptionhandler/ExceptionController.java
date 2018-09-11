package com.alphawang.spring.core.exceptionhandler;

import com.alphawang.spring.core.common.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    
    @GetMapping("/exception")
    public ResultVo<String> mockException() {
        int code = 100 / 0;
        return ResultVo.<String>builder().code(code).data("result").build();
    }
}
