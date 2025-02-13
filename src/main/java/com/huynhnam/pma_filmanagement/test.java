package com.huynhnam.pma_filmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class test {

    @GetMapping("/test")
    public String test() {
        return "layout";
    }
}
