package com.springboot.apibook.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.apibook.Helper.FileUploadHelper;

@RestController
public class fileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
		
		try {
		//Validation
		if(file.isEmpty()){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain the file");
		}
		if(!file.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("It must contain the png file");
		}
		//File upload code...
		boolean f = fileUploadHelper.uploadFile(file);
		if(f) {
			return ResponseEntity.ok("File is successfully uploaded");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!try again later");
	}
}



