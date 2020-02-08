package com.example.demo.repository;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Topic;

public interface TopicDao {

	void saveTopic(Topic topic, MultipartFile file);

}
