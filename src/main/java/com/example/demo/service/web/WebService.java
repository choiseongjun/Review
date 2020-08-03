package com.example.demo.service.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.domain.WebList;
import com.example.demo.domain.WebListDto;

public interface WebService {

   //서비스 작성
   WebList insert(String user_id, WebList webList, MultipartFile files, List<MultipartFile> files2);
   
   //서비스 수정
   void update(long id, WebList webList);
   
   //서비스 삭제
   void delete(long id);
   
   //서비스 상세 조회
   WebList selectOne(long id);
   
   //서비스 리스트 조회
   Page<WebList> selectWebAll(Pageable pageable, String mCode, String searchParam);

   byte[] getWebImage(String imageName) throws Exception;
   
   Page<WebListDto> getWebLists(Pageable pageable);

}