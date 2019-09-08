package com.deswaef.spring.examples.datajpa.util;

public final class Constants {
	// Rest Api Constants
	public static final int REGISTERATION_SUCCESSFUL = 101;
	public static final int LOGIN_SUCCESSFUL = 102;
	public static final int FILEUPLOAD_SUCCESSFUL_ = 103;
	
	public static final int REGISTERATION_FAILED = 201;
	public static final int LOGIN_FAILED = 202;
	public static final int FILEUPLOAD_FAILED = 203;
	
	public static final int USER_ALREADY_REGISTERD = 301;
	public static final int FILE_DOES_NOT_EXIST = 302;
	
	// File Related Constants
	public static final String FILE_DIRECTORY = System.getProperty("user.dir")+"/uploads";
}
