package com.example.demo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> saveReply(@RequestBody WebReplyReq webReplyReq) {
		try {
			System.out.println(webReplyReq.getUser_id());
			WebReply reply = webReplyService.saveReply(webReplyReq);
			
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
	@GetMapping("/reply/{weblist_id}")
	public ResponseEntity<?> findAllReply(@PathVariable Long weblist_id) {
		try {
			return new ResponseEntity<>(webReplyService.findAllReply(weblist_id), HttpStatus.OK);
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
	@PutMapping("/reply")
	public ResponseEntity<?> editReply(@RequestBody WebReplyReq webReplyReq) {
		try {
			return new ResponseEntity<>(webReplyService.editReply(webReplyReq), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("잘못된 요청입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
