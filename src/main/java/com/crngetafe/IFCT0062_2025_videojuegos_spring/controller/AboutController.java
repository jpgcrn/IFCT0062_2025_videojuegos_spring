package com.crngetafe.IFCT0062_2025_videojuegos_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    public AboutController() {
    }

    @GetMapping("/about")
    public String About() {
        return "about";
    }
}
