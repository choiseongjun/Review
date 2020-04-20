package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Topic;
import com.example.demo.domain.Webfile;

@Repository
public class TopicDaoImpl implements TopicDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void saveTopic(Topic topic, MultipartFile file,Webfile webfile) {
		sqlSession.insert("topic.saveTopic",topic);
		sqlSession.insert("webfile.webfileinsert",webfile);
	}

	@Override
	public List<Topic> selectTopic() {
		return sqlSession.selectList("topic.selectTopic");
	}
	
	@Override
	public Topic viewTopic(long id) {
		return sqlSession.selectOne("topic.viewTopic",id);
	}

}
