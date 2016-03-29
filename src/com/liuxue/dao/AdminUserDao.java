package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.AdminUser;

/**
 * 后台管理账号的数据库操作库
 * @author 李成龙
 * @date 2015-06-04
 * 
 * */

@Repository
public class AdminUserDao extends BaseDao<AdminUser>{
	
	//根据账号查询
	public AdminUser findAdminAccountByAccountName(String accountName){
		String hql="from AdminUser a where a.adminUserName =?";
		List<AdminUser> list = (List<AdminUser>)getHibernateTemplate().find(hql, accountName);
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
		
	}
	
}
