package com.apiserver.core.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChannelWrite {
	
	/**
	 * 파일 생성 및 이어 쓰기  
	 * @param directoryPath
	 * @param fileName
	 */
	public void fileWrite (String directoryPath , String fileName, String data ) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(data);
		sb.append(System.lineSeparator());
		
		Path file = Paths.get(directoryPath, fileName);
		Path directory = Paths.get(directoryPath);
		if(Files.notExists(directory)) {
			try {
				Files.createDirectories(directory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try(FileOutputStream out =  new FileOutputStream(file.toFile(), true);
				FileChannel fileChannel = out.getChannel();) {
						
			ByteBuffer byteBuffer = Charset.defaultCharset().encode(sb.toString());
			fileChannel.write(byteBuffer);
			
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
