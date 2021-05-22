package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath = "C:\\Users\\ABHILASH\\eclipse-workspace\\Demo_ImpactGuru\\application.properties";
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("application.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getUrl(){
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("url not specified in the application.properties file.");		
	}
	public String getBrowserName() {
		String browserName = properties.getProperty("browserName");	
		if(browserName!= null) return browserName;
		else throw new RuntimeException("url not specified in the application.properties file.");		

	}
	}
