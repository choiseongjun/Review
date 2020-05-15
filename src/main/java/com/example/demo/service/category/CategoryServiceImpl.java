package com.example.demo.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Category;
import com.example.demo.message.request.CategoryReq;
import com.example.demo.message.response.ApiResponseMessage;
import com.example.demo.repository.CategoryDao;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> selectCategory() {
		return categoryDao.selectCategory();
	}

	@Override
	public Category createCategory(CategoryReq categoryReq) {
		Category category = new Category(categoryReq.getMCode(), categoryReq.getName(), categoryReq.getParent());
		return categoryRepository.save(category);
	}

	@Override
	public boolean editCategroy(Long id, CategoryReq categoryReq) {
		try {
			Optional<Category> category = categoryRepository.findById(id);
			
			category.ifPresent(selectCategory -> {
				selectCategory.setName(categoryReq.getName());
				selectCategory.setMCode(categoryReq.getMCode());
				selectCategory.setParent(categoryReq.getParent());
				categoryRepository.save(selectCategory);
			});
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Long id) {
		try {
			Optional<Category> category = categoryRepository.findById(id);
			
			category.ifPresent(selectCategory -> {
				categoryRepository.delete(selectCategory);
			});
			
			return true; 
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
