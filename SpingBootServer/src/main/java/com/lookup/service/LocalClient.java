package com.lookup.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Local Client store service class
 * Functions: class to store the csv file to local path
 */

@Service
public class LocalClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	// variable to store file to local path
	private String localPath = ".//";
	
	/**
	 * Description : 
	 * @param multipartFile
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(MultipartFile multipartFile) throws Exception {
		
		log.info("uploadFile - Start");
		byte[] bytes = multipartFile.getBytes();
		// csv file stored at Root folder
        Path path	 = Paths.get(localPath + multipartFile.getOriginalFilename());
        
        Files.write(path, bytes);

		log.info("uploadFile - End");
		return path.toString();
	}
	

}
