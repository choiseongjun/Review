package com.example.demo.service.web;

import java.util.List;

import com.example.demo.domain.WebReply;
import com.example.demo.message.request.WebReplyReq;

public interface WebReplyService {
	WebReply saveReply(WebReplyReq webReplyReq, String user_id);
	List<WebReply> findAllReply(Long id);
	boolean editReply(WebReplyReq webReplyReq);
	boolean deleteReply(WebReplyReq webReplyReq);
}
