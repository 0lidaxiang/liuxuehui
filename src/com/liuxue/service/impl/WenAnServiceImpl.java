package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.Page;
import com.liuxue.dao.WenAnDao;
import com.liuxue.entity.WenAn;
import com.liuxue.service.WenAnService;

@Service
public class WenAnServiceImpl implements WenAnService{

	@Autowired
	private WenAnDao wenAnDao;
	
	public void addWenAn(WenAn wenAn) {
		wenAnDao.save(wenAn);
	}

	public WenAn getWenAnByGuid(String wenAnGuid) {
		return wenAnDao.get(wenAnGuid);
	}

	public Page page(int pageNo, int pageSize) {
		return wenAnDao.page(pageNo, pageSize);
	}

	public List<WenAn> findIndexWenAn() {
		return wenAnDao.findIndexWenAn();
	}

	@Override
	public void deleteWenAn(WenAn wenAn) {
		wenAnDao.remove(wenAn);
	}

	@Override
	public void updateWenAn(WenAn wenAn) {
		wenAnDao.update(wenAn);
	}

}
