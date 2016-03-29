package com.liuxue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.liuxue.base.entity.BaseEntity;
/**
 * 顾问基础表
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */

@Entity
@Table(name = "t_guwen")
public class GuWen extends BaseEntity{

	/**
	 * @Fields serialVersionUID : 序列标识
	 */
	
	private static final long serialVersionUID = -123454323457834536L;
	
	private String name;//姓名
	
	private String shenFen;//身份
	
	private String ruHangShiJian;//入行时间 eg：2014-11
	
	private String shanChangGuoJia;//擅长国家
	
	private String ziXunXingShi;//咨询形式
	
	private String shanChangZuanYe;//擅长专业
	
	private String zhiYeXinTiao;//职业信条
	
	private String xueYuanPinJia;//学员评价
	
	private Integer xinJiPingJia;//星级评价  几颗星
	
	private Integer renQi;//人气 点击量
	
	private String photoName;//列表图片名称
	
	private Integer weekQianDanLiang;//周签单量
	
	private Integer monthQianDanLiang;//月签单量
	
	private Integer yearQianDanLiang;//年签单量
	
	private Integer indexXyBj;//首页选用标记 1标示选用 0标示未选用
	
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

	@Column(name="shenfen")
	public String getShenFen() {
		return shenFen;
	}

	public void setShenFen(String shenFen) {
		this.shenFen = shenFen;
	}

	@Column(name="ruhangshijian")
	public String getRuHangShiJian() {
		return ruHangShiJian;
	}

	public void setRuHangShiJian(String ruHangShiJian) {
		this.ruHangShiJian = ruHangShiJian;
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

	@Column(name="shanchangzhuanye")
	public String getShanChangZuanYe() {
		return shanChangZuanYe;
	}

	public void setShanChangZuanYe(String shanChangZuanYe) {
		this.shanChangZuanYe = shanChangZuanYe;
	}

	@Column(name="zhiyexintiao")
	public String getZhiYeXinTiao() {
		return zhiYeXinTiao;
	}

	public void setZhiYeXinTiao(String zhiYeXinTiao) {
		this.zhiYeXinTiao = zhiYeXinTiao;
	}

	@Column(name="xueyuanpinjia")
	public String getXueYuanPinJia() {
		return xueYuanPinJia;
	}

	public void setXueYuanPinJia(String xueYuanPinJia) {
		this.xueYuanPinJia = xueYuanPinJia;
	}

	@Column(name="xinjipingjia")
	public Integer getXinJiPingJia() {
		return xinJiPingJia;
	}

	public void setXinJiPingJia(Integer xinJiPingJia) {
		this.xinJiPingJia = xinJiPingJia;
	}

	@Column(name="renqi")
	public Integer getRenQi() {
		return renQi;
	}

	public void setRenQi(Integer renQi) {
		this.renQi = renQi;
	}

	@Column(name="photoname")
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	@Column(name="week_qiandanliang")
	public Integer getWeekQianDanLiang() {
		return weekQianDanLiang;
	}

	public void setWeekQianDanLiang(Integer weekQianDanLiang) {
		this.weekQianDanLiang = weekQianDanLiang;
	}

	@Column(name="month_qiandanliang")
	public Integer getMonthQianDanLiang() {
		return monthQianDanLiang;
	}

	public void setMonthQianDanLiang(Integer monthQianDanLiang) {
		this.monthQianDanLiang = monthQianDanLiang;
	}

	@Column(name="year_qiandanliang")
	public Integer getYearQianDanLiang() {
		return yearQianDanLiang;
	}

	public void setYearQianDanLiang(Integer yearQianDanLiang) {
		this.yearQianDanLiang = yearQianDanLiang;
	}

	
	

	
	
}
