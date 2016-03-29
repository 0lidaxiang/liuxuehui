package com.liuxue.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liuxue.dao.Page;
import com.liuxue.entity.AdminUser;
import com.liuxue.entity.MingShi;
import com.liuxue.entity.OnlineTest;
import com.liuxue.service.OnlineTestService;

@Controller
@RequestMapping("/onlinetest")
public class OnlineTestController extends BaseController {

	@Autowired
	private OnlineTestService onlineTestService;

	@RequestMapping(value = "/savetest", method = RequestMethod.POST)
	public ModelAndView ceping(HttpSession session, HttpServletRequest request,ModelMap model) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateNow = new Date();
		OnlineTest onlineTest = new OnlineTest();
		onlineTest.setSchool(request.getParameter("school"));
		onlineTest.setGrade(request.getParameter("grade"));
		onlineTest.setMajor(request.getParameter("major"));
		onlineTest.setGuoJia(request.getParameter("guoJia"));
		onlineTest.setLuRuTime(dateNow);
		onlineTest.setZhuangTai(0);
		String score = request.getParameter("score");
		if (!StringUtils.isEmpty(score)) {
			onlineTest.setExamType(request.getParameter("examType"));
			onlineTest.setScore(score);
		}
		String[] intentionCountries = request
				.getParameterValues("intentionCountry");
		if (null != intentionCountries && intentionCountries.length != 0) {
			StringBuilder sb = new StringBuilder("");
			int index = 0;
			for (String intentionCountry : intentionCountries) {
				if (index == 0) {
					sb.append(intentionCountry);
				} else {
					sb.append(',').append(intentionCountry);
				}
				index++;
			}
			onlineTest.setIntentionCountry(sb.toString());
		}
		onlineTest.setIntentionMajor(request.getParameter("intentionMajor"));
		onlineTest.setPlanOutTime(request.getParameter("planOutTime"));
		onlineTest.setPhoneNumber(request.getParameter("phoneNumber"));
		if (onlineTestService.createOnlineTest(onlineTest)) {
			return new ModelAndView("zaiXianCePing", "result", "提交成功");
		} else {
			return new ModelAndView("zaiXianCePing", "result", "提交失败");
		}

	}
	
	//分页进入列表页面
	@RequestMapping(value="/more",method=RequestMethod.GET)
	public ModelAndView lieBiao(@RequestParam("pageNo")String pageNo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		int pageNoInt = Integer.parseInt(pageNo); //页数 页码
		int pageSize =20;//每页记录数
		try {
			Page page = onlineTestService.page(pageNoInt, pageSize);
			List<MingShi> onlineTestList = (List<MingShi>)page.getResult();
			mav.addObject("onlineTestList", onlineTestList);
			mav.addObject("page", page);
			mav.addObject("pageUrl","onlinetest/more.shtml");
			if (adminUser==null) {
				mav.setViewName("forward:/view/zaiXianCePing.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/zaiXianCePing.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	//删除 包括内容
	@RequestMapping(value="/updateZhuangTai")
	@ResponseBody
	public Object updateZhuangTai(@RequestParam("onlineTestGuid")String onlineTestGuid,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			OnlineTest onlineTest = onlineTestService.getOnlineTestByGuid(onlineTestGuid);
			Integer zhuangTai = onlineTest.getZhuangTai();
			if (zhuangTai==null) {
				onlineTest.setZhuangTai(1);
				map.put("zhuangTai","yes");
			}else if(zhuangTai==0){
				onlineTest.setZhuangTai(1);
				map.put("zhuangTai","yes");
			}else{
				onlineTest.setZhuangTai(0);
				map.put("zhuangTai","no");
			}
			onlineTestService.updateOnlineTest(onlineTest);
			map.put("msg","success");//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","fail");//删除失败
		}
		return map;
	}
	
	
	
}
