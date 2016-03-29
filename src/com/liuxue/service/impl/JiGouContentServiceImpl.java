package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.JiGouContentDao;
import com.liuxue.entity.ZiXunJiGouContent;
import com.liuxue.service.JiGouContentService;

@Service
public class JiGouContentServiceImpl implements JiGouContentService {
	
	@Autowired
	private JiGouContentDao jiGouContentDao;

	public void addJiGouContent(ZiXunJiGouContent ziXunJiGouContent) {
		jiGouContentDao.save(ziXunJiGouContent);
	}

	public ZiXunJiGouContent findByJiGouGuid(String jiGouGuid) {
		return jiGouContentDao.getJiGouContentByJiGouGuid(jiGouGuid);
	}

	public void deleteJiGouContent(ZiXunJiGouContent ziXunJiGouContent) {
		jiGouContentDao.remove(ziXunJiGouContent);
	}

	public void updateJiGouContent(ZiXunJiGouContent ziXunJiGouContent) {
		jiGouContentDao.update(ziXunJiGouContent);
	}

}
