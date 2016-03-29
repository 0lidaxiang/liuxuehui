package com.liuxue.service;

import com.liuxue.dao.Page;
import com.liuxue.entity.GuWen;

/**
 * 顾问服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface GuWenService {

	//添加
	public void addGuWen(GuWen guWen);
	
	//分页
	public Page page(int pageNo,int pageSize);
	
	//通过主键guid获取
	public GuWen getGuWenByGuid(String guWenGuid);
	
	//查询到主页选用的
	public List<GuWen> findIndexGuWen();
	
	//更新顾问
	 public void updateguWen(GuWen guWen);
	 
	 //删除
	 public void deleteGuWen(GuWen guWen);
	 
}
