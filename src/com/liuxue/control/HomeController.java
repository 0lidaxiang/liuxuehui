package com.liuxue.control;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liuxue.entity.AdminUser;
import com.liuxue.entity.GuWen;
import com.liuxue.entity.KeCheng;
import com.liuxue.entity.MingShi;
import com.liuxue.entity.Student;
import com.liuxue.entity.WenAn;
import com.liuxue.entity.XueXiao;
import com.liuxue.entity.ZiXunJiGou;
import com.liuxue.service.GuWenService;
import com.liuxue.service.JiGouService;
import com.liuxue.service.KeChengService;
import com.liuxue.service.MingShiService;
import com.liuxue.service.StudentService;
import com.liuxue.service.WenAnService;
import com.liuxue.service.XueXiaoService;

@Controller
@RequestMapping(value="/home")
public class HomeController extends BaseController{
	
	@Autowired
	private JiGouService jiGouService;
	
	@Autowired
	private GuWenService guWenService;
	
	@Autowired
	private WenAnService wenAnService;
	
	@Autowired
	private XueXiaoService xueXiaoService;
	
	@Autowired
	private MingShiService mingShiService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private KeChengService keChengService;
	
	//后台管理员登陆
	@RequestMapping(value="/goHome")
	public ModelAndView goIndex(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			List<ZiXunJiGou> ziXunJiGouIndexList = jiGouService.findIndexZiXunJiGou();
			List<GuWen> guWenIndexList = guWenService.findIndexGuWen();
			List<WenAn> wenAnIndexList = wenAnService.findIndexWenAn();
			List<XueXiao> xueXiaoIndexList = xueXiaoService.findIndexXueXiao();
			List<MingShi> mingShiIndexList = mingShiService.findIndexMingShi();
			List<Student> studentIndexList = studentService.findIndexStudent();
			List<KeCheng> keChengIndexList = keChengService.findIndexKeCheng();
			
			mav.addObject("ziXunJiGouIndexList", ziXunJiGouIndexList);
			mav.addObject("guWenIndexList", guWenIndexList);
			mav.addObject("wenAnIndexList", wenAnIndexList);
			mav.addObject("xueXiaoIndexList", xueXiaoIndexList);
			mav.addObject("mingShiIndexList", mingShiIndexList);
			mav.addObject("studentIndexList", studentIndexList);
			mav.addObject("keChengIndexList", keChengIndexList);
			
			if (adminUser==null) {
				mav.setViewName("forward:/view/home.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/adminIndex.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
}
