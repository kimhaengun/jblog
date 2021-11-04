package com.douzone.jblog.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;

@Service
public class BlogService {
	private static String SAVE_PATH = "/upload-jblog";
	private static String URL_BASE = "/blog/images";
	
	@Autowired
	private BlogRepository blogRepository;
	
	//회원가입 시 생성되는 초기 블로그
	public void insert(String userId) {
		// TODO Auto-generated method stub
		BlogVo blogVo = new BlogVo();
		blogVo.setId(userId);
		blogVo.setTitle("제목");
		blogVo.setLogo("사진 없음");
		blogRepository.intialinsert(blogVo);
	}	
	//기본설정 Update
	public void blogAdminBasicUpdate(BlogVo blogVo,MultipartFile file) {
		try {
			File uploadDirectory = new File(SAVE_PATH);
			if(!uploadDirectory.exists()) {
				uploadDirectory.mkdir();
			}

			if(file.isEmpty()) {
				throw new RuntimeException("file upload error: image empty");
			}

			String originFilename = file.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf('.')+1);
			String saveFilename = generateSaveFilename(extName);

			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();

//			BlogVo vo = new BlogVo();
//			vo.setLogo(URL_BASE + "/" + saveFilename);
//			System.out.println("=====설마 초기화됨?"+vo); //응 초기화됨
			blogVo.setLogo(URL_BASE + "/" + saveFilename);
			blogRepository.blogAdminBasicUpdate(blogVo);
		} catch(IOException ex) {
			throw new RuntimeException("file upload error:" + ex);
		}
	}
	private String generateSaveFilename(String extName) {
		String filename = "";

		Calendar calendar = Calendar.getInstance();

		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);

		return filename;
	}
	//
	public BlogVo findByBlog(String blogId) {
		// TODO Auto-generated method stub
		return blogRepository.findByBlog(blogId);
	}


}
