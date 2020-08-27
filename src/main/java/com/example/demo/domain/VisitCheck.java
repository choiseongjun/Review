package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.domain.common.DateAudit;

import lombok.Data;

@Entity
@Table(name = "VISITOR_CHECK")
@Data
public class VisitCheck extends DateAudit{

	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="VISIT_IP")
	private String visit_ip;
	@Column(name="VISIT_AGENT")
	private String visit_agent;
	@Column(name="VISIT_REFER")
	private String visit_refer;
	
	
	
}
