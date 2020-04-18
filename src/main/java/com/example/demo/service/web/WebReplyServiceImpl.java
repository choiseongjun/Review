package com.example.demo.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.domain.WebList;
import com.example.demo.domain.WebReply;
import com.example.demo.message.request.WebReplyReq;
import com.example.demo.repository.ReplyRepository;
import com.example.demo.repository.UserRepository;

@Service
public class WebReplyServiceImpl implements WebReplyService{

	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public WebReply insertReply(WebReplyReq webReplyReq) {
		User user = new User();
		user.setId(webReplyReq.getUser_id());
//		User user = userRepository.getOne(webReplyReq.getUser_id());
		
		WebList webList = new WebList();
		webList.setId(webReplyReq.getWeblist_id());
		
		WebReply webReply = new WebReply();
		webReply.setUser(user);
		webReply.setWeblist(webList);
		webReply.setContent(webReplyReq.getContent());
		webReply.setParent(webReplyReq.getParent());
		webReply.setDeleteyn('N');
		
		WebReply reply = replyRepository.save(webReply);
		
		return reply;
	}

}
