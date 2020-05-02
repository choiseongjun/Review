package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Category> selectCategory() {
		return sqlSession.selectList("category.selectCategory");
	}

	
}
