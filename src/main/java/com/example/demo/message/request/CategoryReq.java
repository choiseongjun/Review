package com.example.demo.message.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryReq {
	//카테고리 id
	private Long id;
	
	//카테고리 이름
	private String name;
	
	//카테고리 코드명
	private String mCode;
	
	//부모 카테고리 
	private Long parent;
}
