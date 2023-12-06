package com.example.springecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AuthControllers {
    @GetMapping
    public String index() {
        return "index";
    }
}
