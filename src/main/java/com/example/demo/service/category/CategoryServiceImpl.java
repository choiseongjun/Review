package com.example.demo.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Category;
import com.example.demo.repository.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> selectCategory() {
		return categoryDao.selectCategory();
	}
	
}
