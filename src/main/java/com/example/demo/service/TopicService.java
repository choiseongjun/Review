package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Topic;
import com.example.demo.domain.Webfile;

public interface TopicService {

	void saveTopic(Topic topic, MultipartFile file, Webfile webfile);

}
