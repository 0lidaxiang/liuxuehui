package com.liuxue.service;

import com.liuxue.dao.Page;
import com.liuxue.entity.ZiXunJiGou;

/**
 * 机构服务层
 * @author 李成龙
 * @date 2015-6-3
 * 
 * */


public interface JiGouService {
	
	//添加
	public void addJiGou(ZiXunJiGou ziXunJiGou);
	
	//分页
	public Page page(int pageNo,int pageSize);

	//通过主键guid获取
	public ZiXunJiGou getJiGouByGuid(String jiGouGuid);
	
	//查询到主页选用的
	public List<ZiXunJiGou> findIndexZiXunJiGou();
	
	//更新
	public void updateJiGou(ZiXunJiGou ziXunJiGou);
	
	//删除
	public void deleteJiGou(ZiXunJiGou ziXunJiGou);
	
}
