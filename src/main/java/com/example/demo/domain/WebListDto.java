package com.example.demo.domain;

import java.util.List;

import lombok.Data;

import com.querydsl.core.annotations.QueryProjection;

@Data
public class WebListDto {
	
    private long id;
    private String title;
    private String fileName;
	
	@QueryProjection
	public WebListDto(Long id, String title, String fileName) {
		this.id= id;
		this.title = title;
		this.fileName = fileName;
	}
}
