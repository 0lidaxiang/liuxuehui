package com.liuxue.service;

import com.liuxue.dao.Page;
import com.liuxue.entity.MingShi;

/**
 * 培训名师服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface MingShiService {

	//添加
	public void addMingShi(MingShi mingShi);
	
	//分页
	public Page page(int pageNo,int pageSize);
	
	//通过主键guid获取
	public MingShi getMingShiByGuid(String mingShiGuid);
	
	//查询到主页选用的
	public List<MingShi> findIndexMingShi();
	
	//更新 
	 public void updateMingShi(MingShi mingShi);
	 
	 //删除
	 public void deleteMingShi(MingShi mingShi);
	
}
