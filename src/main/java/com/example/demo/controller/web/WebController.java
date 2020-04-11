package com.example.demo.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.WebList;
import com.example.demo.service.web.WebService;

@RestController
public class WebController {

	@Autowired
	WebService webService;
	
//	@GetMapping("/weblist/{id}")
//	public String webList(@PathVariable("id") long id) {
//		
//		return "web/weblist";
//	}
	@GetMapping("/weblist")
	public ResponseEntity<?> weblist(){
		
		List<WebList> weblist= webService.selectWebAll();
		
		return new ResponseEntity<>(weblist, HttpStatus.OK);
	}
}
