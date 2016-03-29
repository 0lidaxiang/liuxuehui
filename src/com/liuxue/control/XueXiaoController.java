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
import com.liuxue.entity.WenAn;
import com.liuxue.entity.WenAnContent;
import com.liuxue.entity.XueXiao;
import com.liuxue.entity.XueXiaoContent;
import com.liuxue.service.XueXiaoContentService;
import com.liuxue.service.XueXiaoService;

@Controller
@RequestMapping("/xuexiao")
public class XueXiaoController extends BaseController{

	@Autowired
	private XueXiaoService xueXiaoSerive;
	
	@Autowired
	private XueXiaoContentService xueXiaoContentService;
	
	
	//分页进入列表页面
	@RequestMapping(value="/more",method=RequestMethod.GET)
	public ModelAndView lieBiao(@RequestParam("pageNo")String pageNo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		int pageNoInt = Integer.parseInt(pageNo); //页数 页码
		int pageSize = 5;//每页记录数
		try {
			Page page = xueXiaoSerive.page(pageNoInt, pageSize);
			List<XueXiao> xueXiaoList = (List<XueXiao>)page.getResult();
			mav.addObject("xueXiaoList", xueXiaoList);
			mav.addObject("page", page);
			mav.addObject("pageUrl","xuexiao/more.shtml");
			if (adminUser==null) {
				mav.setViewName("forward:/view/peiXunXueXiao.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/xuexiao/xueXiaoManage.jsp");
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
	public ModelAndView content(@RequestParam("xueXiaoGuid")String xueXiaoGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			XueXiao xueXiao = xueXiaoSerive.getXueXiaoByGuid(xueXiaoGuid);
			if (xueXiao.getRenQi()==null) {
				xueXiao.setRenQi(1);
			}else{
				xueXiao.setRenQi(xueXiao.getRenQi()+1);//人气加1
			}
			
			XueXiaoContent xueXiaoContent = xueXiaoContentService.findXueXiaoCotentByXueXiaoGuid(xueXiaoGuid);
			mav.addObject("xueXiao",xueXiao);
			mav.addObject("xueXiaoContent",xueXiaoContent);
			if (adminUser==null) {
				mav.setViewName("forward:/view/peiXunXuexiaoContent.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/xuexiao/xueXiaoContent.jsp");
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
	public ModelAndView add(@RequestParam("name")String name,@RequestParam("engLishName")String engLishName,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("jianjie")String jianjie,@RequestParam("renqi")String renqi,@RequestParam("pinjia")String pinjia,
			@RequestParam("shanchangguojia")String shanchangguojia,@RequestParam("suoZaiChengShi")String suoZaiChengShi,
			@RequestParam("leiXing")String leiXing,@RequestParam("weekZhaoShengShu")String weekZhaoShengShu,
			@RequestParam("monthZhaoShengShu")String monthZhaoShengShu,@RequestParam("yearZhaoShengShu")String yearZhaoShengShu,
			@RequestParam("picture")MultipartFile picture,@RequestParam("dianhua")String dianhua,@RequestParam("indexWeiZhi")String indexWeiZhi,
			@RequestParam("address")String address,@RequestParam("jieshao")String jieshao,@RequestParam("indexMiaoShu")String indexMiaoShu,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer renQInteger = renqi.equals("")?null:Integer.parseInt(renqi);
				Integer pinJiaInteger = pinjia.equals("")?null:Integer.parseInt(pinjia);
				Integer week_zhaoShengShu_Integer = weekZhaoShengShu.equals("")?null:Integer.parseInt(weekZhaoShengShu);
				Integer month_zhaoShengShu_Integer = monthZhaoShengShu.equals("")?null:Integer.parseInt(monthZhaoShengShu);
				Integer year_zhaoShengShu_Integer = yearZhaoShengShu.equals("")?null:Integer.parseInt(yearZhaoShengShu);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				XueXiao xueXiao = new XueXiao();
				xueXiao.setName(name);
				xueXiao.setEngLishName(engLishName);
				xueXiao.setIndexWeiZhi(weiZhiInteger);
				xueXiao.setJianjie(jianjie);
				xueXiao.setRenQi(renQInteger);
				xueXiao.setPinJia(pinJiaInteger);
				xueXiao.setShanChangGuoJia(shanchangguojia);
				xueXiao.setLeiXing(leiXing);
				xueXiao.setSuoZaiChengShi(suoZaiChengShi);
				xueXiao.setWeekZhaoShengShu(week_zhaoShengShu_Integer);
				xueXiao.setMonthZhaoShengShu(month_zhaoShengShu_Integer);
				xueXiao.setYearZhaoShengShu(year_zhaoShengShu_Integer);
				xueXiao.setIndexXyBj(indexXyBj_Integer);
				xueXiao.setIndexMiaoShu(indexMiaoShu);
				
				String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
				xueXiao.setPhotoName(newImageName);//设置为图片名称
				photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.xueXiaoLieBiaoImagePath+newImageName));//保存 小图片
				if(!indexPhoto.isEmpty()){
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					xueXiao.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoIndexImagePath+newImageName2));//保存首页图片图片
				}
				xueXiaoSerive.addXueXiao(xueXiao);
				
				XueXiaoContent xueXiaoContent = new XueXiaoContent();
				xueXiaoContent.setAddress(address);
				xueXiaoContent.setDianHua(dianhua);
				xueXiaoContent.setJieShao(jieshao);
				xueXiaoContent.setXueXiaoGuid(xueXiao.getGuid());
				if (!picture.isEmpty()) {
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					xueXiaoContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoContentImagePath+newImageName3));//保存内容图片图片
				}
				xueXiaoContentService.addXueXiaoContent(xueXiaoContent);
				mav.addObject("msg", "新增成功");
				mav.setViewName("forward:/lxhAdmin/xuexiao/addXueXiao.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	//修改 包括内容
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(@RequestParam("xueXiaoGuid")String xueXiaoGuid,@RequestParam("name")String name,@RequestParam("engLishName")String engLishName,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("jianjie")String jianjie,@RequestParam("renqi")String renqi,@RequestParam("pinjia")String pinjia,
			@RequestParam("shanchangguojia")String shanchangguojia,@RequestParam("suoZaiChengShi")String suoZaiChengShi,
			@RequestParam("leiXing")String leiXing,@RequestParam("weekZhaoShengShu")String weekZhaoShengShu,
			@RequestParam("monthZhaoShengShu")String monthZhaoShengShu,@RequestParam("yearZhaoShengShu")String yearZhaoShengShu,
			@RequestParam("picture")MultipartFile picture,@RequestParam("dianhua")String dianhua,@RequestParam("indexWeiZhi")String indexWeiZhi,
			@RequestParam("address")String address,@RequestParam("jieshao")String jieshao,@RequestParam("indexMiaoShu")String indexMiaoShu,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer renQInteger = renqi.equals("")?null:Integer.parseInt(renqi);
				Integer pinJiaInteger = pinjia.equals("")?null:Integer.parseInt(pinjia);
				Integer week_zhaoShengShu_Integer = weekZhaoShengShu.equals("")?null:Integer.parseInt(weekZhaoShengShu);
				Integer month_zhaoShengShu_Integer = monthZhaoShengShu.equals("")?null:Integer.parseInt(monthZhaoShengShu);
				Integer year_zhaoShengShu_Integer = yearZhaoShengShu.equals("")?null:Integer.parseInt(yearZhaoShengShu);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				XueXiao xueXiao = xueXiaoSerive.getXueXiaoByGuid(xueXiaoGuid);
				xueXiao.setName(name);
				xueXiao.setEngLishName(engLishName);
				xueXiao.setIndexWeiZhi(weiZhiInteger);
				xueXiao.setJianjie(jianjie);
				xueXiao.setRenQi(renQInteger);
				xueXiao.setPinJia(pinJiaInteger);
				xueXiao.setShanChangGuoJia(shanchangguojia);
				xueXiao.setLeiXing(leiXing);
				xueXiao.setSuoZaiChengShi(suoZaiChengShi);
				xueXiao.setWeekZhaoShengShu(week_zhaoShengShu_Integer);
				xueXiao.setMonthZhaoShengShu(month_zhaoShengShu_Integer);
				xueXiao.setYearZhaoShengShu(year_zhaoShengShu_Integer);
				xueXiao.setIndexXyBj(indexXyBj_Integer);
				xueXiao.setIndexMiaoShu(indexMiaoShu);
				
				
				if(!photo.isEmpty()){
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoLieBiaoImagePath+xueXiao.getPhotoName());
					f.delete();
					
					String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
					xueXiao.setPhotoName(newImageName);//设置为图片名称
					photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoLieBiaoImagePath+newImageName));//保存 小图片
				}
				
				if(!indexPhoto.isEmpty()){
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoIndexImagePath+xueXiao.getIndexPhotoName());
					f.delete();
					
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					xueXiao.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoIndexImagePath+newImageName2));//保存首页图片图片
				}
				xueXiaoSerive.updateXueXiao(xueXiao);
				
				XueXiaoContent xueXiaoContent = xueXiaoContentService.findXueXiaoCotentByXueXiaoGuid(xueXiaoGuid);
				xueXiaoContent.setAddress(address);
				xueXiaoContent.setDianHua(dianhua);
				xueXiaoContent.setJieShao(jieshao);
				xueXiaoContent.setXueXiaoGuid(xueXiao.getGuid());
				if (!picture.isEmpty()) {
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoContentImagePath+xueXiaoContent.getPictureName());
					f.delete();
					
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					xueXiaoContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.xueXiaoContentImagePath+newImageName3));//保存内容图片图片
				}
				xueXiaoContentService.updateXueXiaoContent(xueXiaoContent);
				mav.addObject("msg", "修改成功");
				mav.addObject("xueXiao", xueXiao);
				mav.addObject("xueXiaoContent", xueXiaoContent);
				mav.setViewName("forward:/lxhAdmin/xuexiao/updateXueXiao.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/goUpdateXueXiao")
	public ModelAndView goUpdateXueXiao(@RequestParam("xueXiaoGuid")String xueXiaoGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				XueXiao xueXiao = xueXiaoSerive.getXueXiaoByGuid(xueXiaoGuid);
				XueXiaoContent xueXiaoContent = xueXiaoContentService.findXueXiaoCotentByXueXiaoGuid(xueXiaoGuid);
				mav.addObject("xueXiao", xueXiao);
				mav.addObject("xueXiaoContent", xueXiaoContent);
				mav.setViewName("forward:/lxhAdmin/xuexiao/updateXueXiao.jsp");
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
	public Object delete(@RequestParam("xueXiaoGuid")String xueXiaoGuid,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			XueXiao xueXiao = xueXiaoSerive.getXueXiaoByGuid(xueXiaoGuid);
			XueXiaoContent xueXiaoContent = xueXiaoContentService.findXueXiaoCotentByXueXiaoGuid(xueXiaoGuid);
			if (xueXiao.getPhotoName()!=null) {
				File f = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.xueXiaoLieBiaoImagePath+xueXiao.getPhotoName());//原列表图片
				f.delete();//删除原列表图片
			}
			if (xueXiao.getIndexPhotoName()!=null) {
				File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.xueXiaoIndexImagePath+xueXiao.getIndexPhotoName());
				f2.delete();//删除首页图片
			}
			xueXiaoSerive.deleteXueXiao(xueXiao);
			
			if (xueXiaoContent.getPictureName()!=null) {
				File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.xueXiaoContentImagePath+xueXiaoContent.getPictureName());
				f3.delete();//删除内容图片
			}
			xueXiaoContentService.deleteXueXiaoContent(xueXiaoContent);
			
			map.put("msg","success");//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","fail");//删除失败
		}
		return map;
	}
	
	
}
