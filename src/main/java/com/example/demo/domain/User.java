package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
public class User {

	private long id;
	private String userid;
	private String passwd;
	private String email;
	private String nikcname;
	private Date createDate;
}
