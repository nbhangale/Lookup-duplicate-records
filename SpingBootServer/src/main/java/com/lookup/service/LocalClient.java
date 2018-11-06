package com.lookup.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Local Client store service class
 * Functions: class to store the csv file to local path
 */

@Service
public class LocalClient {
	
	// variable to store file to local path
	private String localPath = ".//";
	
	/**
	 * Description : 
	 * @param multipartFile
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(MultipartFile multipartFile) throws Exception {
		
		byte[] bytes = multipartFile.getBytes();
		// csv file stored at Root folder
        Path path = Paths.get(localPath + multipartFile.getOriginalFilename());
        Files.write(path, bytes);
        
		return path.toString();
	}
	

}
