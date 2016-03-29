package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;

/**
 * 学生基础表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_student")
public class Student extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -145612343457834536L;
	
	private String name;//姓名
	
	private String chengJi;//成绩 eg：雅思9分
	
	private String offer;//收到的offer学校名称
	
	private String jinRuXueXiao;//入读的学校
	
	private Integer jinRuXueXiaoPingJi;//进入的留学学校评级分数  1-10打分，用于学生列表中的排序
	
	private String photoName;//列表图片
	
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

	@Column(name="chengji")
	public String getChengJi() {
		return chengJi;
	}

	public void setChengJi(String chengJi) {
		this.chengJi = chengJi;
	}

	@Column(name="offer")
	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	@Column(name="jinruxuexiao")
	public String getJinRuXueXiao() {
		return jinRuXueXiao;
	}

	public void setJinRuXueXiao(String jinRuXueXiao) {
		this.jinRuXueXiao = jinRuXueXiao;
	}

	@Column(name="photoname")
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	@Column(name="jinruxuexiaopingji")
	public Integer getJinRuXueXiaoPingJi() {
		return jinRuXueXiaoPingJi;
	}

	public void setJinRuXueXiaoPingJi(Integer jinRuXueXiaoPingJi) {
		this.jinRuXueXiaoPingJi = jinRuXueXiaoPingJi;
	}
	
	
}
