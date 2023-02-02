package com.qsp.trello.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class FileUtility {
	
	public String readKeyValue(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonsData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String keyValue = pobj.getProperty(key);
		return keyValue;
	}
}
 