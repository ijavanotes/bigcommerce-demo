package com.sony.bigcommerce.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.sony.bigcommerce.demo.exception.BaseRunTimeException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(BaseRunTimeException.class)
    public ModelAndView handleMyException(BaseRunTimeException e) {
 
        ModelAndView model = new ModelAndView();
        model.addObject("code", e.getStatus().getCode());
        model.addObject("errMsg", e.getStatus().getError());
        model.setViewName("error");
        return model;
    }
}
