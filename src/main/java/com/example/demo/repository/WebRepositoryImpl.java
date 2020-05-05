package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.QWebList;
import com.example.demo.domain.QWebListDto;
import com.example.demo.domain.WebListDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.example.demo.domain.QWebList.*;

public class WebRepositoryImpl implements WebRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	public WebRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	// 카테고리 조건추가 후 구현
	@Override
	public List<WebListDto> search(String mCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<WebListDto> searchPage(Pageable pageable) {
		QueryResults<WebListDto> results = queryFactory
				.select(Projections.constructor(WebListDto.class,
						webList.id,
						webList.title
						))
				.from(webList)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetchResults();
		
		return new PageImpl<>(results.getResults(), pageable, results.getTotal());
	}

}
