package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.AdminUserDao;
import com.liuxue.entity.AdminUser;
import com.liuxue.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{
	
	@Autowired
	private AdminUserDao adminUserDao;

	public AdminUser getAdminUserByAccount(String accountName) {
		return adminUserDao.findAdminAccountByAccountName(accountName);
	}

}
