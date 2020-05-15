package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="category")
public class Category{
	//카테고리 id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//카테고리 코드명
	@NonNull
	@Column(name = "M_CODE")
	private String mCode;
	
	//카테고리 이름
	@NonNull
	private String name;
	
	//카테고리 parent
	@NonNull
	private Long parent;
	
	//List<Category>
	@Transient
	private List<Category> subCategory;
}
