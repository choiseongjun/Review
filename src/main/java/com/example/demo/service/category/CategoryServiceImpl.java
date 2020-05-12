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
	public boolean editCategroy(CategoryReq categoryReq) {
		try {
			Optional<Category> category = categoryRepository.findById(categoryReq.getId());
			
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
	
	
}
