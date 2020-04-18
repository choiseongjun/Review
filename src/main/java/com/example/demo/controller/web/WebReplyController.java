package com.example.demo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	 * param : WebReplyReq
	 * return : Reply
	 * */	
	@PostMapping("/reply")
	public ResponseEntity<?> createReply(@RequestBody WebReplyReq webReplyReq) {
		try {
			System.out.println(webReplyReq.getUser_id());
			WebReply reply = webReplyService.insertReply(webReplyReq);
			
			return new ResponseEntity<>(reply, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * 전체 댓글 조회
	 * param : WebReplyReq
	 * return : Reply
	 * */	
	@GetMapping("/reply")
	public ResponseEntity<?> findAllReply() {
		try {
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>("잘못된 요청입니다." , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
