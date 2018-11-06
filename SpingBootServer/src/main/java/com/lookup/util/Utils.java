package com.lookup.util;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatch;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

/**
 * Added to check the attachment extension
* @throws IOException 
* @throws MagicException 
* @throws MagicMatchNotFoundException 
* @throws MagicParseException 
 */

public class Utils {
	 
	 public static boolean isValidExt(MultipartFile multipart) throws Exception
	 {
		 boolean isValid = true;
		 
		 // byte[] data = multipart.getBytes();
		 // MagicMatch match = Magic.getMagicMatch(data);
		 // String mimeType = match.getMimeType();
		 
		 // checks if file has extension csv
		 if(!(multipart.getOriginalFilename().contains(".csv")))
		 {
			 isValid = false;
		 }
				 
		 return isValid; 
	 }
}
