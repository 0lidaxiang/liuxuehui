package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 学生内容表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_student_content")
public class StudentContent extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -156712343457834536L;
	
	private String studentGuid;//关联的学生基础表的guid
	
	private String xueXiao;//现在就读的学校
	
	private String zhuanYe;//在读专业
	
	private String pingJunChengJi;//在学校各科的平均成绩
	
	private String anLiJianJie;//案例简介
	
	private String anLiFenXi;//案例分析
	
	private String pictureName;//内容页使用的大图 

	@Column(name="student_guid")
	public String getStudentGuid() {
		return studentGuid;
	}

	public void setStudentGuid(String studentGuid) {
		this.studentGuid = studentGuid;
	}

	@Column(name="xuexiao")
	public String getXueXiao() {
		return xueXiao;
	}

	public void setXueXiao(String xueXiao) {
		this.xueXiao = xueXiao;
	}

	@Column(name="zhuanye")
	public String getZhuanYe() {
		return zhuanYe;
	}

	public void setZhuanYe(String zhuanYe) {
		this.zhuanYe = zhuanYe;
	}

	@Column(name="pingjunchengji")
	public String getPingJunChengJi() {
		return pingJunChengJi;
	}

	public void setPingJunChengJi(String pingJunChengJi) {
		this.pingJunChengJi = pingJunChengJi;
	}

	@Column(name="anlijianjie")
	public String getAnLiJianJie() {
		return anLiJianJie;
	}

	public void setAnLiJianJie(String anLiJianJie) {
		this.anLiJianJie = anLiJianJie;
	}

	@Column(name="anlifenxi",length=2000)
	public String getAnLiFenXi() {
		return anLiFenXi;
	}

	public void setAnLiFenXi(String anLiFenXi) {
		this.anLiFenXi = anLiFenXi;
	}

	@Column(name="picture_name")
	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	
	
}
