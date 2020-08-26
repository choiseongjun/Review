package com.example.demo.service.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.FileManager;
import com.example.demo.domain.Category;
import com.example.demo.domain.User;
import com.example.demo.domain.WebList;
import com.example.demo.domain.WebListDto;
import com.example.demo.domain.Webfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WebRepository;
import com.example.demo.repository.WebfileRepository;

@Service
@Transactional
public class WebServiceImpl extends QuerydslRepositorySupport implements WebService {

	@Autowired
	WebRepository webRepository;

	@Value("${webImagePath}")
	private String webImagePath;

	@Autowired
	private FileManager fileManager;

	@Autowired
	WebfileRepository webfileRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	public WebServiceImpl() {
		super(WebList.class);
	}

	// 서비스 작성
	@Override
	public WebList insert(String user_id, WebList webList, MultipartFile file,List<MultipartFile> files2) {
		
		
		Optional<User> user = userRepository.findByUserid(user_id);
		
		/*
		 * 파일이 있을경우
		 * */
		
		if (file != null) {
			UUID uid = UUID.randomUUID();
			Category category = new Category();
			category.setMCode(webList.getCategoryname());
			webList.setUser(user.get());
	        webList.setCategory(category);
			// 이미지파일확장자추출
			String originalFileName = file.getOriginalFilename();
			String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();
			String imageNAME = file.getName();
			String savedName = uid.toString();// 랜덤아이디
			webList.setImageExtension(fileExtension);
	        webList.setFile_name(savedName);
	        webList.setReal_name(originalFileName);
	        webList.setFile_path(webImagePath);
	        
			webRepository.save(webList);
			// 파일업로드
			try {
				fileManager.fileUpload(file, webImagePath + "/" + savedName);
				if(files2!=null) {
					for (MultipartFile filelists : files2) {
						
						UUID uid2 = UUID.randomUUID();//랜덤uid2
						Webfile webfile = new Webfile();
						String originalFileName2 = filelists.getOriginalFilename();
						String fileExtension2 = originalFileName2.substring(originalFileName2.lastIndexOf(".") + 1).toLowerCase();
						//String imageNAME2 = filelists.getName();
						String savedName2 = uid2.toString();// 랜덤아이디
					
						fileManager.fileUpload(filelists, webImagePath + "/" + savedName2);
						
						webfile.setImageExtension(fileExtension2);
						webfile.setFile_name(savedName2);
				        webfile.setReal_name(originalFileName2);
				        webfile.setFile_path(webImagePath);
				        webfile.setWeblist(webList);
				        
					    webfileRepository.save(webfile);
					    
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {//파일이 없을경우!
			Category category = categoryRepository.findBymCode(webList.getCategoryname());
			webList.setUser(user.get());
	        webList.setCategory(category);
			webRepository.save(webList);
		}

		return webList;
	}

	// 서비스 수정
	@Override
	public void update(long id, WebList webList) {
		WebList webListupdate = webRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("WebList", "id", id));
		webListupdate.setTitle(webList.getTitle());
		webListupdate.setContent(webList.getContent());
		webListupdate.setUrl(webList.getUrl());

		webRepository.save(webList);
	}

	// 서비스 삭제
	@Override
	public void delete(long id) {
		webRepository.deleteById(id);

	}

	// 서비스 리스트 조회
	@Override
   public Page<WebList> selectWebAll(Pageable pageable,String mCode,String searchParam,String appYn) {
	      
//	      final QWebList qWebList = webList;
//	      
//	      JPQLQuery query = from(webList);
//	    		  				
//	      List<WebList> webLists = getQuerydsl().applyPagination(pageable, query).fetch();
//	      
//	      long totalcount = query.fetchCount();
		Category category = categoryRepository.findBymCode(mCode);
		if(appYn.equals("Y")) {//승인된 조건
			if(searchParam==null) {//검색조건이 없는경우
				if(mCode.equals("All")) {
					return webRepository.findAllByAppyn(pageable,'Y');
				}else {
					return webRepository.findAllByCategoryIdAndAppyn(pageable,category.getId(),'Y');
				}
			}else {//검색조건이 있는경우
				if(mCode.equals("All")) {
					return webRepository.findAllByTitleLikeAndAppyn(pageable,"%"+searchParam+"%",'Y');
				}else {
					return webRepository.findAllByCategoryIdAndTitleLikeAndAppyn(pageable,category.getId(),searchParam,'Y');
				}	
			}
		}else {
			if(searchParam==null) {
				if(mCode.equals("All")) {
					return webRepository.findAllByAppyn(pageable,'Y');
				}else {
					return webRepository.findAllByCategoryIdAndAppyn(pageable,category.getId(),'Y');
				}	
			}else {
				if(mCode.equals("All")) {
					return webRepository.findAllByTitleLikeAndAppyn(pageable,"%"+searchParam+"%",'Y');
				}else {
					return webRepository.findAllByCategoryIdAndTitleLikeAndAppyn(pageable,category.getId(),searchParam,'Y');
				}	
			}
		}
	}
	
	// 서비스 상세 조회
	@Override
	public WebList selectOne(long id,HttpSession session) {
		WebList webList = webRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("WebList", "id", id));
		
		long update_time=0;
		if(session.getAttribute("update_time_"+id)!=null) {
			//최근에 조회수를 올린 시간
			update_time=(long)session.getAttribute("update_time_"+id);
		}
		long current_time=System.currentTimeMillis();
		//일정 시간이 경과한 후 조회수 증가 처리
		if(current_time - update_time > 24*60*60*1000) {
			//조회수 증가 처리 뒤에 밀리 세컨드 60*60*1000 한시간 *24 == 하루
			webList.setViews(webList.getViews()+1);
			webRepository.save(webList);
			//조회수를 올린 시간 저장
			session.setAttribute("update_time_"+id, current_time);
		}
		
		double avg=1;
		long cnt=0;
		double sum=0;
		for(int i=0;i<webList.getWebreply().size();i++) {
			sum+=webList.getWebreply().get(i).getStar();
			cnt++;
		}
		avg=sum/cnt;
		
		if(Double.isNaN(avg)) {//NaN체크
			avg=0;
		}
		webList.setAvgstar(avg);
		webList.setSizeOfstar(cnt);
		return webList;
	}

	@Override
	public byte[] getWebImage(String imageName) throws Exception {
		return fileManager.getByteArray(webImagePath + "/" + imageName);
	}

	@Override
	public Page<WebListDto> getWebLists(Pageable pageable) {
		Page<WebListDto> weblists = webRepository.searchPage(pageable);
		return weblists;
	}

	@Override
	public void webAppyn(long id) {

		Optional<WebList> webList = webRepository.findById(id);
		
		webList.ifPresent(selectList -> {
			selectList.setAppyn('Y');
			webRepository.save(selectList);
		});
		
//		.orElseThrow(() -> new ResourceNotFoundException("WebList", "id", id));
//		webListupdate.setTitle(webList.getTitle());
//		webListupdate.setContent(webList.getContent());
//		webListupdate.setUrl(webList.getUrl());
//
		
	}

	


}