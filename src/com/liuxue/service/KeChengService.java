package com.liuxue.service;

import com.liuxue.dao.Page;
import com.liuxue.entity.KeCheng;

/**
 * 课程服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface KeChengService{

	//添加
	public void addKeCheng(KeCheng keCheng);
	
	//分页
	public Page page(int pageNo,int pageSize);
	
	//通过guid查询
	public KeCheng findKeChengByGuid(String keChengGuid);
	
	//查询到主页选用的
	public List<KeCheng> findIndexKeCheng();
	
	//更新
	public void updateKeCheng(KeCheng keCheng);
	
	//删除
	public void deleteKeCheng(KeCheng keCheng);
	
	
}
