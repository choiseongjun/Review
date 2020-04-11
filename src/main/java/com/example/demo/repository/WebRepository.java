package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.WebList;

public interface WebRepository extends JpaRepository<WebList, Long>{

}
