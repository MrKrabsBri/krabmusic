package com.krabs.krabmusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    //Assigninam endpoint to "/"
    //@RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return "Welcome, Mr. Krabs! This is KrabMusic Platform!";
    }
}

