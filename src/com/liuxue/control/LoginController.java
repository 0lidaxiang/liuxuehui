package com.liuxue.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.liuxue.base.util.SpercialCharUtil;
import com.liuxue.entity.User;
import com.liuxue.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("userSession")
public class LoginController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/loginOrReg",method=RequestMethod.GET)
	public ModelAndView toLoginView(){
		ModelAndView view=new ModelAndView("loginOrReg");
		return view;
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> register(@RequestParam String mobilephone,@RequestParam String passwd,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			User user = userService.findUserByPhone(mobilephone);
			if (user!=null) {
				map.put("msg","mobile_cunzai");
			}else {
				String pwd = SpercialCharUtil.encodePW(passwd);
				user = new User();
				user.setMobilephone(mobilephone);
				user.setPasswd(pwd);
				boolean result=userService.createUser(user);
				if(result){
				   map.put("msg", "reg_sucess");
				   request.getSession().setAttribute("userSession",user);
				}
			}
		} catch (Exception e) {
			map.put("msg","system_error");
		}
		return map;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(HttpSession session,HttpServletRequest request,ModelMap model){
		Map<String,Object> resultmap = new HashMap<String, Object>();
		String mobilePhone=request.getParameter("mobilephone");
		String passwd=request.getParameter("passwd");
		String pwd= SpercialCharUtil.encodePW(passwd);//加密
		User user=userService.findUserByPhone(mobilePhone);
		if(user==null)
			resultmap.put("msg", "mobile_error");
		else{
			if(user.getPasswd().equals(pwd)&&user.getName()!=null){
				resultmap.put("msg", "success");
				model.addAttribute("userSession", user);
			}else if(user.getPasswd().equals(pwd)&&user.getName()==null){
				resultmap.put("msg", "success_to_user");
		        model.addAttribute("userSession", user);
			}else{
				resultmap.put("msg", "pwd_error");
			}
		}
		return resultmap;
	}
}
