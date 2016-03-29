package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.WenAnContentDao;
import com.liuxue.entity.WenAnContent;
import com.liuxue.service.WenAnContentService;

@Service
public class WenAnContentServiceImpl implements WenAnContentService{

	@Autowired
	private WenAnContentDao wenAnContentDao;
	
	public void addWenAnContent(WenAnContent wenAnContent) {
		wenAnContentDao.save(wenAnContent);
	}

	public WenAnContent findWenAnContentByWenAnGuid(String wenAnGuid) {
		return wenAnContentDao.findByWenAnGuid(wenAnGuid);
	}

	@Override
	public void deleteWenAnContent(WenAnContent wenAnContent) {
		wenAnContentDao.remove(wenAnContent);
	}

	@Override
	public void updateWenAnContent(WenAnContent wenAnContent) {
		wenAnContentDao.update(wenAnContent);
	}

}
