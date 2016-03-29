package com.liuxue.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.UserDao;
import com.liuxue.entity.User;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;
	
	
	//创建用户
	public boolean createUser(User user){
		try{
		   userDao.createUser(user);
		}catch (Exception e) {
		   e.printStackTrace();
		   return false;
		}
		return true;
	}
	
	//通过手机号搜索
	public User findUserByPhone(String mobilePhone){
		return userDao.findUserByPhone(mobilePhone);
	}
	
	
	//更新
	public boolean updateUser(User user){
		try {
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			   return false;
		}
		return true;
	}

}
