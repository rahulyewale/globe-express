package com.express.globe.business.service.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigUtil
{
	static final Logger logger = Logger.getLogger(ConfigUtil.class);

	private static Properties config = new Properties();

	static
	{
		try
		{
			InputStream input = new FileInputStream("config.properties");
			config.load(input);
		}
		catch (Exception e)
		{
			logger.error("Error While Loading Config", e);
		}
	}
	
	public static String getPropertyValue(String key)
	{
		return (String) config.get(key);
	}
	
	public static Properties getProperties()
	{
		return config;
	}
}
