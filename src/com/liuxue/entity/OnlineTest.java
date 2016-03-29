package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 在线测评基础表
 * 
 * @author 王闯
 * @date 2015-6-6
 * 
 * */

@Entity
@Table(name = "t_onlinetest")
public class OnlineTest extends BaseEntity {
	/**
	 * @Fields serialVersionUID : 序列标识
	 */

	private static final long serialVersionUID = -123445123457834536L;

	private String school;// 现在就读学校

	private String grade;// 年级

	private String major;// 在读专业

	private String examType;// 所考英语类型

	private String score;// 得分

	private String intentionCountry;// 意向国家

	private String intentionMajor;// 希望就读专业

	private String planOutTime;// 计划出国时间

	private String phoneNumber;// 手机号码
	
	private Integer zhuangTai;//0为处理 1已处理  
	
	private Date luRuTime;//录入时间
	
	private String guoJia;//所在国家

	@Column(name = "school")
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "grade")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "major")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "examtype")
	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	@Column(name = "score")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Column(name = "intentioncountry")
	public String getIntentionCountry() {
		return intentionCountry;
	}

	public void setIntentionCountry(String intentionCountry) {
		this.intentionCountry = intentionCountry;
	}

	@Column(name = "intentionmajor")
	public String getIntentionMajor() {
		return intentionMajor;
	}

	public void setIntentionMajor(String intentionMajor) {
		this.intentionMajor = intentionMajor;
	}

	@Column(name = "planouttime")
	public String getPlanOutTime() {
		return planOutTime;
	}

	public void setPlanOutTime(String planOutTime) {
		this.planOutTime = planOutTime;
	}

	@Column(name = "phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="zhuangTai")
	public Integer getZhuangTai() {
		return zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai) {
		this.zhuangTai = zhuangTai;
	}

	@Column(name="luru_time")
	public Date getLuRuTime() {
		return luRuTime;
	}

	public void setLuRuTime(Date luRuTime) {
		this.luRuTime = luRuTime;
	}

	@Column(name="guoJia")
	public String getGuoJia() {
		return guoJia;
	}

	public void setGuoJia(String guoJia) {
		this.guoJia = guoJia;
	}
	
	

}
