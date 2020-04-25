package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Webfile;

public interface WebfileRepository extends JpaRepository<Webfile, Long>{

}
