package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 学校内容表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_xuexiao_content")
public class XueXiaoContent extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -212112343457834536L;
	
	private String xueXiaoGuid;//关联学习基础表的guid
	
	private String pictureName;//学校内容大图片
	
	private String jieShao;//介绍
	
	private String dianHua;//联系电话
	
	private String address;//地址

	@Column(name="xuexiao_guid")
	public String getXueXiaoGuid() {
		return xueXiaoGuid;
	}

	public void setXueXiaoGuid(String xueXiaoGuid) {
		this.xueXiaoGuid = xueXiaoGuid;
	}

	@Column(name="picture_name")
	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
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

	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
