package com.liuxue.control;

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
import com.liuxue.entity.MingShi;
import com.liuxue.entity.MingShiContent;
import com.liuxue.service.MingShiContentService;
import com.liuxue.service.MingShiService;

@Controller
@RequestMapping("/mingshi")
public class MingShiController extends BaseController{

	@Autowired
	private MingShiService mingShiService;
	
	@Autowired
	private MingShiContentService mingShiContentService;
	
	//分页进入列表页面
	@RequestMapping(value="/more",method=RequestMethod.GET)
	public ModelAndView lieBiao(@RequestParam("pageNo")String pageNo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		int pageNoInt = Integer.parseInt(pageNo); //页数 页码
		int pageSize = 5;//每页记录数
		try {
			Page page = mingShiService.page(pageNoInt, pageSize);
			List<MingShi> mingShiList = (List<MingShi>)page.getResult();
			mav.addObject("mingShiList", mingShiList);
			mav.addObject("page", page);
			mav.addObject("pageUrl","mingshi/more.shtml");
			if (adminUser==null) {
				mav.setViewName("forward:/view/peiXunMingShi.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/mingshi/mingShiManage.jsp");
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
	public ModelAndView content(@RequestParam("mingShiGuid")String mingShiGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			MingShi mingShi = mingShiService.getMingShiByGuid(mingShiGuid);
			if (mingShi.getRenQi()==null) {
				mingShi.setRenQi(1);
			}else {
				mingShi.setRenQi(mingShi.getRenQi()+1);
			}
			
			MingShiContent mingShiContent = mingShiContentService.findMingShiContentByMingShiGuid(mingShiGuid);
			mav.addObject("mingShi",mingShi);
			mav.addObject("mingShiContent",mingShiContent);
			if (adminUser==null) {
				mav.setViewName("forward:/view/peiXunMingShiContent.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/mingshi/mingShiContent.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	
	//新增 包括内容
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("shengFeng")String shengFeng,@RequestParam("ruHangShiJian")String ruHangShiJian,
			@RequestParam("zixunxingshi")String zixunxingshi,@RequestParam("jianJie")String jianJie,
			@RequestParam("shanChangKeCheng")String shanChangKeCheng,@RequestParam("zhiYeXingTiao")String zhiYeXingTiao,
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
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer renQiInteger = renqi.equals("")?null:Integer.parseInt(renqi);
				Integer xinJiPingJiaInteger = xinJiPingJia.equals("")?null:Integer.parseInt(xinJiPingJia);
				Integer weekInteger = weekQianDanLiang.equals("")?null:Integer.parseInt(weekQianDanLiang);
				Integer monthInteger = monthQianDanLiang.equals("")?null:Integer.parseInt(monthQianDanLiang);
				Integer yearInteger = yearQianDanLiang.equals("")?null:Integer.parseInt(yearQianDanLiang);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				MingShi mingShi = new MingShi();
				mingShi.setMonthQianDanLiang(monthInteger);
				mingShi.setName(name);
				mingShi.setIndexWeiZhi(weiZhiInteger);
				mingShi.setRenQi(renQiInteger);
				mingShi.setRuHangShiJian(ruHangShiJian);
				mingShi.setJianJie(jianJie);
				mingShi.setShanChangKeCheng(shanChangKeCheng);
				mingShi.setShenFen(shengFeng);
				mingShi.setWeekQianDanLiang(weekInteger);
				mingShi.setXinJiPingJia(xinJiPingJiaInteger);
				mingShi.setXueYuanPinJia(xueYuanPingJia);
				mingShi.setYearQianDanLiang(yearInteger);
				mingShi.setZhiYeXinTiao(zhiYeXingTiao);
				mingShi.setZiXunXingShi(zixunxingshi);
				mingShi.setIndexXyBj(indexXyBj_Integer);
				mingShi.setIndexMiaoShu(indexMiaoShu);
				
				String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
				mingShi.setPhotoName(newImageName);
				photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.mingShiLieBiaoImagePath+newImageName));//保存小图片
				
				
				if(!indexPhoto.isEmpty()){
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					mingShi.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiIndexImagePath+newImageName2));//保存首页图片图片
				}
				mingShiService.addMingShi(mingShi);
				
				MingShiContent mingShiContent = new MingShiContent();
				mingShiContent.setBoKeUrl(boKeUrl);
				mingShiContent.setDianHua(dianhua);
				mingShiContent.setMingShiGuid(mingShi.getGuid());
				mingShiContent.setJieShao(jieshao);
				mingShiContent.setQq(QQ);
				mingShiContent.setWeiXin(weiXin);
				if (!picture.isEmpty()) {
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					mingShiContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiContentImagePath+newImageName3));//保存内容图片图片
				}
				mingShiContentService.addMingShiContent(mingShiContent);
				mav.addObject("msg", "新增成功");
				mav.setViewName("forward:/lxhAdmin/mingshi/addMingShi.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	//新增 包括内容
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(@RequestParam("mingShiGuid")String mingShiGuid,@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("shengFeng")String shengFeng,@RequestParam("ruHangShiJian")String ruHangShiJian,
			@RequestParam("zixunxingshi")String zixunxingshi,@RequestParam("jianJie")String jianJie,
			@RequestParam("shanChangKeCheng")String shanChangKeCheng,@RequestParam("zhiYeXingTiao")String zhiYeXingTiao,
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
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer renQiInteger = renqi.equals("")?null:Integer.parseInt(renqi);
				Integer xinJiPingJiaInteger = xinJiPingJia.equals("")?null:Integer.parseInt(xinJiPingJia);
				Integer weekInteger = weekQianDanLiang.equals("")?null:Integer.parseInt(weekQianDanLiang);
				Integer monthInteger = monthQianDanLiang.equals("")?null:Integer.parseInt(monthQianDanLiang);
				Integer yearInteger = yearQianDanLiang.equals("")?null:Integer.parseInt(yearQianDanLiang);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				MingShi mingShi = mingShiService.getMingShiByGuid(mingShiGuid);
				mingShi.setMonthQianDanLiang(monthInteger);
				mingShi.setName(name);
				mingShi.setIndexWeiZhi(weiZhiInteger);
				mingShi.setRenQi(renQiInteger);
				mingShi.setRuHangShiJian(ruHangShiJian);
				mingShi.setJianJie(jianJie);
				mingShi.setShanChangKeCheng(shanChangKeCheng);
				mingShi.setShenFen(shengFeng);
				mingShi.setWeekQianDanLiang(weekInteger);
				mingShi.setXinJiPingJia(xinJiPingJiaInteger);
				mingShi.setXueYuanPinJia(xueYuanPingJia);
				mingShi.setYearQianDanLiang(yearInteger);
				mingShi.setZhiYeXinTiao(zhiYeXingTiao);
				mingShi.setZiXunXingShi(zixunxingshi);
				mingShi.setIndexXyBj(indexXyBj_Integer);
				mingShi.setIndexMiaoShu(indexMiaoShu);
				
				if (!photo.isEmpty()) {
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiLieBiaoImagePath+mingShi.getPhotoName());//原列表图片
					f.delete();//删除原列表图片
					
					String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
					mingShi.setPhotoName(newImageName);
					photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiLieBiaoImagePath+newImageName));//保存小图片
				}
				
				
				if(!indexPhoto.isEmpty()){
					
					File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiIndexImagePath+mingShi.getIndexPhotoName());
					f2.delete();//删除首页图片
					
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					mingShi.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiIndexImagePath+newImageName2));//保存首页图片图片
				}
				mingShiService.updateMingShi(mingShi);
				
				MingShiContent mingShiContent = mingShiContentService.findMingShiContentByMingShiGuid(mingShiGuid);
				mingShiContent.setBoKeUrl(boKeUrl);
				mingShiContent.setDianHua(dianhua);
				mingShiContent.setMingShiGuid(mingShi.getGuid());
				mingShiContent.setJieShao(jieshao);
				mingShiContent.setQq(QQ);
				mingShiContent.setWeiXin(weiXin);
				if (!picture.isEmpty()) {
					File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiContentImagePath+mingShiContent.getPictureName());
					f3.delete();//删除内容图片
					
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					mingShiContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiContentImagePath+newImageName3));//保存内容图片图片
				}
				mingShiContentService.updateMingShiContent(mingShiContent);
				mav.addObject("mingShi", mingShi);
				mav.addObject("mingShiContent", mingShiContent);
				mav.addObject("msg", "修改成功");
				mav.setViewName("forward:/lxhAdmin/mingshi/updateMingShi.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/goUpdateMingShi")
	public ModelAndView goUpdateMingShi(@RequestParam("mingShiGuid")String mingShiGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				MingShi mingShi = mingShiService.getMingShiByGuid(mingShiGuid);
				MingShiContent mingShiContent = mingShiContentService.findMingShiContentByMingShiGuid(mingShiGuid);
				mav.addObject("mingShi", mingShi);
				mav.addObject("mingShiContent", mingShiContent);
				mav.setViewName("forward:/lxhAdmin/mingshi/updateMingShi.jsp");
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
	public Object delete(@RequestParam("mingShiGuid")String mingShiGuid,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			MingShi mingShi = mingShiService.getMingShiByGuid(mingShiGuid);
			MingShiContent mingShiContent = mingShiContentService.findMingShiContentByMingShiGuid(mingShiGuid);
			
			if (mingShi.getPhotoName()!=null) {
				File f = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.mingShiLieBiaoImagePath+mingShi.getPhotoName());//原列表图片
				f.delete();//删除原列表图片
			}
			if (mingShi.getIndexPhotoName()!=null) {
				File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.mingShiIndexImagePath+mingShi.getIndexPhotoName());
				f2.delete();//删除首页图片
			}
			mingShiService.deleteMingShi(mingShi);
			
			if(mingShiContent!=null){
				if (mingShiContent.getPictureName()!=null) {
					File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.mingShiContentImagePath+mingShiContent.getPictureName());
					f3.delete();//删除内容图片
				}
				mingShiContentService.deleteMingShiContent(mingShiContent);
			}
			
			map.put("msg","success");//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","fail");//删除失败
		}
		return map;
	}
	
	
}
