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
	
	//댓글 내용
	private String content;
	
	//댓글 부모
	private String parent;
	
	//리댓글 순서
	private String depth;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getWeblist_id() {
		return weblist_id;
	}

	public void setWeblist_id(Long weblist_id) {
		this.weblist_id = weblist_id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}
	
}
