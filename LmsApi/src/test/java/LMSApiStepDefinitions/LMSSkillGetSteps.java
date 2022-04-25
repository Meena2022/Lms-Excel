package LMSApiStepDefinitions;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import BaseClass.BaseClass;
import LMSApiUtilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMSSkillGetSteps extends BaseClass{
	RequestSpecification request;
	Response response;

	
	Scenario scn;
	TestContext _textcontext;
	
	public LMSSkillGetSteps(TestContext testcontext) {
		
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
	@Given("LMS API is up and running with Skills Endpoint")
	public void lms_api_is_up_and_running_with_skills_endpoint() {
		request=given().baseUri(basePath).basePath(skillEndpoint)
				.when()
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}

	@Then("Displayed all Skills details")
	public void displayed_all_skills_details() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("I Validate the response of all Skills request")
	public void i_validate_the_response_of_all_skills_request() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/AllSkillSchema.json"));
		scn.log("Schema Validation of All Skill response is successful");
	}

	@Given("LMS API is running with Skills Endpoint and Skill Id {int}")
	public void lms_api_is_running_with_skills_endpoint_and_skill_id(Integer sId) {
		System.out.println(basePath+skillEndpoint+"/"+sId);
		request=given().baseUri(basePath).basePath(skillEndpoint +"/{SkillId}")
				.auth().basic(userId, password)
				.pathParam("SkillId", sId);
		_textcontext.set_requestspecCT(request);
	}

	@When("I Hit the GET Request with Skills Id {int}")
	public void i_hit_the_get_request_with_skills_id(Integer sId) {
		response=_textcontext.get_requestspecCT().get();
		_textcontext.set_responseCT(response);
	}

	@Then("Displayed Existing Skill Id {int} details")
	public void displayed_existing_skill_id_details(Integer sId) {
		_textcontext.get_responseCT().then().assertThat().body("skill_id",equalTo(sId));
		scn.log(_textcontext.get_responseCT().body().asPrettyString());
	
	}

	@Then("Validate the response of single Skill")
	public void validate_the_response_of_single_skill() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/SkillSchema.json"));
		scn.log("Schema Validation of single Skill response is successful");
	}

	@Then("Displayed  Skill Not Found")
	public void displayed_skill_not_found() {
		scn.log("Failed Response message is : "+_textcontext.get_responseCT().path("message").toString());
	}


}
