package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 后台管理人员使用账号基础表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_adminuser")
public class AdminUser extends BaseEntity{
	
	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -543215123457834536L;
	
	private String adminUserName;//管理账号名称
	
	private String passWord;//密码
	
	private Integer dengJi;//账号等级

	@Column(name="adminusername")
	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	@Column(name="password")
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name="dengji")
	public Integer getDengJi() {
		return dengJi;
	}

	public void setDengJi(Integer dengJi) {
		this.dengJi = dengJi;
	}
	
	

}
