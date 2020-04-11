package com.example.demo.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.WebList;
import com.example.demo.repository.WebRepository;

@Service
public class WebServiceImpl implements WebService {

	@Autowired
	WebRepository webRepository;
	
	@Override
	public List<WebList> selectWebAll() {
		return webRepository.findAll();
	}

}
