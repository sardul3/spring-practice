package com.sagar.sprrestdatademo.controller;

import com.sagar.sprrestdatademo.bean.HelloWorldBean;
import com.sagar.sprrestdatademo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    private MessageSource messageSource;

    @Autowired
    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/{id}")
    public String getHelloWorld(@PathVariable int id) {
        if(id>5){ throw new UserNotFoundException("Testing user not found ex..."); }
        return "Hello World";
    }

    @GetMapping("/bean")
    public String getHelloWorldBean() {
        return messageSource.getMessage("greeting.message",null, LocaleContextHolder.getLocale());
//        return new HelloWorldBean("Welcome - from bean");
    }

}
