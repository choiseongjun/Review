package com.example.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
//	@GetMapping("/loginView")
//	public String loginView() {
//		
//		return "user/login";
//	}
//	@GetMapping("/resisterView")
//	public String RegisterView() {
//		
//		return "user/register";
//	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(User user){
		
		userService.register(user);
		
		return null;
	}
	
	
}
