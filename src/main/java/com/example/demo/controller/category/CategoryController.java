package com.example.demo.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.category.CategoryService;


@RestController
@RequestMapping("/web")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public ResponseEntity<?> selectCategory() {
		try {
			return new ResponseEntity<>(categoryService.selectCategory(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Internal Server ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
