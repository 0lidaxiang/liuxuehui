package com.liuxue.control;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.liuxue.base.Constants;
import com.liuxue.base.util.SpercialCharUtil;
import com.liuxue.dao.Page;
import com.liuxue.entity.AdminUser;
import com.liuxue.entity.GuWen;
import com.liuxue.entity.GuWenContent;
import com.liuxue.service.GuWenContentService;
import com.liuxue.service.GuWenService;

@Controller
@RequestMapping("/guwen")
public class GuWenController extends BaseController{
	
	@Autowired
	private GuWenService guWenService;
	
	@Autowired
	private GuWenContentService guWenContentService;
	
	
	//分页进入列表页面
	@RequestMapping(value="/more",method=RequestMethod.GET)
	public ModelAndView guWenLieBiao(@RequestParam("pageNo")String pageNo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		int pageNoInt = Integer.parseInt(pageNo); //页数 页码
		int pageSize = 5;//每页记录数
		try {
			Page page = guWenService.page(pageNoInt, pageSize);
			List<GuWen> guWenList = (List<GuWen>)page.getResult();
			mav.addObject("guWenList", guWenList);
			mav.addObject("page", page);
			mav.addObject("pageUrl","guwen/more.shtml");
			if (adminUser==null) {
				mav.setViewName("forward:/view/ziXunGuWen.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/guwen/guWenManage.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	//进入内容页面
	@RequestMapping(value="/content",method=RequestMethod.GET)
	public ModelAndView content(@RequestParam("guWenGuid")String guWenGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			GuWen guWen = guWenService.getGuWenByGuid(guWenGuid);
			if (guWen.getRenQi()==null) {
				guWen.setRenQi(1);
			}else {
				guWen.setRenQi(guWen.getRenQi()+1);
			}
			
			GuWenContent guWenContent = guWenContentService.findGuWenCOntentByGuWenGuid(guWenGuid);
			mav.addObject("guWen",guWen);
			mav.addObject("guWenContent",guWenContent);
			if (adminUser==null) {
				mav.setViewName("forward:/view/ziXunGuWenContent.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/guwen/guWenContent.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	
	
	
	//新增顾问 包括内容
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addWenAn(@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("shengFeng")String shengFeng,@RequestParam("ruHangShiJian")String ruHangShiJian,
			@RequestParam("zixunxingshi")String zixunxingshi,@RequestParam("shanchangguojia")String shanchangguojia,
			@RequestParam("shanChangZhuanYe")String shanChangZhuanYe,@RequestParam("zhiYeXingTiao")String zhiYeXingTiao,
			@RequestParam("xueYuanPingJia")String xueYuanPingJia,@RequestParam("renqi")String renqi,
			@RequestParam("xinJiPingJia")String xinJiPingJia,@RequestParam("weekQianDanLiang")String weekQianDanLiang,
			@RequestParam("monthQianDanLiang")String monthQianDanLiang,@RequestParam("yearQianDanLiang")String yearQianDanLiang,
			@RequestParam("dianhua")String dianhua,@RequestParam("QQ")String QQ,@RequestParam("weiXin")String weiXin,
			@RequestParam("picture")MultipartFile picture,@RequestParam("boKeUrl")String boKeUrl,@RequestParam("indexMiaoShu")String indexMiaoShu,
			@RequestParam("jieshao")String jieshao,@RequestParam("indexWeiZhi")String indexWeiZhi,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("forward:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer renQiInteger = renqi.equals("")?null:Integer.parseInt(renqi);
				Integer xinJiPingJiaInteger=null;
				if (!xinJiPingJia.equals("")) {
					xinJiPingJiaInteger = Integer.parseInt(xinJiPingJia);
				}
				Integer weekInteger = weekQianDanLiang.equals("")?null:Integer.parseInt(weekQianDanLiang);
				Integer monthInteger = monthQianDanLiang.equals("")?null:Integer.parseInt(monthQianDanLiang);
				Integer yearInteger =yearQianDanLiang.equals("")?null:Integer.parseInt(yearQianDanLiang);
				Integer indexXyBj_Integer = Integer.parseInt(indexXyBj);
				Integer weiZhiInteger =null;
				if(!indexWeiZhi.equals("")){
					weiZhiInteger = Integer.parseInt(indexWeiZhi);
				}
				
				GuWen guWen = new GuWen();
				guWen.setMonthQianDanLiang(monthInteger);
				guWen.setName(name);
				
				guWen.setRenQi(renQiInteger);
				guWen.setRuHangShiJian(ruHangShiJian);
				guWen.setShanChangGuoJia(shanchangguojia);
				guWen.setShanChangZuanYe(shanChangZhuanYe);
				guWen.setShenFen(shengFeng);
				guWen.setWeekQianDanLiang(weekInteger);
				guWen.setXinJiPingJia(xinJiPingJiaInteger);
				guWen.setXueYuanPinJia(xueYuanPingJia);
				guWen.setYearQianDanLiang(yearInteger);
				guWen.setZhiYeXinTiao(zhiYeXingTiao);
				guWen.setZiXunXingShi(zixunxingshi);
				guWen.setIndexXyBj(indexXyBj_Integer);
				guWen.setIndexWeiZhi(weiZhiInteger);
				guWen.setIndexMiaoShu(indexMiaoShu);
				
				
				String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());// 生成随机图片名称，防止重复
				guWen.setPhotoName(newImageName);
				photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.guWenLieBiaoImagePath+newImageName));//保存列表
				
				
				if(!indexPhoto.isEmpty()){
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());// 生成随机图片名称，防止重复
					guWen.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenIndexImagePath+newImageName2));//保存首页图片图片
				}
				guWenService.addGuWen(guWen);//添加顾问
				
				GuWenContent guWenContent = new GuWenContent();
				guWenContent.setBoKeUrl(boKeUrl);
				guWenContent.setDianHua(dianhua);
				guWenContent.setGuWenGuid(guWen.getGuid());
				guWenContent.setJieShao(jieshao);
				guWenContent.setQQ(QQ);
				guWenContent.setWeiXin(weiXin);
				if(!picture.isEmpty()){
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());// 生成随机图片名称，防止重复
					guWenContent.setPictureName(newImageName3);//设置内容图片名称
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenContentImagePath+newImageName3));//保存内容图片图片
				}
				guWenContentService.addGuWenContent(guWenContent);
				mav.addObject("msg", "新增成功");
				mav.setViewName("forward:/lxhAdmin/guwen/addGuWen.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	//进入修改页面
	@RequestMapping(value="/goUpdate",method=RequestMethod.GET)
	public ModelAndView goUpdate(@RequestParam("guWenGuid")String guWenGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("forward:/lxhAdmin/adminDengLu.jsp");
			}else{
				GuWen guWen = guWenService.getGuWenByGuid(guWenGuid);
				GuWenContent guWenContent = guWenContentService.findGuWenCOntentByGuWenGuid(guWenGuid);
				mav.addObject("guWen", guWen);
				mav.addObject("guWenContent", guWenContent);
				mav.setViewName("forward:/lxhAdmin/guwen/updateGuWen.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	
	//更新
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(@RequestParam("guWenGuid")String guWenGuid,@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("shengFeng")String shengFeng,@RequestParam("ruHangShiJian")String ruHangShiJian,
			@RequestParam("zixunxingshi")String zixunxingshi,@RequestParam("shanchangguojia")String shanchangguojia,
			@RequestParam("shanChangZhuanYe")String shanChangZhuanYe,@RequestParam("zhiYeXingTiao")String zhiYeXingTiao,
			@RequestParam("xueYuanPingJia")String xueYuanPingJia,@RequestParam("renqi")String renqi,
			@RequestParam("xinJiPingJia")String xinJiPingJia,@RequestParam("weekQianDanLiang")String weekQianDanLiang,
			@RequestParam("monthQianDanLiang")String monthQianDanLiang,@RequestParam("yearQianDanLiang")String yearQianDanLiang,
			@RequestParam("dianhua")String dianhua,@RequestParam("QQ")String QQ,@RequestParam("weiXin")String weiXin,
			@RequestParam("picture")MultipartFile picture,@RequestParam("boKeUrl")String boKeUrl,@RequestParam("indexMiaoShu")String indexMiaoShu,
			@RequestParam("jieshao")String jieshao,@RequestParam("indexWeiZhi")String indexWeiZhi,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("forward:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer renQiInteger = renqi.equals("")?null:Integer.parseInt(renqi);
				Integer xinJiPingJiaInteger=null;
				if (!xinJiPingJia.equals("")) {
					xinJiPingJiaInteger = Integer.parseInt(xinJiPingJia);
				}
				Integer weekInteger = weekQianDanLiang.equals("")?null:Integer.parseInt(weekQianDanLiang);
				Integer monthInteger = monthQianDanLiang.equals("")?null:Integer.parseInt(monthQianDanLiang);
				Integer yearInteger =yearQianDanLiang.equals("")?null:Integer.parseInt(yearQianDanLiang);
				Integer indexXyBj_Integer = Integer.parseInt(indexXyBj);
				Integer weiZhiInteger =null;
				if(!indexWeiZhi.equals("")){
					weiZhiInteger = Integer.parseInt(indexWeiZhi);
				}
				
				GuWen guWen = guWenService.getGuWenByGuid(guWenGuid);
				guWen.setMonthQianDanLiang(monthInteger);
				guWen.setName(name);
				guWen.setRenQi(renQiInteger);
				guWen.setRuHangShiJian(ruHangShiJian);
				guWen.setShanChangGuoJia(shanchangguojia);
				guWen.setShanChangZuanYe(shanChangZhuanYe);
				guWen.setShenFen(shengFeng);
				guWen.setWeekQianDanLiang(weekInteger);
				guWen.setXinJiPingJia(xinJiPingJiaInteger);
				guWen.setXueYuanPinJia(xueYuanPingJia);
				guWen.setYearQianDanLiang(yearInteger);
				guWen.setZhiYeXinTiao(zhiYeXingTiao);
				guWen.setZiXunXingShi(zixunxingshi);
				guWen.setIndexXyBj(indexXyBj_Integer);
				guWen.setIndexWeiZhi(weiZhiInteger);
				guWen.setIndexMiaoShu(indexMiaoShu);
				
				if (!photo.isEmpty()) {
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenLieBiaoImagePath+guWen.getPhotoName());//原列表图片
					f.delete();//删除原列表图片
					
					
					String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());// 生成随机图片名称，防止重复
					guWen.setPhotoName(newImageName);
					photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenLieBiaoImagePath+newImageName));//保存列表
				}
				
				if(!indexPhoto.isEmpty()){
					File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenIndexImagePath+guWen.getIndexPhotoName());
					f2.delete();
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());// 生成随机图片名称，防止重复
					guWen.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenIndexImagePath+newImageName2));//保存首页图片图片
				}
				guWenService.updateguWen(guWen);//更新顾问
				
				GuWenContent guWenContent = guWenContentService.findGuWenCOntentByGuWenGuid(guWenGuid);
				guWenContent.setBoKeUrl(boKeUrl);
				guWenContent.setDianHua(dianhua);
				guWenContent.setGuWenGuid(guWen.getGuid());
				guWenContent.setJieShao(jieshao);
				guWenContent.setQQ(QQ);
				guWenContent.setWeiXin(weiXin);
				if(!picture.isEmpty()){
					File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenContentImagePath+guWenContent.getPictureName());
					f3.delete();
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());// 生成随机图片名称，防止重复
					guWenContent.setPictureName(newImageName3);//设置内容图片名称
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.guWenContentImagePath+newImageName3));//保存内容图片图片
				}
				guWenContentService.updateGuWenContent(guWenContent);
				
				mav.addObject("guWen", guWen);
				mav.addObject("guWenContent", guWenContent);
				mav.addObject("msg", "新增成功");
				mav.setViewName("forward:/lxhAdmin/guwen/updateGuWen.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	//删除 包括内容
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(@RequestParam("guWenGuid")String guWenGuid,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			GuWen guWen = guWenService.getGuWenByGuid(guWenGuid);
			GuWenContent guWenContent = guWenContentService.findGuWenCOntentByGuWenGuid(guWenGuid);
			if (guWen.getPhotoName()!=null) {
				File f = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.guWenLieBiaoImagePath+guWen.getPhotoName());//原列表图片
				f.delete();//删除原列表图片
			}
			if (guWen.getIndexPhotoName()!=null) {
				File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.guWenIndexImagePath+guWen.getIndexPhotoName());
				f2.delete();//删除首页图片
			}
			guWenService.deleteGuWen(guWen);
			
			if (guWenContent.getPictureName()!=null) {
				File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.guWenContentImagePath+guWenContent.getPictureName());
				f3.delete();//删除内容图片
			}
			guWenContentService.deleteGuWenContent(guWenContent);
			
			map.put("msg","success");//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","fail");//删除失败
		}
		return map;
	}
	

}
