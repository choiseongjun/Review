package com.example.demo.service.web;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.domain.WebList;

public interface WebService {

   //서비스 작성
   WebList insert(WebList webList, MultipartFile files);
   
   //서비스 수정
   void update(long id, WebList webList);
   
   //서비스 삭제
   void delete(long id);
   
   //서비스 상세 조회
   WebList selectOne(long id);
   
   //서비스 리스트 조회
   List<WebList> selectWebAll();

}