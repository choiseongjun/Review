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
import javax.persistence.Transient;

import com.example.demo.domain.common.DateAudit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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
    private char webyn;
    //승인여부
    @Column(name = "APP_YN",columnDefinition = "CHAR(1) default 'N'")
    private char appyn;
    //모바일여부
    @Column(name = "MOBILE_YN",columnDefinition = "CHAR(1) default 'N'")
    private char mobileyn;
    @JsonBackReference//웹리플라이는 안불러옴
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
    
    @Transient
    private Double avgstar;
    @Transient
    private long sizeOfstar;
    @Transient
    private String categoryname;
    @Transient
    private String mcode;//카테고리임시코드
}
