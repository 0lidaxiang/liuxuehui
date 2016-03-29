package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.XueXiaoContentDao;
import com.liuxue.entity.XueXiaoContent;
import com.liuxue.service.XueXiaoContentService;

@Service
public class XueXiaoContentServiceImpl implements XueXiaoContentService{

	@Autowired
	private XueXiaoContentDao xueXiaoContentDao;
	
	public void addXueXiaoContent(XueXiaoContent xueXiaoContent) {
		xueXiaoContentDao.save(xueXiaoContent);
	}

	public XueXiaoContent findXueXiaoCotentByXueXiaoGuid(String xueXiaoGuid) {
		return xueXiaoContentDao.findByXueXiaoGuid(xueXiaoGuid);
	}

	@Override
	public void deleteXueXiaoContent(XueXiaoContent xueXiaoContent) {
		xueXiaoContentDao.remove(xueXiaoContent);
	}

	@Override
	public void updateXueXiaoContent(XueXiaoContent xueXiaoContent) {
		xueXiaoContentDao.update(xueXiaoContent);
	}

}
