package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.GuWenDao;
import com.liuxue.dao.Page;
import com.liuxue.entity.GuWen;
import com.liuxue.service.GuWenService;

@Service
public class GuWenServiceImpl implements GuWenService{

	@Autowired
	private GuWenDao guWenDao;
	
	public void addGuWen(GuWen guWen) {
		guWenDao.save(guWen);
	}

	public GuWen getGuWenByGuid(String guWenGuid) {
		return guWenDao.get(guWenGuid);
	}

	public Page page(int pageNo, int pageSize) {
		return guWenDao.page(pageNo, pageSize);
	}

	public List<GuWen> findIndexGuWen() {
		return guWenDao.findIndexGuWenList();
	}

	public void updateguWen(GuWen guWen) {
		guWenDao.update(guWen);
	}

	public void deleteGuWen(GuWen guWen) {
		guWenDao.remove(guWen);
	}


}
