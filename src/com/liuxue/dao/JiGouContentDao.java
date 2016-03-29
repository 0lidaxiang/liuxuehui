package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.ZiXunJiGouContent;

/**
 * 机构内容的数据库操作库
 * @author 李成龙
 * @date 2015-06-03
 * 
 * */

@Repository
public class JiGouContentDao extends BaseDao<ZiXunJiGouContent>{
	
	//通过jiGouGuid查询
	public ZiXunJiGouContent getJiGouContentByJiGouGuid(String jiGouGuid){
		String hql = "from ZiXunJiGouContent z where z.jiGouGuid=?";
		List<ZiXunJiGouContent> list = (List<ZiXunJiGouContent>)getHibernateTemplate().find(hql,jiGouGuid);
		if(list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
	}
	
}
