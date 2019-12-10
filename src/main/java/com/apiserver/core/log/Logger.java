package com.apiserver.core.log;

import com.apiserver.core.file.FileChannelWrite;
import com.apiserver.config.LogMaker;

/**
 * 
 * <pre>
 * Description : 
 *
 * </pre>
 *
 * @author skan
 * @since 2018. 5. 15.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class Logger implements ILogCreation {
	
	private static String DIRECTORY_PATH ;
	private static String FIEL_NAME ;
	
	static {
			
		DIRECTORY_PATH = System.getProperty("HOME_PATH");
		FIEL_NAME = "";
	}
	

	@Override
	public void write(String message) {
		
		FileChannelWrite fileChannelWrite = new FileChannelWrite();
		fileChannelWrite.fileWrite( Logger.DIRECTORY_PATH ,  Logger.FIEL_NAME , message);
		
	}

	@Override
	public void write(String pattern, String message) {
		
		
	}

	@Override
	public void write(LogMaker logMaker, String pattern, String message) {
		// TODO Auto-generated method stub
		
	}

}
