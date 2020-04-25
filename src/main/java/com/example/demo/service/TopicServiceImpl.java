package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.FileManager;
import com.example.demo.domain.Topic;
import com.example.demo.domain.Webfile;
import com.example.demo.repository.TopicDao;

@Service
public class TopicServiceImpl implements TopicService{
	@Value("${webImagePath}")
	private String topicImagePath;
	@Autowired
	TopicDao topicDao;
	@Autowired
	private FileManager fileManager;
	@Override
	@Transactional
	public void saveTopic(Topic topic, MultipartFile file,Webfile webfile) {
		
		if(file!=null) {
		UUID uid = UUID.randomUUID();
		
		//이미지파일확장자추출
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();
        String imageNAME = file.getName();
        String savedName = uid.toString() + "_" + originalFileName;//랜덤아이디
        webfile.setImageExtension(fileExtension);
        webfile.setReal_name(originalFileName);
        webfile.setTopickey(topic.getId());
        webfile.setFile_size(file.getSize());
        webfile.setFile_path(topicImagePath);
        webfile.setFile_name(savedName);
	        //파일업로드
	        try { 
	            fileManager.fileUpload(file, topicImagePath+"/"+savedName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		topicDao.saveTopic(topic,file,webfile);
	}
	@Override
	public byte[] getTopicImage(String imageName) throws Exception {
		 return fileManager.getByteArray(topicImagePath+"/"+imageName);
	}
	@Override
	public List<Topic> selectTopic() {
		return topicDao.selectTopic();
	}
	
	@Override
	public Topic viewTopic(long id) {
		return topicDao.viewTopic(id);
	}

}
