package com.appiciel.youcoffee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    @GetMapping("/")
    public String getCoffee() {
        return "Welcome to YouCoffee";
    }
}
