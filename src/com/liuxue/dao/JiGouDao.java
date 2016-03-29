package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.ZiXunJiGou;

/**
 * 机构的数据库操作库
 * @author 李成龙
 * @date 2015-06-03
 * 
 * */

@Repository
public class JiGouDao extends BaseDao<ZiXunJiGou>{
	
	//分页
	//pageNo 页号,从1开始, int pageSize 每页记录数
	public Page page(int pageNo, int pageSize){
		String hql ="from ZiXunJiGou m order by m.pingJia desc";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	//查出首页选用
	public List<ZiXunJiGou> findIndexZiXuJiGou(){
		String hql = "from ZiXunJiGou z where z.indexXyBj=1 order by z.indexWeiZhi";
		List<ZiXunJiGou> list = (List<ZiXunJiGou>)getHibernateTemplate().find(hql);
		return list;
	}
	
	
	
	
	
	
	
	
}
