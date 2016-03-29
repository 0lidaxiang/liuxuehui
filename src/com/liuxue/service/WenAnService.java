package com.liuxue.service;

import com.liuxue.dao.Page;
import com.liuxue.entity.WenAn;

/**
 * 文案服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface WenAnService {
	
	//添加
	public void addWenAn(WenAn wenAn);
	
	//分页
	public Page page(int pageNo,int pageSize);
	
	//通过主键guid获取
	public WenAn getWenAnByGuid(String wenAnGuid);
	
	//查询到主页选用的
	public List<WenAn> findIndexWenAn();
	
	//更新 
	 public void updateWenAn(WenAn wenAn);
	 
	 //删除
	 public void deleteWenAn(WenAn wenAn);
}
