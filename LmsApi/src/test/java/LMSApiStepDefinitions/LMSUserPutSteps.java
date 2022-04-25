package LMSApiStepDefinitions;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import BaseClass.BaseClass;
import LMSApiUtilities.TestContext;
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

public class LMSUserPutSteps extends BaseClass{
	
	RequestSpecification request;
	Response response;
	Header contenheader;
	String jsonBody;
	int responseCode;
	Scenario scn;
	
	TestContext _textcontext;
	
	String newcomt;
	String newpg;
	String newug;
	String newlinkedin;
	String newloc;
	String newname;
	int newph;
	String newtzone;
	String newvisa;
	
	public LMSUserPutSteps(TestContext testcontext) {
		
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
	@When("I Entered Comment {string},Pg {string},Ug {string},Linkedin {string},Location {string},Name {string},Phone {int},Tzone {string},Visa {string} in Put request body")
	public void i_entered_comment_pg_ug_linkedin_location_name_phone_tzone_visa_in_put_request_body(String comment, String pg, String ug, String linkedin, String location, String name, Integer phone, String tzone, String visa) {
		
		UserMember jsonString=new UserMember(comment,pg,ug,linkedin,location,name,phone,tzone,visa);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		jsonBody = gson.toJson(jsonString); 
  
		System.out.println(jsonBody);
		 newcomt= comment;
		 newpg=pg;
		 newug=ug;
		 newlinkedin=linkedin;
		 newloc=location;
		 newname=name;
		 newph=phone;
		 newtzone=tzone;
		 newvisa=visa;
	}

	@When("I Hit the PUT request with User Id {string}")
	public void i_hit_the_put_request_with_user_id(String Id) {
		response=_textcontext.get_requestspecCT()
				.contentType(ContentType.JSON)
				.body(jsonBody).put();
		_textcontext.set_responseCT(response);
	}

	@Then("PUT Response Success status code is {int}")
	public void put_response_success_status_code_is(Integer Successcode) {
		
		_textcontext.get_responseCT().then().assertThat().statusCode(Successcode);
	}

	@Then("Displayed Successful user updated")
	public void displayed_successful_user_updated() {
		_textcontext.get_responseCT().then().assertThat().body("comments",equalTo(newcomt));
		//_textcontext.get_responseCT().then().assertThat().body("education_pg",equalTo(newpg));
		//_textcontext.get_responseCT().then().assertThat().body("education_ug",equalTo(newug));
		_textcontext.get_responseCT().then().assertThat().body("linkedin_url",equalTo(newlinkedin));
		_textcontext.get_responseCT().then().assertThat().body("location",equalTo(newloc));
		_textcontext.get_responseCT().then().assertThat().body("name",equalTo(newname));
		_textcontext.get_responseCT().then().assertThat().body("phone_number",equalTo(newph));
		_textcontext.get_responseCT().then().assertThat().body("time_zone",equalTo(newtzone));
		_textcontext.get_responseCT().then().assertThat().body("visa_status",equalTo(newvisa));
		scn.log("DELETE Respons Body message is : "+_textcontext.get_responseCT().path("message_response").toString());
	}

	@Then("I Validate the response of Put request")
	public void i_validate_the_response_of_put_request() {
		_textcontext.get_responseCT().then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/UserPostSchema.json"));
		scn.log("PUT response JSON schema validation is Successful");
	}

	@Then("PUT Response Failed status code is {int}")
	public void put_response_failed_status_code_is(Integer FailCode) {
		_textcontext.get_responseCT().then().assertThat().statusCode(FailCode);
	}

	@Then("Displayed Failed to update")
	public void displayed_failed_to_update() {
		scn.log("Failed Response Body message is : "+_textcontext.get_responseCT().path("message").toString());
	}

	
}
