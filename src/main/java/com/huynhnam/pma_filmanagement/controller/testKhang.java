package com.huynhnam.pma_filmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class testKhang {
	@RequestMapping("/home/doimatkhau")
	public String doimatkhau() {
		return "/user/changePassword";
	}
	@RequestMapping("/home/quenmatkhau")
	public String quenmatkhau() {
		return "/user/forgetPassword";
	}
}
