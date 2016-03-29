package com.liuxue.dao;

import org.springframework.stereotype.Repository;
import org.testng.guice.internal.Preconditions;

import com.liuxue.entity.OnlineTest;

/**
 * 在线测评的数据库操作库
 * 
 * @author 王闯
 * @date 2015-06-06
 * 
 * */

@Repository
public class OnlineTestDao extends BaseDao<OnlineTest> {

	// 创建
	public void createOnlineTest(OnlineTest test) throws Exception {
		Preconditions.checkNotNull(test);
		save(test);
	}
	
	//分页
	//pageNo 页号,从1开始, int pageSize 每页记录数
	public Page page(int pageNo, int pageSize){
		String hql ="from OnlineTest m order by m.luRuTime desc";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
}
