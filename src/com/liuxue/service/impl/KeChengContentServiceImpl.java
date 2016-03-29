package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.KeChengContentDao;
import com.liuxue.entity.KeChengContent;
import com.liuxue.service.KeChengContentService;

@Service
public class KeChengContentServiceImpl implements KeChengContentService{

	@Autowired
	private KeChengContentDao keChengContentDao;
	
	public void addKeChengContent(KeChengContent keChengContent) {
		keChengContentDao.save(keChengContent);
	}

	public KeChengContent findKeChengContentByKeChengGuid(String keChengGuid) {
		return keChengContentDao.findByKeChengGuid(keChengGuid);
	}

	public void deleteKeChengContent(KeChengContent keChengContent) {
		keChengContentDao.remove(keChengContent);
	}

	public void updateKeChengContent(KeChengContent keChengContent) {
		keChengContentDao.update(keChengContent);
	}

}
