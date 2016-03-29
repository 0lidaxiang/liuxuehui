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
import com.liuxue.entity.GuWen;
import com.liuxue.entity.GuWenContent;
import com.liuxue.entity.ZiXunJiGou;
import com.liuxue.entity.ZiXunJiGouContent;
import com.liuxue.service.JiGouContentService;
import com.liuxue.service.JiGouService;

@Controller
@RequestMapping("/jigou")
public class JiGouController extends BaseController{
	
	@Autowired
	private JiGouService jiGouService;
	
	@Autowired
	private JiGouContentService jiGouContentService;
	
	//分页进入列表页面
	@RequestMapping(value="/more",method=RequestMethod.GET)
	public ModelAndView jiGouLieBiao(@RequestParam("pageNo")String pageNo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		int pageNoInt = Integer.parseInt(pageNo); //页数 页码
		int pageSize = 5;//每页记录数
		try {
			Page page = jiGouService.page(pageNoInt, pageSize);
			List<ZiXunJiGou> ziXunJiGouList = (List<ZiXunJiGou>)page.getResult();
			mav.addObject("ziXunJiGouList", ziXunJiGouList);
			mav.addObject("page", page);
			mav.addObject("pageUrl","jigou/more.shtml");
			if (adminUser==null) {
				mav.setViewName("forward:/view/ziXunJiGou.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/jigou/jiGouManage.jsp");
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
	public ModelAndView content(@RequestParam("jiGouGuid")String jiGouGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			ZiXunJiGou ziXunJiGou = jiGouService.getJiGouByGuid(jiGouGuid);
			if (ziXunJiGou.getRenQi()==null) {
				ziXunJiGou.setRenQi(1);
			}else{
				ziXunJiGou.setRenQi(ziXunJiGou.getRenQi()+1);//人气加1
			}
			
			ZiXunJiGouContent ziXunJiGouContent = jiGouContentService.findByJiGouGuid(jiGouGuid);
			mav.addObject("ziXunJiGou",ziXunJiGou);
			mav.addObject("ziXunJiGouContent",ziXunJiGouContent);
			if (adminUser==null) {
				mav.setViewName("forward:/view/ziXunJiGouContent.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/jigou/jiGouContent.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	
	//新增机构 包括内容
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addJiGou(@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("jianjie")String jianjie,@RequestParam("renqi")String renqi,@RequestParam("pinjia")String pinjia,
			@RequestParam("shanchangguojia")String shanchangguojia,@RequestParam("zixunxingshi")String zixunxingshi,
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
				Integer indexXyBj_Integer = Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				
				ZiXunJiGou ziXunJiGou = new ZiXunJiGou();//新建机构
				ziXunJiGou.setName(name);
				ziXunJiGou.setJianJie(jianjie);
				ziXunJiGou.setRenQi(renQInteger);
				ziXunJiGou.setIndexWeiZhi(weiZhiInteger);
				ziXunJiGou.setPingJia(pinJiaInteger);
				ziXunJiGou.setShanChangGuoJia(shanchangguojia);
				ziXunJiGou.setZiXunXingShi(zixunxingshi);
				ziXunJiGou.setIndexXyBj(indexXyBj_Integer);
				ziXunJiGou.setIndexMiaoShu(indexMiaoShu);
				
				
				String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());// 生成随机图片名称，防止重复
				ziXunJiGou.setPhotoUrl(newImageName);//设置为图片名称
				photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.jiGouLieBiaoImagePath+newImageName));//保存小图片
				if(!indexPhoto.isEmpty()){
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());// 生成随机图片名称，防止重复
					ziXunJiGou.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouIndexImagePath+newImageName2));//保存首页图片图片
				}
				jiGouService.addJiGou(ziXunJiGou);//添加机构
				
				ZiXunJiGouContent ziXunJiGouContent = new ZiXunJiGouContent();
				ziXunJiGouContent.setAdress(address);
				ziXunJiGouContent.setDianHua(dianhua);
				ziXunJiGouContent.setJieShao(jieshao);
				ziXunJiGouContent.setJiGouGuid(ziXunJiGou.getGuid());
				if(!picture.isEmpty()){
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());// 生成随机图片名称，防止重复
					ziXunJiGouContent.setPictureUrl(newImageName3);//设置内容图片名称
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouContentImagePath+newImageName3));//保存内容图片图片
				}
				jiGouContentService.addJiGouContent(ziXunJiGouContent);
				mav.addObject("msg", "新增成功");
				mav.setViewName("forward:/lxhAdmin/jigou/addJiGou.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	//修改机构 包括内容
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView updateJiGou(@RequestParam("jiGouGuid")String jiGouGuid,@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("jianjie")String jianjie,@RequestParam("renqi")String renqi,@RequestParam("pinjia")String pinjia,
			@RequestParam("shanchangguojia")String shanchangguojia,@RequestParam("zixunxingshi")String zixunxingshi,
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
				Integer indexXyBj_Integer = Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				ZiXunJiGou ziXunJiGou = jiGouService.getJiGouByGuid(jiGouGuid);
				ziXunJiGou.setName(name);
				ziXunJiGou.setJianJie(jianjie);
				ziXunJiGou.setRenQi(renQInteger);
				ziXunJiGou.setIndexWeiZhi(weiZhiInteger);
				ziXunJiGou.setPingJia(pinJiaInteger);
				ziXunJiGou.setShanChangGuoJia(shanchangguojia);
				ziXunJiGou.setZiXunXingShi(zixunxingshi);
				ziXunJiGou.setIndexXyBj(indexXyBj_Integer);
				ziXunJiGou.setIndexMiaoShu(indexMiaoShu);
				
				if(!photo.isEmpty()){
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouLieBiaoImagePath+ziXunJiGou.getPhotoUrl());//原列表图片
					f.delete();//删除原列表图片
					
					String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());// 生成随机图片名称，防止重复
					ziXunJiGou.setPhotoUrl(newImageName);//设置为图片名称
					photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouLieBiaoImagePath+newImageName));//保存小图片
				}
				
				if(!indexPhoto.isEmpty()){
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouIndexImagePath+ziXunJiGou.getIndexPhotoName());
					f.delete();//删除原图片
					
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());// 生成随机图片名称，防止重复
					ziXunJiGou.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouIndexImagePath+newImageName2));//保存首页图片图片
				}
				jiGouService.updateJiGou(ziXunJiGou);//添加机构
				
				ZiXunJiGouContent ziXunJiGouContent = jiGouContentService.findByJiGouGuid(jiGouGuid);
				ziXunJiGouContent.setAdress(address);
				ziXunJiGouContent.setDianHua(dianhua);
				ziXunJiGouContent.setJieShao(jieshao);
				ziXunJiGouContent.setJiGouGuid(ziXunJiGou.getGuid());
				if(!picture.isEmpty()){
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouContentImagePath+ziXunJiGouContent.getPictureUrl());
					f.delete();//删除原图片
					
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());// 生成随机图片名称，防止重复
					ziXunJiGouContent.setPictureUrl(newImageName3);//设置内容图片名称
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.jiGouContentImagePath+newImageName3));//保存内容图片图片
				}
				jiGouContentService.updateJiGouContent(ziXunJiGouContent);
				mav.addObject("msg", "更新成功");
				mav.addObject("ziXunJiGou", ziXunJiGou);
				mav.addObject("ziXunJiGouContent", ziXunJiGouContent);
				mav.setViewName("forward:/lxhAdmin/jigou/addJiGou.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/goUpdateJiGou")
	public ModelAndView addJiGou(@RequestParam("jiGouGuid")String jiGouGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				ZiXunJiGou ziXunJiGou = jiGouService.getJiGouByGuid(jiGouGuid);
				ZiXunJiGouContent ziXunJiGouContent = jiGouContentService.findByJiGouGuid(jiGouGuid);
				mav.addObject("ziXunJiGou", ziXunJiGou);
				mav.addObject("ziXunJiGouContent", ziXunJiGouContent);
				mav.setViewName("forward:/lxhAdmin/jigou/updateJiGou.jsp");
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
	public Object delete(@RequestParam("jiGouGuid")String jiGouGuid,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			ZiXunJiGou ziXunJiGou = jiGouService.getJiGouByGuid(jiGouGuid);
			ZiXunJiGouContent ziXunJiGouContent = jiGouContentService.findByJiGouGuid(jiGouGuid);
			if (ziXunJiGou.getPhotoUrl()!=null) {
				File f = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.jiGouLieBiaoImagePath+ziXunJiGou.getPhotoUrl());//原列表图片
				f.delete();//删除原列表图片
			}
			if (ziXunJiGou.getIndexPhotoName()!=null) {
				File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.jiGouIndexImagePath+ziXunJiGou.getIndexPhotoName());
				f2.delete();//删除首页图片
			}
			jiGouService.deleteJiGou(ziXunJiGou);
			
			if (ziXunJiGouContent.getPictureUrl()!=null) {
				File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.jiGouContentImagePath+ziXunJiGouContent.getPictureUrl());
				f3.delete();//删除内容图片
			}
			jiGouContentService.deleteJiGouContent(ziXunJiGouContent);
			
			map.put("msg","success");//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","fail");//删除失败
		}
		return map;
	}
	
	
	
	
	
}
