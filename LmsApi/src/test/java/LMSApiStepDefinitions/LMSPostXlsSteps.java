package LMSApiStepDefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;


import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import BaseClass.BaseClass;
import LMSApiUtilities.TestContext;
import Models.SkillMapMember;
import Models.SkillMember;
import Models.UserMember;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMSPostXlsSteps extends BaseClass{
	
	RequestSpecification request;
	Response response;
	Header contenheader;
	String jsonBody;
	Scenario scn;
	TestContext _textcontext;
	
	
	public LMSPostXlsSteps(TestContext testcontext) {
		this._textcontext=testcontext;
	}

	@Before
	public void beforeHook(Scenario s) {
		this.scn=s;
	}
	@After
	public void afterHook(Scenario s) {
		this.scn=s;
		if(_textcontext.get_responseCT()==null) {
			//scn.log("Response : No Rsponse recived");
		}
		else {
			//scn.log("Response: "+response.asString());
		}
			
	}
	
	@When("I Hit the POST request with User data from Excel file sheet {string}")
	public void i_hit_the_post_request_with_user_data_from_excel_file_sheet(String string) {
		List<List<String>> userTd =ExcelDataToUserDataTbl("user");
		request = _textcontext.get_requestspecCT();
		
		for (List<String> usrid:userTd) {
			String comment=usrid.get(0);
			String pg=usrid.get(1);
			String ug=usrid.get(2);
			String linkedin=usrid.get(3);
			String location=usrid.get(4);
			String name=usrid.get(5);
			int phone=Integer.parseInt(usrid.get(6));
			String tzone=usrid.get(7);
			String visa=usrid.get(8);
			
			UserMember jsonString=new UserMember(comment,pg,ug,linkedin,location,name,phone,tzone,visa);
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			jsonBody = gson.toJson(jsonString);  
			
			   request.contentType(ContentType.JSON)
					  .body(jsonBody)
					  .post()
					  .then()
					  .assertThat()
					  .statusCode(201)
					  .body(matchesJsonSchemaInClasspath("./JsonSchema/UserPostSchema.json"));
		
			 //_textcontext.set_responseCT(response);
		}
	}
	

	@Then("Displayed status code {int}")
	public void displayed_status_code(Integer int1) {
	  
	}

	@When("I Hit the POST request with Skill data from Excel file sheet {string}")
	public void i_hit_the_post_request_with_skill_data_from_excel_file_sheet(String string) {
		List<List<String>> skillTd =ExcelDataToUserDataTbl("skill");

		request = _textcontext.get_requestspecCT();
		
		for (List<String> skillid:skillTd) {
			SkillMember jsonString=new SkillMember(skillid.get(0));
			Gson gson=new Gson();
			jsonBody = gson.toJson(jsonString); 
			
				request.contentType(ContentType.JSON)
						.body(jsonBody)
						.post()
						.then()
						.assertThat()
						.statusCode(201)
						.body("skill_name",equalTo(skillid.get(0)));
				
				
			//_textcontext.set_responseCT(response);	
			 
			
		}
	}

	@When("I Hit the POST request with User Skill Map data from Excel file sheet {string}")
	public void i_hit_the_post_request_with_user_skill_map_data_from_excel_file_sheet(String string) {
		List<List<String>> skillMaplTd =ExcelDataToUserDataTbl("userskillmap");
		
		request = _textcontext.get_requestspecCT();
		for (List<String> skillmapid:skillMaplTd) {
			
			int experience=Integer.parseInt(skillmapid.get(0));
			int sId=Integer.parseInt(skillmapid.get(1));
		    String uId=skillmapid.get(2);
		    
		    SkillMapMember jsonString=new SkillMapMember(experience,sId,uId);
			Gson gson=new Gson();
			jsonBody = gson.toJson(jsonString);

				request.contentType(ContentType.JSON)
						.body(jsonBody)
						.post()
					 	.then()
					 	.assertThat()
					 	.statusCode(201)
					 	.body(matchesJsonSchemaInClasspath("./JsonSchema/SkillMapPostSchema.json"));
			
			//_textcontext.set_responseCT(response);	
				
		}
	}
}
