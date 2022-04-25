package LMSApiStepDefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import com.google.gson.Gson;

import BaseClass.BaseClass;
import LMSApiUtilities.TestContext;
import Models.SkillMapMember;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMSSkillMapPutSteps extends BaseClass{
	RequestSpecification request;
	Response response;

	
	Scenario scn;
	TestContext _textcontext;
	String jsonBody;
	
	int newskillId;
	String newUserId;
	int newExp;
	
	public LMSSkillMapPutSteps(TestContext testcontext) {
		
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
	
	@When("I Entered experience {int},skill Id {int},User Id {string} in PUT request body")
	public void i_entered_experience_skill_id_user_id_in_put_request_body(Integer experience, Integer sId, String uId) {
		SkillMapMember jsonString=new SkillMapMember(experience,sId,uId);
		Gson gson=new Gson();
		jsonBody = gson.toJson(jsonString); 
		newskillId=sId;
		newUserId=uId;
		newExp=experience;
		
		
	}
	
	@When("I Hit the PUT Request of User Skill Id {string}")
	public void i_hit_the_put_request_of_user_skill_id(String smId) {
		response = _textcontext.get_requestspecCT()
				.contentType(ContentType.JSON)
				.body(jsonBody).put();
		_textcontext.set_responseCT(response);
	}

	@Then("Displayed Successful User Skill updated")
	public void displayed_successful_user_skill_updated() {
		_textcontext.get_responseCT().then().assertThat().body("skill_id",equalTo(newskillId));
		_textcontext.get_responseCT().then().assertThat().body("skill_id",equalTo(newskillId));
		_textcontext.get_responseCT().then().assertThat().body("months_of_exp",equalTo(newExp));
		scn.log("Respons message of User Skill  : "+_textcontext.get_responseCT().path("message_response").toString());
		scn.log("Modified  User Skill Id is   : "+_textcontext.get_responseCT().path("user_skill_id").toString());
	}

	@Then("I Validate Put response of User Skill Map")
	public void i_validate_put_response_of_user_skill_map() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/SkillMapPostSchema.json"));
		scn.log("User Skill Map - Put request JSON schema validation is Successful");
	}

	@Then("Displayed Failed to update User skill Map")
	public void displayed_failed_to_update_user_skill_map() {
		scn.log("Failed Response Body message is : "+_textcontext.get_responseCT().path("message").toString());
	}

	@Given("LMS API is running with User Skill Endpoint and Skill Id {string}")
	public void lms_api_is_running_with_user_skill_endpoint_and_skill_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
