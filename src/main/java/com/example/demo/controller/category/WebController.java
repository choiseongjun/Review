package com.example.demo.controller.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@GetMapping("/weblist/{id}")
	public String webList(@PathVariable("id") long id) {
		
		
		
		return "web/weblist";
	}
}
