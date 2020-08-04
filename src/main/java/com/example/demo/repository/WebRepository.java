package com.example.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.WebList;

@Repository
public interface WebRepository extends JpaRepository<WebList, Long>, WebRepositoryCustom{

	Page<WebList> findAllByCategory(Pageable pageable, Long id);

	Page<WebList> findAllByCategoryId(Pageable pageable, Long id);

	Page<WebList> findAllByTitleLike(Pageable pageable, String searchParam);

	Page<WebList> findAllByCategoryIdAndTitleLike(Pageable pageable, Long id, String searchParam);

	Page<WebList> findAllByAppyn(Pageable pageable, char c);

	Page<WebList> findAllByCategoryIdAndAppyn(Pageable pageable, Long id, char c);

	Page<WebList> findAllByTitleLikeAndAppyn(Pageable pageable, String string, char c);

	Page<WebList> findAllByCategoryIdAndTitleLikeAndAppyn(Pageable pageable, Long id, String searchParam, char c);

}
