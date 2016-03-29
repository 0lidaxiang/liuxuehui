package com.liuxue.service;

import com.liuxue.entity.XueXiaoContent;

/**
 * 学校内容的服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface XueXiaoContentService {

	//添加
	public void addXueXiaoContent(XueXiaoContent xueXiaoContent);
	
	//通过xueXiaoGuid查询
	public XueXiaoContent findXueXiaoCotentByXueXiaoGuid(String xueXiaoGuid);
	
	//更新
	public void updateXueXiaoContent(XueXiaoContent xueXiaoContent);
	
	//删除
	public void deleteXueXiaoContent(XueXiaoContent xueXiaoContent);
}
