package com.cheney.manage.controller;

import com.cheney.manage.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @Author mineChen
 * @Date 2020/6/17 16:42
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    @Log("访问Hello")
    public String hello(){
        return "hello!!!";
    }
}
