package cn.itcast.domain;
/**
 * 学生信息类
 * 
 * @author jack
 *
 */
public class Student {
	private String idcard;
	private String name;
	private String examid;
	private String location;
	private float grade;
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [idcard=" + idcard + ", name=" + name + ", examid=" + examid + ", location=" + location
				+ ", grade=" + grade + "]";
	}
	
	
}
