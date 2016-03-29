package com.liuxue.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuxue.base.util.SpercialCharUtil;
import com.liuxue.entity.AdminUser;
import com.liuxue.service.AdminUserService;
/**
 * 管理员登录控制器
 * @author 李成龙
 * @date 2015-06-04
 */
@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController{
	
	@Autowired
	private AdminUserService adminUserService;
	
	@RequestMapping(value="/adminLogin")
	@ResponseBody
	public Object adminLoginCheck(@RequestParam String account,@RequestParam String pwd,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			AdminUser adminUser = adminUserService.getAdminUserByAccount(account);//从数据库查询账号
			if (adminUser==null) {
				map.put("msg", "account");
			}else {
				String pwdDB = adminUser.getPassWord();//数据库获取的密码
				String passwordJiaMi = SpercialCharUtil.encodePW(pwd);
				if (passwordJiaMi.equals(pwdDB)) {
					map.put("msg", "success");
					request.getSession().setAttribute("adminUserSession",adminUser);
				} else {
					map.put("msg", "password");
				}
			}
		} catch (Exception e) {
			map.put("msg","系统出现异常，请稍后再试！");
		}
		
		return map;
	}
	
}
