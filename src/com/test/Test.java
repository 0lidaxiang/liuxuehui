package com.test;

import com.liuxue.entity.User;
import com.liuxue.service.UserService;


public class Test {
	public static void main(){
		User user = new User();
		UserService us = new UserService();
		us.createUser(user);
	}
}
