package Models;

public class SkillMember {
	private String skill_name; 
	
	
	
	private transient int  skill_id;
	
	
	
	
	public SkillMember(int skill_id,  String skill_name) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
	}
	public SkillMember(  String skill_name) {
		super();
	
		this.skill_name = skill_name;
	}
	

	
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}

	@Override
	public String toString() {
		return "SkillMember [skill_name=" + skill_name + "]";
	}

}
