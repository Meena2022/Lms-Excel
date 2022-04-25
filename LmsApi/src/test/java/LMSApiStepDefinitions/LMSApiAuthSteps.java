package LMSApiStepDefinitions;

import static io.restassured.RestAssured.given;



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

public class LMSApiAuthSteps extends BaseClass{
	
	RequestSpecification request;
	Response response;
	Scenario scn;
	TestContext _textcontext;
	
	public LMSApiAuthSteps(TestContext testcontext) {
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
	@Given("Enter with  Login User Name {string} Passowrd {string}")
	public void enter_with_login_user_name_passowrd(String userId, String password) {
		request=given().baseUri(loginURL)
				.when()
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}

	@When("Click Ok button")
	public void click_ok_button() {
		response=_textcontext.get_requestspecCT().get();
		_textcontext.set_responseCT(response);
	}

	@Then("Status Code is {int} and Authorization Successful")
	public void status_code_is_and_authorization_successful(Integer sucessCode) {
		_textcontext.get_responseCT().then().assertThat().statusCode(sucessCode);
	}

	@Given("Enter Invalid Login User Name {string} Passowrd {string}")
	public void enter_invalid_login_user_name_passowrd(String userId, String password) {
		request=given().baseUri(loginURL)
				.when()
				.auth().basic(userId, password);
		_textcontext.set_requestspecCT(request);
	}


	@Then("Status Code is {int} Authorization Failed")
	public void status_code_is_authorization_failed(Integer failCode) {
		_textcontext.get_responseCT().then().assertThat().statusCode(failCode);
	}

	
}

