package com.liuxue.service;

import com.liuxue.dao.Page;
import com.liuxue.entity.WenAn;
import com.liuxue.entity.XueXiao;

/**
 * 学校服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface XueXiaoService {

	//添加
	public void addXueXiao(XueXiao xueXiao);
	
	//分页
	public Page page(int pageNo,int pageSize);
	
	//通过主键guid获取
	public XueXiao getXueXiaoByGuid(String xueXiaoGuid);
	
	//查询到主页选用的
	public List<XueXiao> findIndexXueXiao();
	
	//更新 
	 public void updateXueXiao(XueXiao xueXiao);
	 
	 //删除
	 public void deleteXueXiao(XueXiao xueXiao);
	
}
