package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 课程内容表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_kecheng_content")
public class KeChengContent extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -145612343412834536L;
	
	private String keChengGuid;//关联基础表课程的guid
	
	private String jiaoCai;//学习所用到的教材
	
	private String shiHeDuiXiang;//适合对象
	
	private String baoFenChengNuo;//保分承诺
	
	private String keChengFenXi;//课程分析
	
	private String pictureName;//内容页使用到的大图片
	
	private String dianHua;//联系电话
	
	private String weiXin;//微信号

	@Column(name="kechengguid")
	public String getKeChengGuid() {
		return keChengGuid;
	}

	public void setKeChengGuid(String keChengGuid) {
		this.keChengGuid = keChengGuid;
	}

	@Column(name="jiaocai")
	public String getJiaoCai() {
		return jiaoCai;
	}

	public void setJiaoCai(String jiaoCai) {
		this.jiaoCai = jiaoCai;
	}

	@Column(name="shiheduixiang")
	public String getShiHeDuiXiang() {
		return shiHeDuiXiang;
	}

	public void setShiHeDuiXiang(String shiHeDuiXiang) {
		this.shiHeDuiXiang = shiHeDuiXiang;
	}

	@Column(name="baofenchengnuo")
	public String getBaoFenChengNuo() {
		return baoFenChengNuo;
	}

	public void setBaoFenChengNuo(String baoFenChengNuo) {
		this.baoFenChengNuo = baoFenChengNuo;
	}

	@Column(name="kechengfenxi",length=2000)
	public String getKeChengFenXi() {
		return keChengFenXi;
	}

	public void setKeChengFenXi(String keChengFenXi) {
		this.keChengFenXi = keChengFenXi;
	}

	@Column(name="picture_name")
	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	@Column(name="dianhua")
	public String getDianHua() {
		return dianHua;
	}

	public void setDianHua(String dianHua) {
		this.dianHua = dianHua;
	}
	
	@Column(name="weixin")
	public String getWeiXin() {
		return weiXin;
	}

	public void setWeiXin(String weiXin) {
		this.weiXin = weiXin;
	}
	
	
	
	
}
