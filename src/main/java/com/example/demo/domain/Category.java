package com.example.demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.domain.common.DateAudit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends DateAudit{
	//카테고리 id
	private Long id;
	
	//카테고리 이름
	private String name;
	
	//카테고리 parent
	private Long parent;
}
