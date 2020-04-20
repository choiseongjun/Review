package com.example.demo.repository;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Topic;
import com.example.demo.domain.Webfile;

public interface TopicDao {

	void saveTopic(Topic topic, MultipartFile file,Webfile webfile);

	List<Topic> selectTopic();
	
	Topic viewTopic(long id);
}
