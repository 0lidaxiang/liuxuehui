package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.MingShiContent;

/**
 * 名师内容的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class MingShiContentDao extends BaseDao<MingShiContent>{

	//通过mingShiGuid查询
	public MingShiContent findByMingShiGuid(String mingShiGuid){
		String hql = "from MingShiContent m where m.mingShiGuid=?";
		List<MingShiContent> list = (List<MingShiContent>)getHibernateTemplate().find(hql, mingShiGuid);
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	
	
	
}
