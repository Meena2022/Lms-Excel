package Models;

public class SkillMapMember {
private int months_of_exp;
private int skill_id;
private String user_id;
public SkillMapMember(int months_of_exp, int skill_id, String user_id) {
	super();
	this.months_of_exp = months_of_exp;
	this.skill_id = skill_id;
	this.user_id = user_id;
}
public int getMonths_of_exp() {
	return months_of_exp;
}
public void setMonths_of_exp(int months_of_exp) {
	this.months_of_exp = months_of_exp;
}
public int getSkill_id() {
	return skill_id;
}
public void setSkill_id(int skill_id) {
	this.skill_id = skill_id;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
@Override
public String toString() {
	return "SkillMapMember [months_of_exp=" + months_of_exp + ", skill_id=" + skill_id + ", user_id=" + user_id + "]";
}


}
