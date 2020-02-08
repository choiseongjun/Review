package com.example.demo.controller.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Topic;
import com.example.demo.domain.Webfile;
import com.example.demo.service.TopicService;


@Controller
public class CategoryController {

	@Autowired
	TopicService topicService;
	
	@GetMapping("/categorylist")
	public String Categorylist(Model model) {
		
		List<Topic> topiclist= topicService.selectTopic();
		model.addAttribute("topiclist",topiclist);
		
		return "category/categorylist";
	}
	@GetMapping("/categoryMake")
	public String categoryMake() {
		
		return "category/categorymake";
	}
	@ResponseBody
	@GetMapping(value="/getTopicImage/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getTopicImage(@PathVariable("imageName") String imageName) throws Exception {
		return topicService.getTopicImage(imageName);
	}
	/**
	 * 카테고리 만들기
	 *
	 * @param moim
	 * @return
	 * @throws @author choiseongjun
	 */
	@ResponseBody
	@PostMapping("/topicMake")
	public Map<String, Object> categoryMake(@RequestPart("topic") Topic topic,
			@RequestPart(name = "file", required = false) MultipartFile file) {
		Map<String, Object> returnData = new HashMap<String, Object>();
		Webfile webfile =new Webfile();
		if (topic.getName().equals(null) || topic.getName().equals("")) {
			returnData.put("code", "0");
			returnData.put("message", "카테고리 이름을 입력해주세요");
			return returnData;
		} 
		
		try {
			topicService.saveTopic(topic,file,webfile);
			returnData.put("code", "1");
			returnData.put("message", "저장되었습니다");

		} catch (Exception e) {
			returnData.put("code", "E3290");
			returnData.put("message", "데이터 확인 후 다시 시도해주세요.");
		}
		return returnData;
	}
}
