package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.WenAnContent;

/**
 * 文案内容的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class WenAnContentDao extends BaseDao<WenAnContent>{

	//通过wenAnGuid查询
	public WenAnContent findByWenAnGuid(String wenAnGuid){
		String hql = "from WenAnContent w where w.wenAnGuid=?";
		List<WenAnContent> list = (List<WenAnContent>)getHibernateTemplate().find(hql,wenAnGuid);	
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
}
