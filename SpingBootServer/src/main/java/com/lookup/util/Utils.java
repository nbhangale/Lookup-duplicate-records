package com.lookup.util;

import org.springframework.web.multipart.MultipartFile;


/**
 * Added to check the attachment extension
* @throws IOException 
* @throws MagicException 
* @throws MagicMatchNotFoundException 
* @throws MagicParseException 
 */

public class Utils {
	 
	/**
	 * Description : 
	 * @param multipart
	 * @return
	 * @throws Exception
	 */
	 public static boolean isValidExt(MultipartFile multipart) throws Exception
	 {
		 boolean isValid = true;
		 
		 // checks if file has extension csv
		 if(!(multipart.getOriginalFilename().endsWith(".csv")))
		 {
			 isValid = false;
		 }
				 
		 return isValid; 
	 }
}
