package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.MingShiContentDao;
import com.liuxue.entity.MingShiContent;
import com.liuxue.service.MingShiContentService;

@Service
public class MingShiContentServiceImpl implements MingShiContentService{

	@Autowired
	private MingShiContentDao mingShiContentDao;
	
	public void addMingShiContent(MingShiContent mingShiContent) {
		mingShiContentDao.save(mingShiContent);
	}

	public MingShiContent findMingShiContentByMingShiGuid(String mingShiGuid) {
		return mingShiContentDao.findByMingShiGuid(mingShiGuid);
	}

	public void deleteMingShiContent(MingShiContent mingShiContent) {
		mingShiContentDao.remove(mingShiContent);
	}

	public void updateMingShiContent(MingShiContent mingShiContent) {
		mingShiContentDao.update(mingShiContent);
	}

	
}
