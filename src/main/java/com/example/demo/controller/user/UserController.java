package com.example.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/loginView")
	public String loginView() {
		
		return "user/login";
	}
	@GetMapping("/resisterView")
	public String RegisterView() {
		
		return "user/register";
	}
}
