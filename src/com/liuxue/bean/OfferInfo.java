package com.liuxue.bean;

public class OfferInfo {
	
/*
 * `id` int(15) NOT NULL AUTO_INCREMENT,
  `school_id` int(15) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `flag` int(1) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `student_id` int(15) NOT NULL,
 */
	
	// offer ��
	
	private String studentId;
	private String schoolId;
	private String name;//student
	private String schoolNmae;
	
	private String description;
	private String time;//offer time
	
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchoolNmae() {
		return schoolNmae;
	}
	public void setSchoolNmae(String schoolNmae) {
		this.schoolNmae = schoolNmae;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
