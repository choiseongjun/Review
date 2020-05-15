package com.example.demo.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.message.request.CategoryReq;
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
	
	@PostMapping("/category")
	public ResponseEntity<?> createCategory(@RequestBody CategoryReq categoryReq) {
		try {
			return new ResponseEntity<>(categoryService.createCategory(categoryReq), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Internal Server ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<?> editCategory(@RequestBody CategoryReq categoryReq, @PathVariable Long id) {
		try {
			return new ResponseEntity<>(categoryService.editCategroy(id, categoryReq), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("category/{id}")
	public ResponseEntity<?> deleteCategroy(@PathVariable Long id){
		try {
			return new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
