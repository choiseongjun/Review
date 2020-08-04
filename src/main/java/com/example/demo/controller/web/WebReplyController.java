package com.example.demo.controller.web;

import java.security.Principal;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.WebReply;
import com.example.demo.message.request.WebReplyReq;
import com.example.demo.service.web.WebReplyService;

@RestController
@RequestMapping("/web")
public class WebReplyController {
	
	@Autowired
	private WebReplyService webReplyService;
	
	/*
	 * 댓글 생성
	 * @param : WebReplyReq
	 * @return : Reply
	 * */	
	@PostMapping("/reply")
	public ResponseEntity<?> saveReply(@RequestBody WebReplyReq webReplyReq,Principal principal) {
		try {
			String user_id = principal.getName();
			WebReply reply = webReplyService.saveReply(webReplyReq,user_id);
			
			return new ResponseEntity<>(reply, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * 전체 댓글 조회
	 * @return : List<Reply>
	 * */	
	@SuppressWarnings("unchecked")
	@GetMapping("/reply/{id}")
	public ResponseEntity<?> findAllReply(@PathVariable Long id) {
		//id==weblist_id
		try {
			JSONObject returnData = new JSONObject();
			
//			int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
//	    	pageable = PageRequest.of(page, 10, Sort.by("id").descending());
	    	List<WebReply> webreply = webReplyService.findAllReply(id);
	    	
	    	returnData.put("webreply", webreply);
			return new ResponseEntity<>(returnData, HttpStatus.OK);
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("잘못된 요청입니다." , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * 댓글 수정
	 * @param : WebReplyReq
	 * @return : WebReply
	 * */	
	@PutMapping(path = "/reply")
	public ResponseEntity<?> editReply(@RequestBody WebReplyReq webReplyReq,Principal principal) {
		try {
			String user_id = principal.getName();
			return new ResponseEntity<>(webReplyService.editReply(webReplyReq,user_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * 댓글 삭제
	 * @param : WebReplyReq
	 * @return : WebReply
	 * */	
	@DeleteMapping("/reply/{id}")
	public ResponseEntity<?> deleteReply(@PathVariable Long id,Principal principal) {
		
		try {
			return new ResponseEntity<>(webReplyService.deleteReply(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
