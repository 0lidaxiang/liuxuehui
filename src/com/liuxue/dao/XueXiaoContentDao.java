package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.XueXiaoContent;

/**
 * 培训学校内容的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class XueXiaoContentDao extends BaseDao<XueXiaoContent>{

	//通过xueXiaoGuid查询
	public XueXiaoContent findByXueXiaoGuid(String xueXiaoGuid){
		String hql = "from XueXiaoContent x where x.xueXiaoGuid=?";
		List<XueXiaoContent> list = (List<XueXiaoContent>)getHibernateTemplate().find(hql,xueXiaoGuid);
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
}
