package BaseClass;



import java.io.IOException;
import java.util.List;

import LMSApiUtilities.ExcelUtil;
import LMSApiUtilities.ReadConfig;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	protected String basePath;
	protected String userEndpoint;
	protected String skillEndpoint;
	protected String skillMapEndpoint;
	protected String userskillMapEndpoint;
	protected String userId;
	protected String password;
	protected String loginURL;
	protected 	RequestSpecification request;
	protected Response response;
	protected int statusCode;
	protected Header accept;
	protected Header contentheader;
	protected ExcelUtil  xlsUtil;
	
	
	
	 protected BaseClass() {
		ReadConfig r=new ReadConfig();
		 xlsUtil=new  ExcelUtil();
		
		userId=r.getUserID();
		password=r.getUserPassowrd();
		
		loginURL=r.getLoginURL();
		basePath =r.getBasePath();
		userEndpoint=r.getUser_Endpoint();
		skillEndpoint=r.getSkill_Endpoint();
		skillMapEndpoint=r.getSkillMap_Endpoint();
		userskillMapEndpoint =r.getUserSkillMap_Endpoint();
		
	}
	 
	 public List<List<String>> ExcelDataToUserDataTbl(String sheetName) {
				try {
				
				List<List<String>> userTD =xlsUtil.readUserData(sheetName);
				return userTD;
			} catch (IOException e) {
				e.getMessage();
			}
			return null;
	}
		
 
}
