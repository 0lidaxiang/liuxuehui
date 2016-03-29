package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.KeChengContent;

/**
 * 课程内容的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class KeChengContentDao extends BaseDao<KeChengContent>{

	//通过keChengGuid查询
	public KeChengContent findByKeChengGuid(String keChengGuid){
		String hql = "from KeChengContent k where k.keChengGuid=?";
		List<KeChengContent> list = (List<KeChengContent>)getHibernateTemplate().find(hql, keChengGuid);
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
}
