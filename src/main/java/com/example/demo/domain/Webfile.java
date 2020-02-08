package com.example.demo.domain;

import lombok.Data;

@Data
public class Webfile {

	private long id;
	private long topickey;
	private long webkey;
	private String file_name;
	private String real_name;
	private long file_size;
	private String file_path;
	private String ImageExtension;
}
