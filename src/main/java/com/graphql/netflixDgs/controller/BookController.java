package com.graphql.netflixDgs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @RequestMapping("hello")
    public String hellow(){
        return "Hello World";
    }
}
