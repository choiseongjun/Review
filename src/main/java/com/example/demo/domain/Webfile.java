package com.example.demo.domain;

import lombok.Data;


public class Webfile {

	private long id;
	private long topickey;
	private long webkey;
	private String file_name;
	private String real_name;
	private long file_size;
	private String file_path;
	private String ImageExtension;
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
