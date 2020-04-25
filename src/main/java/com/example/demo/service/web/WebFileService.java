package com.example.demo.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Webfile;
import com.example.demo.repository.WebfileRepository;

@Service
public class WebFileService {
	@Autowired
	WebfileRepository webfileRepository;
	
	public void save(Webfile webfile) {
		Webfile f = new Webfile();
		f.setFile_name(webfile.getFile_name());
		f.setReal_name(webfile.getReal_name());
		f.setFile_path(webfile.getFile_path());
		f.setFile_size(webfile.getFile_size());
		f.setImageExtension(webfile.getImageExtension());
		f.setTopickey(webfile.getTopickey());
		f.setWebkey(webfile.getWebkey());
		
		webfileRepository.save(f);
	}

}
