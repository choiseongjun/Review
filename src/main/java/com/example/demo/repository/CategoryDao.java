package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.Category;

public interface CategoryDao {
	List<Category> selectCategory();
}
