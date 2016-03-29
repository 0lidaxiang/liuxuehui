package com.liuxue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.OnlineTestDao;
import com.liuxue.dao.Page;
import com.liuxue.entity.OnlineTest;

/**
 * 在线测评服务
 * 
 * @author 王闯
 * 
 */
@Service
public class OnlineTestService {
	@Autowired
	private OnlineTestDao onlineTestDao;

	public boolean createOnlineTest(OnlineTest test) {
		try {
			onlineTestDao.createOnlineTest(test);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//分页
	public Page page(int pageNo,int pageSize){
		return onlineTestDao.page(pageNo, pageSize);
	}
	
	public OnlineTest getOnlineTestByGuid(String onlineTestGuid){
		return onlineTestDao.get(onlineTestGuid);
	}
	
	
	//跟新
	public void updateOnlineTest(OnlineTest onlineTest){
		onlineTestDao.update(onlineTest);
	}
}
