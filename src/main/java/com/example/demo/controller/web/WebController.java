package com.example.demo.controller.web;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.WebList;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.web.WebFileService;
import com.example.demo.service.web.WebService;

@RestController
public class WebController {

	@Autowired
	WebService webService;

	@Autowired
	WebFileService webFileservice;

	@Autowired
	CategoryService categoryService;

	// 서비스 작성
	@PostMapping(path = "/web/service")
	public Map<String, Object> insert(@RequestPart(name = "webList", required = false) WebList webList,
			@RequestPart(name = "file", required = false) MultipartFile files,
			@RequestPart(name = "file2", required = false) List<MultipartFile> files2, Principal principal)
			throws Exception {
		String user_id = principal.getName();

		Map<String, Object> returnData = new HashMap<String, Object>();
		try {
			webService.insert(user_id, webList, files, files2);
			returnData.put("code", "1");
			returnData.put("message", "저장되었습니다");

		} catch (Exception e) {
			returnData.put("code", "E3290");
			returnData.put("message", "데이터 확인 후 다시 시도해주세요.");
		}

		return returnData;
	}

	@GetMapping(value = "/getWebImage/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getMoimImage(@PathVariable("imageName") String imageName) throws Exception {
		return webService.getWebImage(imageName);
	}

	// 서비스 수정
	@PutMapping("/web/service/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody WebList webList) {
		webService.update(id, webList);
		return new ResponseEntity<>(webList, HttpStatus.OK);
	}

	// 서비스 삭제
	@DeleteMapping("/web/service/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		webService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// 서비스 리스트 조회
	@SuppressWarnings("unchecked")
	@GetMapping("/web/serviceList/{mCode}")
	public JSONObject getService(Pageable pageable, Sort sort,
			@RequestParam(value = "appYn", required = false) String appYn,
			@RequestParam(value = "searchParam", required = false) String searchParam,
			@PathVariable("mCode") String mCode) {
		
		JSONObject returnData = new JSONObject();
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
		pageable = PageRequest.of(page, 16, Sort.by("id").descending());

		Page<WebList> weblists = webService.selectWebAll(pageable, mCode, searchParam, appYn);
		
		returnData.put("weblists", weblists);
		returnData.put("mCode", mCode);
		returnData.put("appYn", appYn);
		return returnData;
	}

	// 서비스 리스트 조회
//	@GetMapping("/web/webList")
//	public Page<WebListDto> getWeblist(@PageableDefault(size=16) Pageable pageable) {
//		return webService.getWebLists(pageable);
//	}

	// 서비스 상세조회
	@GetMapping("/web/service/{id}")
	public ResponseEntity<?> selectOne(@PathVariable("id") long id
			,HttpServletRequest request,HttpServletResponse response
			,HttpSession session) {
		
		WebList weblist = webService.selectOne(id,session);
		return new ResponseEntity<>(weblist, HttpStatus.OK);
	}
	
	// 주제(카테고리 조회)
	@GetMapping("/web/{category_id}")
	public ResponseEntity<?> selectTopic(@PathVariable("category_id") long id) {
//			 return new ResponseEntity<>(topicService.viewTopic(id),HttpStatus.OK);
		return new ResponseEntity<>(categoryService.selectCategory(), HttpStatus.OK);

	}

	@DeleteMapping("/web/appyn/{id}")
	public ResponseEntity<?> webAppyn(@PathVariable("id") long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> map=new HashMap<String, String>();
		String ROLE_ADMIN="[ROLE_ADMIN]";
		if(authentication.getAuthorities().toString().equals("[ROLE_ADMIN]")) {
			webService.webAppyn(id);
			map.put("success", "success");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail", HttpStatus.FORBIDDEN);
		}
	}
}
