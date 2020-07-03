package com.example.demo.message.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WebReplyReq {
	//작성자 id
	private Long user_id;
	
	//댓글 작성 webList id
	private Long weblist_id;
	
	//댓글 id
	private Long id;
	
	//댓글 별점
	private double star;
	
	//댓글 내용
	private String content;
	
	//댓글 부모
	private String parent;
	
	//리댓글 순서
	private String depth;	
}