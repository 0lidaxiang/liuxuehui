package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.KeChengDao;
import com.liuxue.dao.Page;
import com.liuxue.entity.KeCheng;
import com.liuxue.service.KeChengService;

@Service
public class KeChengServiceImpl implements KeChengService{

	@Autowired
	private KeChengDao keChengDao;
	
	public void addKeCheng(KeCheng keCheng) {
		keChengDao.save(keCheng);
	}

	public KeCheng findKeChengByGuid(String keChengGuid) {
		return keChengDao.get(keChengGuid);
	}

	public Page page(int pageNo, int pageSize) {
		return keChengDao.page(pageNo, pageSize);
	}

	public List<KeCheng> findIndexKeCheng() {
		return keChengDao.findIndexKeCheng();
	}

	public void deleteKeCheng(KeCheng keCheng) {
		keChengDao.remove(keCheng);
	}

	public void updateKeCheng(KeCheng keCheng) {
		keChengDao.update(keCheng);
	}

}
