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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMSUserSkillMapGetSteps extends BaseClass{
	
	RequestSpecification request;
	Response response;

	
	Scenario scn;
	TestContext _textcontext;
	
	public LMSUserSkillMapGetSteps(TestContext testcontext) {
		
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
	@Given("LMS API is up and running with User Skill Map Endpoint")
	public void lms_api_is_up_and_running_with_user_skill_map_endpoint() {
		request=given().baseUri(basePath).basePath(userskillMapEndpoint)
				.when()
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}

	@Then("Displayed all User Skill Map details")
	public void displayed_all_user_skill_map_details() {
	  
	}
	
	@Then("I Validate the response of all User Skill Map request")
	public void i_validate_the_response_of_all_user_skill_map_request() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/AllUserSkillMapSchema.json"));
		scn.log("Schema Validation of AllUserSkillMap response is successful");
	   
	}

	@Given("LMS API is up and running with User Skill Map Endpoint and User Id {string}")
	public void lms_api_is_up_and_running_with_user_skill_map_endpoint_and_user_id(String Id) {
		request=given().baseUri(basePath).basePath(userskillMapEndpoint+"/{uid}")
				.when()
				.pathParam("uid", Id)
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}

	@Then("Displayed User Id {string} User Skill Map details")
	public void displayed_user_id_user_skill_map_details(String Id) {
		_textcontext.get_responseCT().then().assertThat().body("users.id",equalTo(Id));
		scn.log(_textcontext.get_responseCT().body().asPrettyString());
	}

	@Then("I Validate the response of User Skill Map request based on User Id")
	public void i_validate_the_response_of_user_skill_map_request_based_on_user_id() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/UserSkillMapSchema.json"));
		scn.log("Schema Validation of UserSkillMap response based on User Id is successful");
	
	}
	@Given("LMS API is up and running with User Skill Map Endpoint and Skill Id {int}")
	public void lms_api_is_up_and_running_with_user_skill_map_endpoint_and_skill_id(Integer sId) {
		request=given().baseUri(basePath).basePath("/UsersSkillsMap/"+"{sid}")
				.when()
				.pathParam("sid", sId)
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}

	@Then("Displayed Skill Id {int} User Skill Map details")
	public void displayed_skill_id_user_skill_map_details(Integer sId) {
		_textcontext.get_responseCT().then().assertThat().body("users[0].skillmap.id[0]",equalTo(sId));
	
		scn.log(_textcontext.get_responseCT().body().asPrettyString());
	}

	@Then("I Validate the response of User Skill Map request based on Skill Id")
	public void i_validate_the_response_of_user_skill_map_request_based_on_skill_id() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/UsersSkillsMapSchema.json"));
		scn.log("Schema Validation of UserSkillMap response based on Skill Id  is successful");
	}

}
