package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.MingShiDao;
import com.liuxue.dao.Page;
import com.liuxue.entity.MingShi;
import com.liuxue.service.MingShiService;

@Service
public class MingShiServiceImpl implements MingShiService{

	@Autowired
	private MingShiDao mingShiDao;
	
	public void addMingShi(MingShi mingShi) {
		mingShiDao.save(mingShi);
	}

	public MingShi getMingShiByGuid(String mingShiGuid) {
		return mingShiDao.get(mingShiGuid);
	}

	public Page page(int pageNo, int pageSize) {
		return mingShiDao.page(pageNo, pageSize);
	}

	public List<MingShi> findIndexMingShi() {
		return mingShiDao.findIndexMingShi();
	}

	public void deleteMingShi(MingShi mingShi) {
		mingShiDao.remove(mingShi);
	}

	public void updateMingShi(MingShi mingShi) {
		mingShiDao.update(mingShi);
	}

}
