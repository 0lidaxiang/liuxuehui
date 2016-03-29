package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;


/**
 * 机构内容表
 * @author 李成龙
 * @date 2015-6-3
 * 
 * */

@Entity
@Table(name = "t_jigoucontent")
public class ZiXunJiGouContent extends BaseEntity{
	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -123445112355434536L;
	
	private String pictureUrl;//机构内容中的大图片
	
	private String jieShao;//机构的详细介绍
	
	private String dianHua;//联系电话
	
	private String adress;//机构地址
	
	private String jiGouGuid;//关联基础表的id

	@Column(name="pictureurl")
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
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

	@Column(name="adress")
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name="jigouguid")
	public String getJiGouGuid() {
		return jiGouGuid;
	}

	public void setJiGouGuid(String jiGouGuid) {
		this.jiGouGuid = jiGouGuid;
	}
	
	

}
