package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.WebList;

@Repository
public interface WebRepository extends JpaRepository<WebList, Long>{

}
