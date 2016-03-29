package com.liuxue.service;

import com.liuxue.entity.ZiXunJiGouContent;

/**
 * 机构内容的服务层
 * @author 李成龙
 * @date 2015-6-3
 * 
 * */

public interface JiGouContentService {

	//添加
	public void addJiGouContent(ZiXunJiGouContent ziXunJiGouContent);

	//通过jiGouGuid查询
	public ZiXunJiGouContent findByJiGouGuid(String jiGouGuid);
	
	//更新
	public void updateJiGouContent(ZiXunJiGouContent ziXunJiGouContent);
	
	//删除
	public void deleteJiGouContent(ZiXunJiGouContent ziXunJiGouContent);
	
}
