package com.example.demo.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.WebList;
import com.example.demo.service.web.WebService;

@RestController
public class WebController {

	@Autowired
	WebService webService;
	
	//서비스 작성
	@PostMapping("/web/service")
	public ResponseEntity<?> insert(@RequestBody WebList webList){
		WebList insert = webService.insert(webList);
		return new ResponseEntity<>(insert, HttpStatus.OK);
	}
	
	//서비스 수정
	@PutMapping("/web/service/{id}")
	public ResponseEntity<?> update(@PathVariable("id")long id,@RequestBody WebList webList){
		webService.update(id, webList);
		return new ResponseEntity<>(webList, HttpStatus.OK);
	}
	
	//서비스 삭제
	@DeleteMapping("/web/service/{id}")
	public ResponseEntity<?>delete(@PathVariable("id")long id){
		webService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//서비스 리스트 조회
	@GetMapping("/web/service")
	public ResponseEntity<?> weblist(){
		
		List<WebList> weblist= webService.selectWebAll();
		
		 return new ResponseEntity<>(weblist, HttpStatus.OK);
	}
	
	//서비스 상세조회
	@GetMapping("/web/service/{id}")
	public ResponseEntity<?> selectOne(@PathVariable("id") long id){
		return new ResponseEntity<>(webService.selectOne(id), HttpStatus.OK);
	}
}
