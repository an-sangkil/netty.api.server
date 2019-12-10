package com.apiserver.core.file;

import org.junit.Test;

public class FileChannelWriteTest {
	
	@Test
	public void fileWrite() {
		
		FileChannelWrite fileChannelWrite = new FileChannelWrite();
		for (int i = 1 ; i <= 10 ; i ++ ) {
			fileChannelWrite.fileWrite("d:/test", "test1.txt" , "hello"+i);	
		}
	}

}
