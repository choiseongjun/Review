package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.WebReply;

@Repository
public interface ReplyRepository extends JpaRepository<WebReply, Long> {
	List<WebReply> findAllByWeblist_id(Long id);

	Page<WebReply> findAllByWeblist_idAndDeleteyn(Long id, char c, Pageable pageable);

	List<WebReply> findAllByWeblistAndDeleteyn(Long id, char c);

	List<WebReply> findAllByWeblistIdAndDeleteyn(Long id, char c);

	List<WebReply> findAllByWeblistIdAndDeleteynOrderByIdDesc(Long id, char c);

	List<WebReply> findAllByWeblistIdAndDeleteynOrderByIdAsc(Long id, char c);
}
