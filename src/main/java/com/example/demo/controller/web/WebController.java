package com.example.demo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.web.WebService;

@Controller
public class WebController {

	@Autowired
	WebService webService;
	
	@GetMapping("/weblist/{id}")
	public String webList(@PathVariable("id") long id) {
		
		return "web/weblist";
	}
}
