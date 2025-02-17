package com.huynhnam.pma_filmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class adminControler {
	@RequestMapping("/admin/index")
    public String home(Model model, HttpServletRequest request) {
        
        return "/admin/index";
    }
//	@RequestMapping("/admin/actor")
//    public String customer(Model model, HttpServletRequest request) {
//        
//        return "/admin/actor";
//    }
//	@RequestMapping("/admin/movie")
//    public String product(Model model, HttpServletRequest request) {
//        
//        return "/admin/movie";
//    }
	@RequestMapping("/admin/director")
    public String category(Model model, HttpServletRequest request) {
        
        return "/admin/director";
    }
	@RequestMapping("/admin/category")
    public String order(Model model, HttpServletRequest request) {
        
        return "/admin/category";
    }


}
