package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.FileManager;
import com.example.demo.domain.Topic;
import com.example.demo.domain.Webfile;
import com.example.demo.repository.TopicDao;


@Service
public class TopicServiceImpl implements TopicService{
	@Value("${topicImagePath}")
	private String topicImagePath;
	@Autowired
	TopicDao topicDao;
	@Autowired
	private FileManager fileManager;
	@Override
	public void saveTopic(Topic topic, MultipartFile file,Webfile webfile) {
		 //이미지파일확장자추출
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();
        String imageNAME = file.getName();
        webfile.setImageExtension(fileExtension);
        webfile.setReal_name(imageNAME);
        

        //파일업로드
        try { 
            fileManager.fileUpload(file, topicImagePath+"/"+imageNAME+"."+fileExtension);
        } catch (IOException e) {
            e.printStackTrace();
        }
		topicDao.saveTopic(topic,file);
	}

}
