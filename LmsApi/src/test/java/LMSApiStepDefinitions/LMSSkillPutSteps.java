package LMSApiStepDefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import com.google.gson.Gson;

import BaseClass.BaseClass;
import LMSApiUtilities.TestContext;
import Models.SkillMember;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMSSkillPutSteps extends BaseClass {
	RequestSpecification request;
	Response response;

	
	Scenario scn;
	TestContext _textcontext;
	String jsonBody;
	String newSkillname;
	
	public LMSSkillPutSteps(TestContext testcontext) {
		
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
	@When("I Hit PUT request with skill name {string} in Request body")
	public void i_hit_put_request_with_skill_name_in_request_body(String Sname) {
		SkillMember jsonString=new SkillMember(Sname);
		Gson gson=new Gson();
		jsonBody = gson.toJson(jsonString); 
		System.out.println(jsonBody);
		response = _textcontext.get_requestspecCT()
					.contentType(ContentType.JSON)
					.body(jsonBody).put();
		_textcontext.set_responseCT(response);
		newSkillname=Sname;
	}

	@Then("Displayed Successful Skill updated")
	public void displayed_successful_skill_updated() {
		_textcontext.get_responseCT().then().assertThat().body("skill_name",equalTo(newSkillname));
		scn.log("Respons Body message of Skills : "+_textcontext.get_responseCT().path("message_response").toString());
	}
	
	@Then("I Validate Put response of Skills")
	public void i_validate_put_response_of_skills() {
	  
	}

	@When("I Hit the PUT request with skill name {string} in Request body")
	public void i_hit_the_put_request_with_skill_name_in_request_body(String string) {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/SkillPostSchema.json"));
		scn.log("Response of PUT request JSON schema validation is Successful");
	}

}	
