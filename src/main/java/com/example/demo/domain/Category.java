package com.example.demo.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category{
	//카테고리 id
	private Long id;
	
	//카테고리 코드명
	private String mCode;
	
	//카테고리 이름
	private String name;
	
	//카테고리 parent
	private Long parent;
	
	//List<Category>
	private List<Category> subCategory;
}
