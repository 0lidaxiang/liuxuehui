package com.liuxue.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.liuxue.base.Constants;
import com.liuxue.base.util.SpercialCharUtil;
import com.liuxue.entity.User;
import com.liuxue.service.UserService;

@Controller
@RequestMapping("/member")
@SessionAttributes("userSession")
public class MemberController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userinfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateUserInfo(HttpServletRequest request,@ModelAttribute("userSession") User user) throws UnsupportedEncodingException{
		Map<String,Object> resultmap=new HashMap<String, Object>();
		String email=request.getParameter("inputEmail");
	    String inputQQ=request.getParameter("inputQQ");
	    String inputWeiXin=request.getParameter("inputWeiXin");
	    String inputUserName=URLDecoder.decode(request.getParameter("inputUserName"),"utf-8");
	    String xingBie=request.getParameter("xingBie");
	    int age=Integer.parseInt(request.getParameter("inputNianLing"));
	    String school=URLDecoder.decode(request.getParameter("inputXueXiao"),"utf-8");
	    String major=URLDecoder.decode(request.getParameter("inputZhuanYe"),"utf-8");
	    user.setEmail(email);
	    user.setAge(age);
	    user.setMajor(major);
	    user.setName(inputUserName);
	    user.setQq(inputQQ);
	    user.setWeixin(inputWeiXin);
	    if(xingBie.equals("man"))
	        user.setSex(0);
	    else
	    	user.setSex(1);
	    user.setSchool(school);
	    boolean result= userService.createUser(user);
	    if(result){
	    	resultmap.put("msg", "success");
	    }else{
	    	resultmap.put("msg","error");
	    }
		return resultmap;
	}
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	public ModelAndView toUserView(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		User user = (User)request.getSession().getAttribute("userSession");
		try {
			if(user==null){
				mav.setViewName("redirect:/view/loginOrReg.jsp");
			}else{
				mav.setViewName("forward:/view/user.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("redirect:/view/fail.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/updateUserInfo",method=RequestMethod.POST)
	public ModelAndView updateUserInfo(@RequestParam("touxiang")MultipartFile touxiang,
			@RequestParam("mobilephone")String mobilephone,
			@RequestParam("email")String email,@RequestParam("qq")String qq,
			@RequestParam("weixin")String weixin,@RequestParam("name")String name,
			@RequestParam("sex")String sex,@RequestParam("age")String age,
			@RequestParam("school")String school,@RequestParam("major")String major,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		User user = (User)request.getSession().getAttribute("userSession");
		try {
			if (user==null) {
				mav.setViewName("forward:/view/loginOrReg.jsp");
			}else{
				int age_int = 0;
				if (!age.equals("")) {
					String regEx="[^0-9]";   
					Pattern p = Pattern.compile(regEx);   
					Matcher m = p.matcher(age); 
					if(m.replaceAll("").trim()!=""){
						age_int = Integer.parseInt(m.replaceAll("").trim());
					}
				}
				int sex_int = 0;
				if (sex.equals("woman")) {
					sex_int=1;
				}
				user.setAge(age_int);
				user.setEmail(email);
				user.setMajor(major);
				user.setMobilephone(mobilephone);
				user.setName(name);
				user.setQq(qq);
				user.setSchool(school);
				user.setSex(sex_int);
				user.setWeixin(weixin);
				if(!touxiang.isEmpty()){
					File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.userTouXiangImagePath+touxiang.isEmpty());
					f2.delete();
					
					String newImageName = SpercialCharUtil.suiJiImageName(touxiang.getOriginalFilename());// 生成随机图片名称，防止重复
					user.setTouxiang(newImageName);
					touxiang.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.userTouXiangImagePath+newImageName));//保存首页图片图片
				}
				userService.updateUser(user);
				mav.addObject("msg", "修改成功");
				mav.setViewName("forward:/view/user.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("redirect:/view/fail.jsp");
		}
		return mav;
		
	}
	
	
	
}
