package com.liuxue.service;

import org.hibernate.sql.Update;

import com.liuxue.entity.GuWenContent;

/**
 * 顾问内容的服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface GuWenContentService {

	//添加
	public void addGuWenContent(GuWenContent guWenContent);
	
	//通过guwenGuid查询
	public GuWenContent findGuWenCOntentByGuWenGuid(String guWenGuid);
	
	//更新
	public void updateGuWenContent(GuWenContent guWenContent);
	
	//删除
	public void deleteGuWenContent(GuWenContent guWenContent);
	
}