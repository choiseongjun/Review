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

@Entity
@Table(name = "webreply")
public class webreply extends DateAudit{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
	 //제목
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WEBLIST_ID", referencedColumnName = "ID")
    private WebList webList;
	//사용자번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
}
