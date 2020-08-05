package com.example.demo.service.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	UserRepository userRepository;
	
	
	@Override
	public WebReply saveReply(WebReplyReq webReplyReq,String user_id) {
		Optional<User> user = userRepository.findByUserid(user_id);
//		User user = userRepository.getOne(webReplyReq.getUser_id());
		
		WebList webList = new WebList();
		webList.setId(webReplyReq.getWeblist_id());
		WebReply webReply = new WebReply();
		webReply.setUser(user.get());
		webReply.setWeblist(webList);
		webReply.setStar(webReplyReq.getStar());
		webReply.setContent(webReplyReq.getContent());
//		webReply.setParent(webReplyReq.getParent());
		webReply.setDeleteyn('N');
		
		WebReply reply = replyRepository.save(webReply);
		
		return reply;
	}

	@Override
	public List<WebReply> findAllReply(Long id) {
		List<WebReply> replys = replyRepository.findAllByWeblistIdAndDeleteynOrderByIdDesc(id,'N');
		return replys;
	}

	@Override
	public boolean editReply(WebReplyReq webReplyReq,String user_id) {
		try {
			Optional<WebReply> reply = replyRepository.findById(webReplyReq.getId());
			
			reply.ifPresent(selectReply -> {
				selectReply.setContent(webReplyReq.getContent());
				selectReply.setStar(webReplyReq.getStar());
				replyRepository.save(selectReply);
			});
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteReply(Long id) {
		try {
			Optional<WebReply> reply = replyRepository.findById(id);
			
			reply.ifPresent(selectReply -> {
				selectReply.setDeleteyn('Y');
				replyRepository.save(selectReply);
			});
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
