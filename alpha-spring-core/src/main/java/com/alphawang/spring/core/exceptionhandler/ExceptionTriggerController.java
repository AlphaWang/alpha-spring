package com.alphawang.spring.core.exceptionhandler;

import com.alphawang.spring.core.common.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTriggerController {
    
    @GetMapping("/exception")
    public ResultVo<String> mockException() {
        /**
         * 1. If no exception handler:
         *    
         * There was an unexpected error (type=Internal Server Error, status=500).
         * / by zero
         */

        /**
         * 2. with ExceptionHandlerController:
         *    return a customized error page.
         */
        int code = 100 / 0;
        return ResultVo.<String>builder().code(code).data("result").build();
    }



}
