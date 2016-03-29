package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.GuWenContentDao;
import com.liuxue.entity.GuWenContent;
import com.liuxue.service.GuWenContentService;

@Service
public class GuWenContentServiceImpl implements GuWenContentService{

	@Autowired
	private GuWenContentDao guWenContentDao;
	
	public void addGuWenContent(GuWenContent guWenContent) {
		guWenContentDao.save(guWenContent);
	}

	public GuWenContent findGuWenCOntentByGuWenGuid(String guWenGuid) {
		return guWenContentDao.findByGuWenGuid(guWenGuid);
	}

	public void updateGuWenContent(GuWenContent guWenContent) {
		guWenContentDao.update(guWenContent);
	}

	public void deleteGuWenContent(GuWenContent guWenContent) {
		guWenContentDao.remove(guWenContent);
	}

}
