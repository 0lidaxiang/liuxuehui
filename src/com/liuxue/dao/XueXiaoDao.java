package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.WenAn;
import com.liuxue.entity.XueXiao;

/**
 * 培训学校的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class XueXiaoDao extends BaseDao<XueXiao>{

	//分页
	//pageNo 页号,从1开始, int pageSize 每页记录数
	public Page page(int pageNo, int pageSize){
		String hql ="from XueXiao m order by m.pinJia desc";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	//查出首页选用
	public List<XueXiao> findIndexXueXiao(){
		String hql = "from XueXiao z where z.indexXyBj=1 order by z.indexWeiZhi";
		List<XueXiao> list = (List<XueXiao>)getHibernateTemplate().find(hql);
		return list;
	}
	
	
	
}
