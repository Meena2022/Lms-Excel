package LMSApiStepDefinitions;

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
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;

public class LMSUserGetSteps extends BaseClass{
	
	
	RequestSpecification request;
	Response response;

	
	Scenario scn;
	TestContext _textcontext;
	
	public LMSUserGetSteps(TestContext testcontext) {
		
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
	@Given("LMS API is up and running with User Endpoint")
	public void lms_api_is_up_and_running_with_user_endpoint() {
		request=given().baseUri(basePath).basePath(userEndpoint)
				.when()
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}

	@When("I Hit the GET Request")
	public void i_hit_the_get_request() {
		response=_textcontext.get_requestspecCT().get();
		_textcontext.set_responseCT(response);
	}

	@Then("Response Success status code is {int}")
	public void response_success_status_code_is(Integer SuccessCode) {
		_textcontext.get_responseCT().then().assertThat().statusCode(SuccessCode);
	}

	@Then("Displayed all User details")
	public void displayed_all_user_details() {
		//scn.log(_textcontext.get_responseCT().body().asPrettyString());
	}
	


	@Then("I Validate the response of all user request")
	public void i_validate_the_response_of_all_user_request() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/AllUserSchema.json"));
		scn.log("Schema Validation of All user response is successful");
	}
	
	@Given("LMS API is running with User Endpoint and User Id {string}")
	public void lms_api_is_running_with_user_endpoint_and_user_id(String id) {
		request=given().baseUri(basePath).basePath(userEndpoint+"/{userid}")
				.when()
				.pathParam("userid", id)
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}
	
	@When("I Hit the GET Request with User Id {string}")
	public void i_hit_the_get_request_with_user_id(String Id) {
		response=_textcontext.get_requestspecCT().get();
		_textcontext.set_responseCT(response);
	
	}

	@Then("Displayed Existing User {string} details")
	public void displayed_existing_user_details(String Id) {
		_textcontext.get_responseCT().then().assertThat().body("user_id",equalTo(Id));
		scn.log(_textcontext.get_responseCT().body().asPrettyString());
	}

	@Then("Validate the response of Single User")
	public void validate_the_response_of_single_user() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/UserSchema.json"));
		scn.log("Schema Validation of single User response is successful");
	}

	@Then("Response Failed status code is {int}")
	public void response_failed_status_code_is(Integer FailCode) {
		_textcontext.get_responseCT().then().assertThat().statusCode(FailCode);
	}

	@Then("Displayed  User Not Found")
	public void displayed_user_not_found() {
		scn.log("Failed Response message is : "+_textcontext.get_responseCT().path("message").toString());
	}

	

}


