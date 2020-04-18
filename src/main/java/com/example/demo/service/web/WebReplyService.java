package com.example.demo.service.web;

import com.example.demo.domain.WebReply;
import com.example.demo.message.request.WebReplyReq;

public interface WebReplyService {
	WebReply insertReply(WebReplyReq webReplyReq);
}
