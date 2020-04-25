package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.web.WebController;
import com.example.demo.domain.WebList;
import com.example.demo.service.web.WebService;

@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
public class WebControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private WebService webService;

	@Test
	public void SelectallTest() throws Exception {
		WebList webList = new WebList();
		webList.setId(20);
		webList.setTitle("test20");
		webList.setContent("test20");

		given(webService.selectOne(20)).willReturn(webList);

		mockMvc.perform(get("/web/service/20")).andExpect(status().isOk()).andExpect(model().attributeExists("webList"));
	}
}