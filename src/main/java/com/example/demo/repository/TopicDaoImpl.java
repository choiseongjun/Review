package com.example.demo.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Topic;

@Repository
public class TopicDaoImpl implements TopicDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void saveTopic(Topic topic, MultipartFile file) {
		sqlSession.insert("topic.saveTopic",topic);
	}

}
