package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.web.WebController;
import com.example.demo.service.web.WebService;
import com.google.common.net.MediaType;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
@Slf4j

public class WebControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private WebService webService;
	
	@Test
	public void helloModelTest() throws Exception {
	 mockMvc.perform(MockMvcRequestBuilders.get("/web/service"))
	         .andExpect(MockMvcResultMatchers.status().isOk())
	         .andExpect(MockMvcResultMatchers.model().attribute("id", "3"))
	         .andDo(MockMvcResultHandlers.print());
	}
}
