package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 课程基础表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_kecheng")
public class KeCheng extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -132112343412834536L;
	
	private String name;//课程名称
	
	private String jianjie;//课程简介
	
	private Date beginTime;//开始时间
	
	private Date endTime;//结束时间
	
	private String photoName;//列表图片名称
	
	private Integer tuiJianZhiShu;//推荐指数，用于排序所用，1-5颗星
	
	
	private Integer indexXyBj;//首页选用标记
	
	private String indexPhotoName;//放在首页时用到的图片
	
	private Integer indexWeiZhi;//放在首页的位置（为了顺序而存在）
	
	private Integer baoMingRenShu;//报名人数
	
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

	@Column(name="begin_time")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name="end_time")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="photo_name")
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	@Column(name="tuijianzhishu")
	public Integer getTuiJianZhiShu() {
		return tuiJianZhiShu;
	}

	public void setTuiJianZhiShu(Integer tuiJianZhiShu) {
		this.tuiJianZhiShu = tuiJianZhiShu;
	}

	public Integer getBaoMingRenShu() {
		return baoMingRenShu;
	}

	public void setBaoMingRenShu(Integer baoMingRenShu) {
		this.baoMingRenShu = baoMingRenShu;
	}
	
	
	
}
