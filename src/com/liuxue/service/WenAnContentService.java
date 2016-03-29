package com.liuxue.service;

import com.liuxue.entity.WenAnContent;

/**
 * 文案内容的服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface WenAnContentService {

	//添加
	public void addWenAnContent(WenAnContent wenAnContent);
	
	//通过wenAnGuid查询
	public WenAnContent findWenAnContentByWenAnGuid(String wenAnGuid);
	
	//更新
	public void updateWenAnContent(WenAnContent wenAnContent);
	
	//删除
	public void deleteWenAnContent(WenAnContent wenAnContent);
	
	
}
