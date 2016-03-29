package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 文案内容表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_wenan_content")
public class WenAnContent extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -232312343457834536L;
	
	private String wenAnGuid;//顾问关联guid
	
	private String jieShao;//详细介绍
	
	private String dianHua;//联系电话
	
	private String QQ;//联系qq
	
	private String weiXin;//微信号
	
	private String boKeUrl;//博客链接
	
	private String pictureName;//内容大图名称

	
	@Column(name="wenanguid")
	public String getWenAnGuid() {
		return wenAnGuid;
	}

	public void setWenAnGuid(String wenAnGuid) {
		this.wenAnGuid = wenAnGuid;
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
	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qq) {
		QQ = qq;
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
