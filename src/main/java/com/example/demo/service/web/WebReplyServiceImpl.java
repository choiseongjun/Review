package com.example.demo.service.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.domain.WebList;
import com.example.demo.domain.WebReply;
import com.example.demo.message.request.WebReplyReq;
import com.example.demo.repository.ReplyRepository;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class WebReplyServiceImpl implements WebReplyService{

	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public WebReply saveReply(WebReplyReq webReplyReq,String user_id) {
		Optional<User> user = userRepository.findByUserid(user_id);
//		User user = userRepository.getOne(webReplyReq.getUser_id());
		
		long seqId = replyRepository.selectMaxId();//최대값 가져오기
		
		
		WebList webList = new WebList();
		webList.setId(webReplyReq.getWeblist_id());
		WebReply webReply = new WebReply();
		webReply.setId(seqId);
		webReply.setUser(user.get());
		webReply.setWeblist(webList);
		webReply.setStar(webReplyReq.getStar());
		webReply.setContent(webReplyReq.getContent());
//		webReply.setParent(webReplyReq.getParent());
		webReply.setDeleteyn('N');
		webReply.setDepth(0); 
		webReply.setReplyorder(0);
		webReply.setParent(seqId);
		WebReply reply = replyRepository.save(webReply);
		 
		return reply;
	}

	@Override 
	public List<WebReply> findAllReply(Long id) {
		List<WebReply> replys = replyRepository.findAllByWeblistIdAndDeleteynOrderByParentDescReplyorderAsc(id,'N');
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

	

	@Override
	public void saveTreeReply(Long id, WebReplyReq webReplyReq, String user_id) {
		Optional<WebReply> reply = replyRepository.findById(id);
		Optional<User> user = userRepository.findByUserid(user_id);
		reply.ifPresent(selectReply -> {//부모댓글 패런트를 키랑 맞추기
			selectReply.setParent(id);
			replyRepository.save(selectReply);
		});
		WebList webList = new WebList();
		webList.setId(webReplyReq.getWeblist_id());

		WebReply webReply =new WebReply();
		webReply.setUser(user.get());
		webReply.setWeblist(webList);
		webReply.setStar(webReplyReq.getStar());
		webReply.setContent(webReplyReq.getContent());
//		webReply.setParent(webReplyReq.getParent());
		webReply.setParent(id);
		webReply.setDeleteyn('N');
		webReply.setReplyorder(reply.get().getReplyorder()+1);
		replyRepository.save(webReply);
	}
	
	
}
