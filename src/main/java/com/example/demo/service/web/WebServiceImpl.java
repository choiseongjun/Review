package com.example.demo.service.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.FileManager;
import com.example.demo.domain.User;
import com.example.demo.domain.WebList;
import com.example.demo.domain.Webfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WebRepository;
import com.example.demo.repository.WebfileRepository;

@Service
@Transactional
public class WebServiceImpl implements WebService {

   @Autowired
   WebRepository webRepository;
   @Value("${webImagePath}")
   private String webImagePath;
   @Autowired
   private FileManager fileManager;
   @Autowired
   WebfileRepository webfileRepository;
   @Autowired
   UserRepository userRepository;
   //서비스 작성
   @Override
   public WebList insert(String user_id,WebList webList, MultipartFile file) {
	   Webfile webfile = new Webfile();
	   
	   Optional<User> user = userRepository.findByUserid(user_id);
	   
	   webList.setUser(user.get());
	   webRepository.save(webList);
	   if(file!=null) {
			UUID uid = UUID.randomUUID();
			
			//이미지파일확장자추출
	        String originalFileName = file.getOriginalFilename();
	        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();
	        String imageNAME = file.getName();
	        String savedName = uid.toString();//랜덤아이디
	        webfile.setImageExtension(fileExtension);
	        webfile.setReal_name(originalFileName);
	        webfile.setWeblist(webList);
	        webfile.setFile_size(file.getSize());
	        webfile.setFile_path(webImagePath);
	        webfile.setFile_name(savedName);
	      
		        //파일업로드
		        try { 
		            fileManager.fileUpload(file, webImagePath+"/"+savedName);
		            webfileRepository.save(webfile);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
	   
       
	   
	
      return webList;
   }
   
   //서비스 수정
   @Override
   public void update(long id, WebList webList) {
      WebList webListupdate = webRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("WebList", "id", id));
      webListupdate.setTitle(webList.getTitle());
      webListupdate.setContent(webList.getContent());
      webListupdate.setUrl(webList.getUrl());
      
      webRepository.save(webList);
   }
   
   //서비스 삭제
   @Override
   public void delete(long id) {
      webRepository.deleteById(id);
      
   }
   
   //서비스 리스트 조회
   @Override
   public List<WebList> selectWebAll() {
      return webRepository.findAll();
   }
   
   //서비스 상세 조회
   @Override
   public WebList selectOne(long id) {
      WebList webList = webRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("WebList", "id", id));
      return webList;
   }

	@Override
	public byte[] getWebImage(String imageName) throws Exception {
		return fileManager.getByteArray(webImagePath+"/"+imageName);
	}

}