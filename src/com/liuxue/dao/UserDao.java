package com.liuxue.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.testng.guice.internal.Preconditions;

import com.liuxue.entity.User;

/**
 * 用户的数据库操作
 * */
@Repository
public class UserDao extends BaseDao<User>{
	
	//创建用户
	public void createUser(User user) throws Exception{
		Preconditions.checkNotNull(user);
		save(user);
	}
	
	//通过手机号码查询用户
	public User findUserByPhone(String mobilePhone){
		String hql="from User where mobilephone=?";
		List<User> userList = (List<User>)getHibernateTemplate().find(hql,mobilePhone);
		if (userList.size()>0) {
			return userList.get(0);
		}else {
			return null;
		}
	}
}
