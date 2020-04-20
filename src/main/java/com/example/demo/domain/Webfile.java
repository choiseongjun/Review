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



@Entity
@Table(name = "WEBFILE")
public class Webfile {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
	private long id;
	@Column(name = "TOPICKEY")
	private long topickey;
	@Column(name = "WEBKEY")
	private long webkey;
	@Column(name = "FILE_NAME")
	private String file_name;
	@Column(name = "REAL_NAME")
	private String real_name;
	@Column(name = "FILE_SIZE")
	private long file_size;
	@Column(name = "FILE_PATH")
	private String file_path;
	@Column(name = "IMAGEEXTENSION")
	private String ImageExtension;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WEBLIST_ID", referencedColumnName = "ID")
    private WebList weblist;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTopickey() {
		return topickey;
	}
	public void setTopickey(long topickey) {
		this.topickey = topickey;
	}
	public long getWebkey() {
		return webkey;
	}
	public void setWebkey(long webkey) {
		this.webkey = webkey;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getImageExtension() {
		return ImageExtension;
	}
	public void setImageExtension(String imageExtension) {
		ImageExtension = imageExtension;
	}
	@Override
	public String toString() {
		return "Webfile [id=" + id + ", topickey=" + topickey + ", webkey=" + webkey + ", file_name=" + file_name
				+ ", real_name=" + real_name + ", file_size=" + file_size + ", file_path=" + file_path
				+ ", ImageExtension=" + ImageExtension + "]";
	}
	
}
