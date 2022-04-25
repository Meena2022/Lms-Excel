package Models;

import com.google.gson.annotations.Expose;

public class UserMember {
	@Expose
	private String comments;
	@Expose
	private String education_ug;
	@Expose
	private String education_pg;
	@Expose
	private String linkedin_url;
	@Expose
	private String location;
	@Expose
	private String name;
	@Expose
	private int phone_number;
	@Expose
	private String time_zone;
	@Expose
	private String visa_status;
	
	
	
	
	@Expose(serialize=false, deserialize=true)
	private String user_id;
	
	//@Expose(serialize=false,deserialize=true)
	//private String message_response;
	
	public UserMember(String comments, String education_ug, String education_pg, String linkedin_url, String location,
			String name, int phone_number, String time_zone, String visa_status,String user_id) {
		super();
		this.comments = comments;
		this.education_ug = education_ug;
		this.education_pg = education_pg;
		this.linkedin_url = linkedin_url;
		this.location = location;
		this.name = name;
		this.phone_number = phone_number;
		this.time_zone = time_zone;
		this.visa_status = visa_status;
		this.user_id = user_id;
		//this.message_response="";
	}
	
	
	public UserMember(String comments, String education_ug, String education_pg, String linkedin_url, String location,
			String name, int phone_number, String time_zone, String visa_status) {
		super();
		this.comments = comments;
		this.education_ug = education_ug;
		this.education_pg = education_pg;
		this.linkedin_url = linkedin_url;
		this.location = location;
		this.name = name;
		this.phone_number = phone_number;
		this.time_zone = time_zone;
		this.visa_status = visa_status;
	}







	public String getmessage_response() {
		return user_id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	public String getLinkedin_url() {
		return linkedin_url;
	}
	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getEducation_pg() {
		return education_pg;
	}
	public void setEducation_pg(String education_pg) {
		this.education_pg = education_pg;
	}
	public String getEducation_ug() {
		return education_ug;
	}
	public void setEducation_ug(String education_ug) {
		this.education_ug = education_ug;
	}
	public String getVisa_status() {
		return visa_status;
	}
	public void setVisa_status(String visa_status) {
		this.visa_status = visa_status;
	}
	
	
	
	
	

}
