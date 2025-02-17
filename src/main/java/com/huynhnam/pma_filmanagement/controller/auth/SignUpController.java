package com.huynhnam.pma_filmanagement.controller.auth;

import com.huynhnam.pma_filmanagement.dto.RegisterDTO;
import com.huynhnam.pma_filmanagement.model.User;
import com.huynhnam.pma_filmanagement.service.iservice.IUserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {


    private final PasswordEncoder passwordEncoder;
    private final IUserService userService;

    public SignUpController(PasswordEncoder passwordEncoder, IUserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }


    @RequestMapping("/sign-up")
    public String signUp(@ModelAttribute("registerUser") RegisterDTO registerDTO) {
        return "auth/sign-up-view";
    }

    @PostMapping("/sign-up")
    public String register(@Valid @ModelAttribute("registerUser") RegisterDTO registerUser,
                           BindingResult bindingResult,
                           Model model) {
        if(bindingResult.hasErrors()) {
            return "auth/sign-up-view";
        }
        User user = userService.registerDTOToUser(registerUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saveUser = userService.addUser(user);
        if(saveUser != null) {
            return "redirect:/sign-in";
        }
        model.addAttribute("msg", "Register unsuccessful !");
        return "auth/sign-up-view";
    }

}
