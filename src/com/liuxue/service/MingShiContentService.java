package com.liuxue.service;

import com.liuxue.entity.MingShiContent;

/**
 * 名师内容的服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface MingShiContentService {

	//添加
	public void addMingShiContent(MingShiContent mingShiContent);
	
	//通过mingShiGuid查询
	public MingShiContent findMingShiContentByMingShiGuid(String mingShiGuid);
	
	//更新
	public void updateMingShiContent(MingShiContent mingShiContent);
	
	//删除
	public void deleteMingShiContent(MingShiContent mingShiContent);
	
}
