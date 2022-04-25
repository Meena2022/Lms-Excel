package LMSApiStepDefinitions;



import BaseClass.BaseClass;
import LMSApiUtilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LMSUserDeleteSteps extends BaseClass {
	
	RequestSpecification request;
	Response response;
	Header contenheader;
	String jsonBody;
	int responseCode;
	Scenario scn;
	
	TestContext _textcontext;
	
	public LMSUserDeleteSteps(TestContext testcontext) {
		
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
	
	@When("I Hit the Delete request with User Id {string}")
	public void i_hit_the_delete_request_with_user_id(String Id) {
		response=_textcontext.get_requestspecCT().delete();
		System.out.print(response.statusCode());
		_textcontext.set_responseCT(response);
	}

	
	@Then("Displayed Successful User {string} deleted")
	public void displayed_successful_user_deleted(String uId) {
		//_textcontext.get_responseCT().then().assertThat().body("user_ id",equalTo(uId));
		scn.log("Respons Body message is : "+_textcontext.get_responseCT().path("message_response").toString());
	}
	
	
}
