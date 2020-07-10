package com.example.demo;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;
import com.example.demo.domain.WebList;
import com.example.demo.domain.WebReply;
import com.example.demo.repository.ReplyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyRepositoryTest {
	private static final Long id = 10L;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Test
	public void createReplyTest() {
		
		User user=new User();
		user.setId(1L);
		
		WebList weblist=new WebList();
		weblist.setId(4L);
		
		WebReply wreply = new WebReply();
		
		for(long i=115;i<215;i++) {
			wreply.setId(i);
			wreply.setContent("댓글 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트.");
			wreply.setStar(4d);
			wreply.setUser(user);
			wreply.setWeblist(weblist);
			replyRepository.save(wreply);
		}
		
		
	}
	
	
//	@Test
//	@Ignore
//	public void readReplyTest() {
//		Optional<WebReply> reply = replyRepository.findById(id);
//		
//		reply.ifPresent(selectReply -> {
//			System.out.println(selectReply);
//		});
//	}
//	
//	@Test
//	@Ignore
//	public void updateReplyTest() {
//		Optional<WebReply> reply = replyRepository.findById(id);
//		
//		reply.ifPresent(selectReply -> {
//			selectReply.setContent("댓글 update Test 입니다.");
//			replyRepository.save(selectReply);
//		});
//	}
//	
//	@Test
////	@Ignore 
//	public void deleteReplyTest() {
//		Optional<WebReply> reply = replyRepository.findById(id);
//		
//		reply.ifPresent(selectReply -> {
//			replyRepository.delete(selectReply);
//		});
//	}

}
