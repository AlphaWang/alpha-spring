package com.alphawang.spring.core.exceptionhandler;

import com.alphawang.spring.core.common.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultVo handleException(NullPointerException e, HttpServletRequest request) {
        log.error("URI : {}, NPE Exception : {}", request.getRequestURI(), e.getMessage(), e);
        return ResultVo.builder()
            .code(-1)
            .msg("NPE")
            .build();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResultVo handleException(ArithmeticException e, HttpServletRequest request) {
        log.error("URI : {}, ArithmeticException : {}", request.getRequestURI(), e.getMessage(), e);
        return ResultVo.builder()
            .code(-2)
            .msg("ArithmeticException")
            .build();
    }

    /**
     * ArithmeticException会走到这里
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo handleException(Exception e, HttpServletRequest request) {
        log.error("URI : {}, Exception : {}", request.getRequestURI(), e.getMessage(), e);
        return ResultVo.builder()
            .code(-3)
            .msg("Exception")
            .build();
    }
    
    
    
    @InitBinder 
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id"); 
    }
    
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); 
    }

    
}
