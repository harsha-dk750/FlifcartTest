package com.Flifcart.Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileData {
	/**
	 * This method is used fetch the propertyfile data
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key)
	{
		FileInputStream fis = null;
		try 
		{
			fis = new FileInputStream(IConstantPath.PROPERTY_FILE_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
		Properties property = new Properties();
		try 
		{
			property.load(fis);
		}
		catch (IOException e) 
		{
			System.out.println("IO excep");
		}

		String data = property.getProperty(key).trim();
		return data;

	}




}
