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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "webreply")
@Getter
@Setter
@AllArgsConstructor
public class WebReply extends DateAudit{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
	
	 //댓글 내용
    @Column(name = "CONTENT")
    private String content;
    //별점
    @Column(name="STAR")
    private Double star;
    
    //부모키
    @Column(name = "PARENT")
    private long parent; 
    
    //깊이
    @Column(name = "depth")
    private long depth;
    
    //순서
    @Column(name = "REPLY_ORDER")
    private long replyorder;
    
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
    

	@Override
	public String toString() {
		return "WebReply [id=" + id + ", content=" + content + ", parent=" + parent + ", depth=" + depth
				+ ", replyorder=" + replyorder + ", deleteyn=" + deleteyn + ", weblist=" + weblist + ", user=" + user
				+ "]";
	}
    
    
}
