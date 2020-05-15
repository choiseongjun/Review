package com.example.demo.service.category;

import java.util.List;

import com.example.demo.domain.Category;
import com.example.demo.message.request.CategoryReq;
import com.example.demo.message.response.ApiResponseMessage;

public interface CategoryService {
	List<Category> selectCategory();
	Category createCategory(CategoryReq categoryReq);
	boolean editCategroy(Long id, CategoryReq categoryReq);
	boolean deleteCategory(Long id);
}
