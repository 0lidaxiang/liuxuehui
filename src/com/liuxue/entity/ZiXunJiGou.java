package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 机构基础表
 * @author 李成龙
 * @date 2015-6-3
 * 
 * */

@Entity
@Table(name = "t_jigou")
public class ZiXunJiGou extends BaseEntity{
	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -123445123457834536L;
	
	private String name;//机构名称
	
	private String jianJie;//机构简介
	
	private Integer renQi;//人气
	
	private Integer pingJia;//评价
	
	private String shanChangGuoJia;//擅长国家
	
	private String ziXunXingShi;//咨询形式
	
	private String photoUrl;//列表图片 路径
	
	private Integer indexXyBj;//首页选用标记  1标示选用 0标示未选用
	
	private String indexPhotoName;//放在首页时用到的图片
	
	private Integer indexWeiZhi;//放在首页的位置（为了顺序而存在）
	
	private String indexMiaoShu;//首页使用描述语句
	
	@Column(name="index_miaoshu")
	public String getIndexMiaoShu() {
		return indexMiaoShu;
	}

	public void setIndexMiaoShu(String indexMiaoShu) {
		this.indexMiaoShu = indexMiaoShu;
	}

	
	@Column(name="index_weizhi")
	public Integer getIndexWeiZhi() {
		return indexWeiZhi;
	}

	public void setIndexWeiZhi(Integer indexWeiZhi) {
		this.indexWeiZhi = indexWeiZhi;
	}
	
	@Column(name="index_xybj")
	public Integer getIndexXyBj() {
		return indexXyBj;
	}

	public void setIndexXyBj(Integer indexXyBj) {
		this.indexXyBj = indexXyBj;
	}

	@Column(name="index_photo_name")
	public String getIndexPhotoName() {
		return indexPhotoName;
	}

	public void setIndexPhotoName(String indexPhotoName) {
		this.indexPhotoName = indexPhotoName;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="jianjie")
	public String getJianJie() {
		return jianJie;
	}

	public void setJianJie(String jianJie) {
		this.jianJie = jianJie;
	}

	@Column(name="renqi")
	public Integer getRenQi() {
		return renQi;
	}

	public void setRenQi(Integer renQi) {
		this.renQi = renQi;
	}

	@Column(name="pingjia")
	public Integer getPingJia() {
		return pingJia;
	}

	public void setPingJia(Integer pingJia) {
		this.pingJia = pingJia;
	}

	@Column(name="shanchangguojia")
	public String getShanChangGuoJia() {
		return shanChangGuoJia;
	}

	public void setShanChangGuoJia(String shanChangGuoJia) {
		this.shanChangGuoJia = shanChangGuoJia;
	}

	@Column(name="zixunxingshi")
	public String getZiXunXingShi() {
		return ziXunXingShi;
	}

	public void setZiXunXingShi(String ziXunXingShi) {
		this.ziXunXingShi = ziXunXingShi;
	}

	@Column(name="photourl")
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	
	
	
	
}
