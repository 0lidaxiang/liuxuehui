package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.KeCheng;

/**
 * 课程的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class KeChengDao extends BaseDao<KeCheng>{
	
	//分页
	//pageNo 页号,从1开始, int pageSize 每页记录数
	public Page page(int pageNo, int pageSize){
		String hql ="from KeCheng m order by m.tuiJianZhiShu desc";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	//查出首页选用
	public List<KeCheng> findIndexKeCheng(){
		String hql = "from KeCheng z where z.indexXyBj=1 order by z.indexWeiZhi";
		List<KeCheng> list = (List<KeCheng>)getHibernateTemplate().find(hql);
		return list;
	}

}
