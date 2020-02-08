package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Topic;
import com.example.demo.domain.Webfile;

public interface TopicService {

	void saveTopic(Topic topic, MultipartFile file, Webfile webfile);

	byte[] getTopicImage(String imageName) throws Exception;

	List<Topic> selectTopic();

}
