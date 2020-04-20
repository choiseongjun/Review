package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.domain.common.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "webreply")
public class WebReply extends DateAudit{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
	
	 //댓글 내용
    @Column(name = "CONTENT")
    private String content;
    
    //부모키
    @Column(name = "PARENT")
    private String parent; 
    
    //깊이
    @Column(name = "depth")
    private String depth;
    
    //순서
    @Column(name = "REPLY_ORDER")
    private String replyorder;
    
    //삭제여부
    @Column(name = "DELETE_YN",columnDefinition = "CHAR(1) default 'N'")
    private char deleteyn;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WEBLIST_ID", referencedColumnName = "ID")
    private WebList weblist;
    
	//사용자번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
    
    public WebReply() {
	}
    
	public WebReply(long id, String content, String parent, String depth, String replyorder,
			char deleteyn, WebList weblist, User user) {
		super();
		this.id = id;
		this.content = content;
		this.parent = parent;
		this.depth = depth;
		this.replyorder = replyorder;
		this.deleteyn = deleteyn;
		this.weblist = weblist;
		this.user = user;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getReplyorder() {
		return replyorder;
	}
	public void setReplyorder(String replyorder) {
		this.replyorder = replyorder;
	}
	public char getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(char deleteyn) {
		this.deleteyn = deleteyn;
	}
	public WebList getWeblist() {
		return weblist;
	}
	public void setWeblist(WebList weblist) {
		this.weblist = weblist;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "WebReply [id=" + id + ", content=" + content + ", parent=" + parent + ", depth=" + depth
				+ ", replyorder=" + replyorder + ", deleteyn=" + deleteyn + ", weblist=" + weblist + ", user=" + user
				+ "]";
	}
    
    
}
