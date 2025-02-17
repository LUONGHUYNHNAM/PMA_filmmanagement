package com.huynhnam.pma_filmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class homeController {

    @GetMapping("")
    public String home() {
        return "/home/home";
    }
}
