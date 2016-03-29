package com.liuxue.service;

import com.liuxue.entity.AdminUser;

/**
 * 管理账号的服务层
 * @author 李成龙
 * @date 2015-6-4
 * 
 * */
public interface AdminUserService {

	//通过帐号名获取帐号
	public AdminUser getAdminUserByAccount (String accountName);
}
