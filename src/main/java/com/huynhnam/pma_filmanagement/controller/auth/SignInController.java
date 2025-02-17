package com.huynhnam.pma_filmanagement.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

    @RequestMapping("/sign-in")
    public String signIn() {
        return "auth/sign-in-view";
    }

}
