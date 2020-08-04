package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.web.WebController;
import com.example.demo.domain.Category;
import com.example.demo.domain.User;
import com.example.demo.domain.WebList;
import com.example.demo.repository.WebRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebControllerTest {

//	@Autowired
//	MockMvc mockMvc;
//
//	@MockBean
//	private WebService webService;
	@Autowired
	WebRepository webRepository;
	
	@Test
	public void createWebTest() {
		
		User user=new User();
		
		Category category = new Category();
		category.setId(2L);
		user.setId(1L);
		WebList weblist=new WebList();
		for(long i=67;i<150;i++) {
			
			weblist.setId(i);	
			weblist.setContent("test");
			weblist.setAppyn('Y');
			weblist.setDeleteyn('N');
			weblist.setTitle("테스트타이틀");
			webRepository.save(weblist);
		}
		
		
	}
//	@Test
//	public void SelectallTest() throws Exception {
//		WebList webList = new WebList();
//		webList.setId(20);
//		webList.setTitle("test20");
//		webList.setContent("test20");
//
//		given(webService.selectOne(20)).willReturn(webList);
//
//		mockMvc.perform(get("/web/service/20")).andExpect(status().isOk()).andExpect(model().attributeExists("webList"));
//	}
}