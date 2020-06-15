package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.domain.common.DateAudit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(name = "WEBLIST")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class WebList extends DateAudit{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
	
	 //제목
    @Column(name = "TITLE")
    private String title;
    
    //내용
    @Column(name = "CONTENT")
    private String content;
    //링크
    @Column(name = "URL")
    private String url;
    //삭제여부
    @Column(name = "DELETE_YN",columnDefinition = "CHAR(1) default 'N'")
    private char deleteyn;
    //웹여부
    @Column(name = "WEB_YN",columnDefinition = "CHAR(1) default 'N'")
    private char web_yn;
    //어플여부
    @Column(name = "APP_YN",columnDefinition = "CHAR(1) default 'N'")
    private char app_yn;
    //승인여부
    @Column(name = "GRANT_YN",columnDefinition = "CHAR(1) default 'N'")
    private char grant_yn;
    @OneToMany(fetch = FetchType.LAZY,orphanRemoval=true,mappedBy = "weblist")
	private List<WebReply> webreply;
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval=true,mappedBy = "weblist")
	private List<Webfile> webfile;
    //사용자번호
    @ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
  
    @Column(name = "FILE_NAME")
	private String file_name;
    
	@Column(name = "REAL_NAME")
	private String real_name;
	
	@Column(name = "FILE_SIZE")
	private Long file_size;
	
	@Column(name = "FILE_PATH")
	private String file_path;
	
	@Column(name = "IMAGEEXTENSION")
	private String ImageExtension;
	 //카테고리
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "M_CODE")
    private Category category; 	
}
