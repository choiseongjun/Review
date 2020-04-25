package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.web.WebService;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = {
                "testTitle=test3",
                "testContent=test3"
        },
        classes = {ReviewApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Transactional
@AutoConfigureMockMvc
@Slf4j
public class ReviewApplicationTests {
	public org.jboss.logging.Logger logger = LoggerFactory.logger(this.getClass());
   
    @Value("${testTitle}")
    private String testTitle;

    @Value("${testContent}")
    private String testContent;
    
    @Autowired
    MockMvc mvc;
    
    @Autowired
    private WebService webService;
    
    @Autowired private TestRestTemplate restTemplate;

    @Test
    public void selectOne() throws Exception{
        logger.info("#### Properties 테스트 ####");
        logger.info("testTitle : " + testTitle);
        logger.info("testContent : " + testContent);
       
        logger.info("******** START : MOC MVC test **********");
        mvc.perform(get("/web/service/3"))
        .andExpect(status().isOk())
        .andDo(print());
        logger.info("******** END : MOC MVC test **********");
        
		/*
		 * logger.info("******** START : TestRestTemplate test **********");
		 * ResponseEntity<?> response = restTemplate.getForEntity("/web/service/3",
		 * WebService.class);
		 * assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		 * logger.info("pass"); assertThat(response.getBody()).isNotNull();
		 * logger.info("******** END : TestRestTemplate test **********");
		 */
        }
}