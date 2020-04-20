package com.example.demo.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.WebList;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.WebRepository;

@Service
public class WebServiceImpl implements WebService {

   @Autowired
   WebRepository webRepository;

   //서비스 작성
   @Override
   public WebList insert(WebList webList) {
      webRepository.save(webList);
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
}