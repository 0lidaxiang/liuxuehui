package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.MingShi;

/**
 * 名师的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class MingShiDao extends BaseDao<MingShi>{

	//分页
	//pageNo 页号,从1开始, int pageSize 每页记录数
	public Page page(int pageNo, int pageSize){
		String hql ="from MingShi m order by m.xinJiPingJia desc";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	//查出首页选用
	public List<MingShi> findIndexMingShi(){
		String hql = "from MingShi z where z.indexXyBj=1 order by z.indexWeiZhi";
		List<MingShi> list = (List<MingShi>)getHibernateTemplate().find(hql);
		return list;
	}
	
	
	
}
