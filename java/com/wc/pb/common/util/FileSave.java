package com.wc.pb.common.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//파일 저장하기 
@Component //객체 자동으로 만들어 주기
public class FileSave {
	public String save(String realPath, MultipartFile file) {
		File f = new File(realPath);
		
		if(f.exists()) {
			f.mkdir();
			f.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString();
		fileName = fileName +"_"+file.getOriginalFilename();
		
		//1234-5984-1346-5897_123.jpg   --> UUID랜덤
		//123.jpg
		
		f = new File(f, fileName);
		try {
			FileCopyUtils.copy(file.getBytes(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 위에꺼 밑에꺼 둘중 하나 선택하기 둘다 적용됨
		// file.transferTo(f);

		return fileName;
	}
}
