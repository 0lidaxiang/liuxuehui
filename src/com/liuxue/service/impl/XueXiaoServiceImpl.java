package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.Page;
import com.liuxue.dao.XueXiaoDao;
import com.liuxue.entity.XueXiao;
import com.liuxue.service.XueXiaoService;

@Service
public class XueXiaoServiceImpl implements XueXiaoService{

	@Autowired
	private XueXiaoDao xueXiaoDao;
	
	public void addXueXiao(XueXiao xueXiao) {
		xueXiaoDao.save(xueXiao);
	}

	public XueXiao getXueXiaoByGuid(String xueXiaoGuid) {
		return xueXiaoDao.get(xueXiaoGuid);
	}

	public Page page(int pageNo, int pageSize) {
		return xueXiaoDao.page(pageNo, pageSize);
	}

	public List<XueXiao> findIndexXueXiao() {
		return xueXiaoDao.findIndexXueXiao();
	}

	@Override
	public void deleteXueXiao(XueXiao xueXiao) {
		xueXiaoDao.remove(xueXiao);
	}

	@Override
	public void updateXueXiao(XueXiao xueXiao) {
		xueXiaoDao.update(xueXiao);
	}

}
