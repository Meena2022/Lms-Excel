package LMSApiStepDefinitions;

import static org.hamcrest.Matchers.equalTo;

import BaseClass.BaseClass;
import LMSApiUtilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMSSkillDeleteSteps extends BaseClass {

	RequestSpecification request;
	Response response;

	
	Scenario scn;
	TestContext _textcontext;
	
	public LMSSkillDeleteSteps(TestContext testcontext) {
		
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
	@When("I Hit the Delete request with Skill Id {int}")
	public void i_hit_the_delete_request_with_skill_id(Integer int1) {
		response=_textcontext.get_requestspecCT().delete();
		System.out.print(response.statusCode());
		_textcontext.set_responseCT(response);
	}

	
	@Then("Displayed Successful Skill id {int} deleted")
	public void displayed_successful_skill_id_deleted(Integer sId) {
		_textcontext.get_responseCT().then().assertThat().body("Skill_Id",equalTo(Integer.toString(sId)));
		scn.log("Respons Body message is : "+_textcontext.get_responseCT().path("message_response").toString());
	}
	
}
