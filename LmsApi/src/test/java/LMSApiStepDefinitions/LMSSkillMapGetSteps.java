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

public class LMSSkillMapGetSteps extends BaseClass{
	RequestSpecification request;
	Response response;

	
	Scenario scn;
	TestContext _textcontext;
	
	public LMSSkillMapGetSteps(TestContext testcontext) {
		
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
	
	@Given("LMS API is up and running with User Skill Endpoint")
	public void lms_api_is_up_and_running_with_user_skill_endpoint() {
		request=given().baseUri(basePath).basePath(skillMapEndpoint)
				.when()
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}

	@Then("Displayed all User Skill details")
	public void displayed_all_user_skill_details() {

	}

	@Then("I Validate the response of all User Skill request")
	public void i_validate_the_response_of_all_user_skill_request() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/AllSkillMapSchema.json"));
		scn.log("Schema Validation of All Skill response is successful");
	}

	@Given("LMS API is running with User Skill Endpoint and User Skill Id {string}")
	public void lms_api_is_running_with_user_skill_endpoint_and_user_skill_id(String smId) {
		request=given().baseUri(basePath).basePath(skillMapEndpoint+"/{SkillMapId}")
				.when()
				.auth().basic(userId, password)
				.pathParam("SkillMapId", smId);
		_textcontext.set_requestspecCT(request);
	}

	@When("I Hit the GET Request with User Skill Id {string}")
	public void i_hit_the_get_request_with_user_skill_id(String smId) {
		response=_textcontext.get_requestspecCT().get();
		_textcontext.set_responseCT(response);
	}

	@Then("Displayed Existing User Skill Id {string} details")
	public void displayed_existing_user_skill_id_details(String smId) {
		_textcontext.get_responseCT().then().assertThat().body("user_skill_id",equalTo(smId));
		scn.log(_textcontext.get_responseCT().body().asPrettyString());
	}

	@Then("Validate the response of single User Skill")
	public void validate_the_response_of_single_user_skill() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/SkillMapSchema.json"));
		scn.log("Schema Validation of single Skill response is successful");
	}


	@Then("Displayed  User Skill  Not Found")
	public void displayed_user_skill_not_found() {
		scn.log("Failed Response message is : "+_textcontext.get_responseCT().path("message").toString());
	}



}
