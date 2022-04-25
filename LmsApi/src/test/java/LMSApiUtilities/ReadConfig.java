package LMSApiUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties prop;
	
	public  ReadConfig() {
		
		File f= new File("./src/test/resources/Configuration/config.properties");
		try {
			FileInputStream fileInput =new FileInputStream(f);
			prop =new Properties();
			prop.load(fileInput);
		} catch (Exception e) {
			System.out.print("Exception Message :" + e.getMessage());
		}
	}
	
	public String getLoginURL() {
		return prop.getProperty("loginURL");
	} 
	public String getBasePath() {
		return prop.getProperty("basePath");
	}
	public String getUserID() {
		return prop.getProperty("userId");
	}
	public String getUserPassowrd() {
		return prop.getProperty("password");
	}
	public String getUser_Endpoint() {
		return prop.getProperty("userEndpoint");
	}
	public String getSkill_Endpoint() {
		return prop.getProperty("skillEndpoint");
	}
	public String getSkillMap_Endpoint() {
		return prop.getProperty("skillMapEndpoint");
	}
	public String getUserSkillMap_Endpoint() {
		return prop.getProperty("userSkillMap");
	}
}

