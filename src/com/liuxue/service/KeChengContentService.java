package com.liuxue.service;

import com.liuxue.entity.KeChengContent;

/**
 * 课程内容的服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface KeChengContentService {

	//添加
	public void addKeChengContent(KeChengContent keChengContent);
	
	//通过keChengGuid查询
	public KeChengContent findKeChengContentByKeChengGuid(String keChengGuid);
	
	//更新
	public void updateKeChengContent(KeChengContent keChengContent);
	
	//删除
	public void deleteKeChengContent(KeChengContent keChengContent);
	
}
