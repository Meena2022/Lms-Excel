package LMSApiUtilities;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {
	
	private RequestSpecification _requestspecCT;
	private Response _responseCT;
	private Scenario _scnCon;

	public RequestSpecification get_requestspecCT() {
		return _requestspecCT;
	}
	
	public void set_requestspecCT(RequestSpecification _requestspecCT) {
		this._requestspecCT = _requestspecCT;
	}
	
	public Response get_responseCT() {
		return _responseCT;
	}
	
	public void set_responseCT(Response _responseCT) {
		this._responseCT = _responseCT;
	}
	
	public Scenario get_scnCon() {
		return _scnCon;
	}
	
	public void set_scnCon(Scenario _scnCon) {
		this._scnCon = _scnCon;
	}
	
	
	
}
