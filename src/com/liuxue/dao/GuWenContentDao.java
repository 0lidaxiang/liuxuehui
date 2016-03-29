package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.GuWenContent;

/**
 * 顾问内容的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class GuWenContentDao extends BaseDao<GuWenContent>{

	//通过guWenGuid查询
	public GuWenContent findByGuWenGuid(String guWenGuid){
		String hql = "from GuWenContent z where z.guWenGuid=?";
		List<GuWenContent> list = (List<GuWenContent>)getHibernateTemplate().find(hql, guWenGuid);
		if (list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}
	}
}
