package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.WebListDto;

public interface WebRepositoryCustom {
	List<WebListDto> search(String mCode);
	
	Page<WebListDto> searchPage(Pageable pageable);

}
