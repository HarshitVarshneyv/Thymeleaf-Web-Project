package com.springboot.apibook.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component   //WE have to autowire this class that is why we have to component,so that spring
             //container can able to handle the life cycle of this class.
public class FileUploadHelper {

//	public final String UPLOAD_DIR="C:\\Users\\Harshit Gupta\\Documents\\spring"
//			+ "\\BOOTRESTBOOK\\src\\main\\resources\\static\\image";
//	
	public final String UPLOAD_DIR=new ClassPathResource("static/image").getFile().getAbsolutePath();
			
	public FileUploadHelper()throws IOException{
		
	}
	public boolean uploadFile(MultipartFile multipartFile) 
	{
		boolean f=false;
		
		try {
			//Files.copy(inputStream,target,options)
			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);	
		f=true;
		}
		catch(Exception e){	
			e.printStackTrace();
		}
		
		return f;
		
	}
}
