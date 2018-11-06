package com.lookup.constants;

/**
 * Added to store constants in spring boot webapp
 */
public class CommonConstants {

	/* Success */
	public static String SUCCESS = "Success";
	
	/* Upload attachments failure */
	public static String INVALID_ATTACHMENT = "Invalid attachment extension";
	
	/* File path */
	public static String FILE_PATH = ".//normal.csv";
	
	public static interface StatusCodes
	{
		public static String SUCCESS = "200";
		public static String INVALID = "500";
		public static String EXCEPTION = "400";
	}	
}
