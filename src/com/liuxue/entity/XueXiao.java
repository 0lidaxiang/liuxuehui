package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 学校基础表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_xuexiao")
public class XueXiao extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -111112343457834536L;
	
	private String name;//学校名称
	
	private String engLishName;//英文名称
	
	private String jianjie;//学校简介
	
	private Integer pinJia;//评价  几颗星
	
	private Integer renQi;//人气 点击量
	
	private String shanChangGuoJia;//擅长国家
	
	private String photoName;//列表图片名称
	
	private String leiXing;//院校类型
	
	private String suoZaiChengShi;//所在城市
	
	private Integer weekZhaoShengShu;//周招生数
	
	private Integer monthZhaoShengShu;//月招生数
	
	private Integer yearZhaoShengShu;//年招生数
	
	private Integer indexXyBj;//首页选用标记
	
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
	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	@Column(name="pinjia")
	public Integer getPinJia() {
		return pinJia;
	}

	public void setPinJia(Integer pinJia) {
		this.pinJia = pinJia;
	}

	@Column(name="renqi")
	public Integer getRenQi() {
		return renQi;
	}

	public void setRenQi(Integer renQi) {
		this.renQi = renQi;
	}

	@Column(name="shanchangguojia")
	public String getShanChangGuoJia() {
		return shanChangGuoJia;
	}

	public void setShanChangGuoJia(String shanChangGuoJia) {
		this.shanChangGuoJia = shanChangGuoJia;
	}

	@Column(name="photo_name")
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	@Column(name="leixing")
	public String getLeiXing() {
		return leiXing;
	}

	public void setLeiXing(String leiXing) {
		this.leiXing = leiXing;
	}

	@Column(name="suozaichengshi")
	public String getSuoZaiChengShi() {
		return suoZaiChengShi;
	}

	public void setSuoZaiChengShi(String suoZaiChengShi) {
		this.suoZaiChengShi = suoZaiChengShi;
	}

	@Column(name="week_zhaoshengshu")
	public Integer getWeekZhaoShengShu() {
		return weekZhaoShengShu;
	}

	public void setWeekZhaoShengShu(Integer weekZhaoShengShu) {
		this.weekZhaoShengShu = weekZhaoShengShu;
	}

	@Column(name="month_zhaoshengshu")
	public Integer getMonthZhaoShengShu() {
		return monthZhaoShengShu;
	}

	public void setMonthZhaoShengShu(Integer monthZhaoShengShu) {
		this.monthZhaoShengShu = monthZhaoShengShu;
	}

	@Column(name="year_zhaoshengshu")
	public Integer getYearZhaoShengShu() {
		return yearZhaoShengShu;
	}

	public void setYearZhaoShengShu(Integer yearZhaoShengShu) {
		this.yearZhaoShengShu = yearZhaoShengShu;
	}

	@Column(name="english_name")
	public String getEngLishName() {
		return engLishName;
	}

	public void setEngLishName(String engLishName) {
		this.engLishName = engLishName;
	}

	
	
	
}
