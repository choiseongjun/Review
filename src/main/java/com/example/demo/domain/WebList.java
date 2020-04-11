package com.example.demo.domain;

import java.util.List;

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

@Entity
@Table(name = "WEBLIST")
public class WebList extends DateAudit{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    //승인여부
    @Column(name = "APP_YN",columnDefinition = "CHAR(1) default 'N'")
    private char appyn;
    @OneToMany(fetch = FetchType.LAZY,orphanRemoval=true,mappedBy = "weblist")
	private List<webreply> webreply;
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval=true,mappedBy = "weblist")
	private List<Webfile> webfile;
    //사용자번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public char getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(char deleteyn) {
		this.deleteyn = deleteyn;
	}
	public char getAppyn() {
		return appyn;
	}
	public void setAppyn(char appyn) {
		this.appyn = appyn;
	}
	public List<webreply> getWebreply() {
		return webreply;
	}
	public void setWebreply(List<webreply> webreply) {
		this.webreply = webreply;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "WebList [id=" + id + ", title=" + title + ", content=" + content + ", url=" + url + ", deleteyn="
				+ deleteyn + ", appyn=" + appyn + ", webreply=" + webreply + ", user=" + user + "]";
	}
    
}
