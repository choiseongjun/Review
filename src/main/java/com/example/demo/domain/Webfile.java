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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WEBFILE")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Webfile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	
	
	
}
