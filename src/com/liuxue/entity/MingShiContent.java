package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 名师内容表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_mingshi_content")
public class MingShiContent extends BaseEntity{
	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -121212343457834536L;
	
	private String mingShiGuid;//顾问关联guid
	
	private String jieShao;//详细介绍
	
	private String dianHua;//联系电话
	
	private String qq;//联系qq
	
	private String weiXin;//微信号
	
	private String boKeUrl;//博客链接
	
	private String pictureName;//内容大图名称

	
	@Column(name="mingshiguid")
	public String getMingShiGuid() {
		return mingShiGuid;
	}

	public void setMingShiGuid(String mingShiGuid) {
		this.mingShiGuid = mingShiGuid;
	}

	@Column(name="jieshao",length=1000)
	public String getJieShao() {
		return jieShao;
	}

	public void setJieShao(String jieShao) {
		this.jieShao = jieShao;
	}

	@Column(name="dianhua")
	public String getDianHua() {
		return dianHua;
	}

	public void setDianHua(String dianHua) {
		this.dianHua = dianHua;
	}

	@Column(name="QQ")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name="weixin")
	public String getWeiXin() {
		return weiXin;
	}

	public void setWeiXin(String weiXin) {
		this.weiXin = weiXin;
	}

	@Column(name="bokeurl")
	public String getBoKeUrl() {
		return boKeUrl;
	}

	public void setBoKeUrl(String boKeUrl) {
		this.boKeUrl = boKeUrl;
	}

	@Column(name="pictrue_name")
	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	
}
