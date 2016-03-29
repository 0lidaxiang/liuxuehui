package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.JiGouDao;
import com.liuxue.dao.Page;
import com.liuxue.entity.ZiXunJiGou;
import com.liuxue.service.JiGouService;

@Service
public class JiGouServiceImpl implements JiGouService{
	
	@Autowired
	private JiGouDao jiGouDao;

	public void addJiGou(ZiXunJiGou ziXunJiGou) {
		jiGouDao.save(ziXunJiGou);
	}

	public Page page(int pageNo, int pageSize) {
		return jiGouDao.page(pageNo, pageSize);
	}

	public ZiXunJiGou getJiGouByGuid(String jiGouGuid) {
		return jiGouDao.get(jiGouGuid);
	}

	public List<ZiXunJiGou> findIndexZiXunJiGou() {
		return jiGouDao.findIndexZiXuJiGou();
	}

	public void deleteJiGou(ZiXunJiGou ziXunJiGou) {
		jiGouDao.remove(ziXunJiGou);
	}

	public void updateJiGou(ZiXunJiGou ziXunJiGou) {
		jiGouDao.update(ziXunJiGou);
	}

}
