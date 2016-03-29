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
import com.liuxue.entity.KeCheng;
import com.liuxue.entity.KeChengContent;
import com.liuxue.entity.Student;
import com.liuxue.entity.StudentContent;
import com.liuxue.service.KeChengContentService;
import com.liuxue.service.KeChengService;

@Controller
@RequestMapping("/kecheng")
public class KeChengController extends BaseController{

	@Autowired
	private KeChengService keChengService;
	
	@Autowired
	private KeChengContentService keChengContentService;
	
	
	//分页进入列表页面
	@RequestMapping(value="/more",method=RequestMethod.GET)
	public ModelAndView lieBiao(@RequestParam("pageNo")String pageNo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		int pageNoInt = Integer.parseInt(pageNo); //页数 页码
		int pageSize = 9;//每页记录数
		try {
			Page page = keChengService.page(pageNoInt, pageSize);
			List<KeCheng> keChengList = (List<KeCheng>)page.getResult();
			mav.addObject("keChengList", keChengList);
			mav.addObject("page", page);
			mav.addObject("pageUrl","kecheng/more.shtml");
			if (adminUser==null) {
				mav.setViewName("forward:/view/keCheng.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/kecheng/keChengManage.jsp");
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
	public ModelAndView content(@RequestParam("keChengGuid")String keChengGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			KeCheng keCheng = keChengService.findKeChengByGuid(keChengGuid);
			
			KeChengContent keChengContent = keChengContentService.findKeChengContentByKeChengGuid(keChengGuid);
			
			mav.addObject("keCheng",keCheng);
			mav.addObject("keChengContent",keChengContent);
			if (adminUser==null) {
				mav.setViewName("forward:/view/keChengContent.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/kecheng/keChengContent.jsp");
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
			@RequestParam("jianjie")String jianjie,@RequestParam("beginTime")String beginTime,@RequestParam("endTime")String endTime,
			@RequestParam("tuiJianZhiShu")String tuiJianZhiShu,@RequestParam("indexWeiZhi")String indexWeiZhi,
			@RequestParam("picture")MultipartFile picture,@RequestParam("dianhua")String dianhua,
			@RequestParam("weiXin")String weiXin,@RequestParam("jiaoCai")String jiaoCai,@RequestParam("baoMingRenShu")String baoMingRenShu,
			@RequestParam("shiHeDuiXiang")String shiHeDuiXiang,@RequestParam("baoFenChengNuo")String baoFenChengNuo,
			@RequestParam("keChengFenXi")String keChengFenXi,@RequestParam("indexMiaoShu")String indexMiaoShu,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date beginTime_Date = format.parse(beginTime);
				Date endTime_Date = format.parse(endTime);
				Integer tuiJian_Integer = tuiJianZhiShu.equals("")?null:Integer.parseInt(tuiJianZhiShu);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				Integer baoMingRenShu_Integer = baoMingRenShu.equals("")?null:Integer.parseInt(baoMingRenShu);
				
				KeCheng keCheng = new KeCheng();
				keCheng.setBaoMingRenShu(baoMingRenShu_Integer);
				keCheng.setBeginTime(beginTime_Date);
				keCheng.setEndTime(endTime_Date);
				keCheng.setJianjie(jianjie);
				keCheng.setName(name);
				keCheng.setIndexWeiZhi(weiZhiInteger);
				keCheng.setTuiJianZhiShu(tuiJian_Integer);
				keCheng.setIndexXyBj(indexXyBj_Integer);
				keCheng.setIndexMiaoShu(indexMiaoShu);
				
				String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
				keCheng.setPhotoName(newImageName);
				photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.keChengiLieBiaoImagePath+newImageName));
				if(!indexPhoto.isEmpty()){
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					keCheng.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengIndexImagePath+newImageName2));//保存首页图片图片
				}
				keChengService.addKeCheng(keCheng);
				
				KeChengContent keChengContent = new KeChengContent();
				keChengContent.setBaoFenChengNuo(baoFenChengNuo);
				keChengContent.setDianHua(dianhua);
				keChengContent.setJiaoCai(jiaoCai);
				keChengContent.setKeChengFenXi(keChengFenXi);
				keChengContent.setKeChengGuid(keCheng.getGuid());
				keChengContent.setShiHeDuiXiang(shiHeDuiXiang);
				keChengContent.setWeiXin(weiXin);
				if (!picture.isEmpty()) {
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					keChengContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengContentImagePath+newImageName3));//保存内容图片图片
				}
				keChengContentService.addKeChengContent(keChengContent);
				mav.addObject("msg", "新增成功");
				mav.setViewName("forward:/lxhAdmin/kecheng/addKeCheng.jsp");
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
	public ModelAndView update(@RequestParam("keChengGuid")String keChengGuid,@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("jianjie")String jianjie,@RequestParam("beginTime")String beginTime,@RequestParam("endTime")String endTime,
			@RequestParam("tuiJianZhiShu")String tuiJianZhiShu,@RequestParam("indexWeiZhi")String indexWeiZhi,
			@RequestParam("picture")MultipartFile picture,@RequestParam("dianhua")String dianhua,
			@RequestParam("weiXin")String weiXin,@RequestParam("jiaoCai")String jiaoCai,@RequestParam("baoMingRenShu")String baoMingRenShu,
			@RequestParam("shiHeDuiXiang")String shiHeDuiXiang,@RequestParam("baoFenChengNuo")String baoFenChengNuo,
			@RequestParam("keChengFenXi")String keChengFenXi,@RequestParam("indexMiaoShu")String indexMiaoShu,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date beginTime_Date = format.parse(beginTime);
				Date endTime_Date = format.parse(endTime);
				Integer tuiJian_Integer = tuiJianZhiShu.equals("")?null:Integer.parseInt(tuiJianZhiShu);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				Integer baoMingRenShu_Integer = baoMingRenShu.equals("")?null:Integer.parseInt(baoMingRenShu);
				
				KeCheng keCheng = keChengService.findKeChengByGuid(keChengGuid);
				keCheng.setBaoMingRenShu(baoMingRenShu_Integer);
				keCheng.setBeginTime(beginTime_Date);
				keCheng.setEndTime(endTime_Date);
				keCheng.setJianjie(jianjie);
				keCheng.setName(name);
				keCheng.setIndexWeiZhi(weiZhiInteger);
				keCheng.setTuiJianZhiShu(tuiJian_Integer);
				keCheng.setIndexXyBj(indexXyBj_Integer);
				keCheng.setIndexMiaoShu(indexMiaoShu);
				if(!photo.isEmpty()){
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengiLieBiaoImagePath+keCheng.getPhotoName());//原列表图片
					f.delete();//删除原列表图片
					
					String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
					keCheng.setPhotoName(newImageName);
					photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengiLieBiaoImagePath+newImageName));
				}
				
				if(!indexPhoto.isEmpty()){
					File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengIndexImagePath+keCheng.getIndexPhotoName());
					f2.delete();//删除首页图片
					
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					keCheng.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengIndexImagePath+newImageName2));//保存首页图片图片
				}
				keChengService.updateKeCheng(keCheng);
				
				KeChengContent keChengContent = keChengContentService.findKeChengContentByKeChengGuid(keChengGuid);
				keChengContent.setBaoFenChengNuo(baoFenChengNuo);
				keChengContent.setDianHua(dianhua);
				keChengContent.setJiaoCai(jiaoCai);
				keChengContent.setKeChengFenXi(keChengFenXi);
				keChengContent.setKeChengGuid(keCheng.getGuid());
				keChengContent.setShiHeDuiXiang(shiHeDuiXiang);
				keChengContent.setWeiXin(weiXin);
				if (!picture.isEmpty()) {
					File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengContentImagePath+keChengContent.getPictureName());
					f3.delete();//删除内容图片
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					keChengContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengContentImagePath+newImageName3));//保存内容图片图片
				}
				keChengContentService.updateKeChengContent(keChengContent);
				mav.addObject("msg", "修改成功");
				mav.addObject("keCheng", keCheng);
				mav.addObject("keChengContent", keChengContent);
				mav.addObject("beginTime", beginTime);
				mav.addObject("endTime", endTime);
				mav.setViewName("forward:/lxhAdmin/kecheng/updateKeCheng.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/goUpdateKeCheng")
	public ModelAndView goUpdateKeCheng(@RequestParam("keChengGuid")String keChengGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				KeCheng keCheng = keChengService.findKeChengByGuid(keChengGuid);
				KeChengContent keChengContent = keChengContentService.findKeChengContentByKeChengGuid(keChengGuid);
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String beginTime = format.format(keCheng.getBeginTime());
				String endTime = format.format(keCheng.getEndTime());
				mav.addObject("keCheng", keCheng);
				mav.addObject("keChengContent", keChengContent);
				mav.addObject("beginTime", beginTime);
				mav.addObject("endTime", endTime);
				mav.setViewName("forward:/lxhAdmin/kecheng/updateKeCheng.jsp");
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
	public Object delete(@RequestParam("keChengGuid")String keChengGuid,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			KeCheng keCheng = keChengService.findKeChengByGuid(keChengGuid);
			KeChengContent keChengContent = keChengContentService.findKeChengContentByKeChengGuid(keChengGuid);
			
			if (keCheng.getPhotoName()!=null) {
				File f = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.keChengiLieBiaoImagePath+keCheng.getPhotoName());//原列表图片
				f.delete();//删除原列表图片
			}
			if (keCheng.getIndexPhotoName()!=null) {
				File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.keChengIndexImagePath+keCheng.getIndexPhotoName());
				f2.delete();//删除首页图片
			}
			keChengService.deleteKeCheng(keCheng);
			
			if(keChengContent!=null){
				if (keChengContent.getPictureName()!=null) {
					File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.keChengContentImagePath+keChengContent.getPictureName());
					f3.delete();//删除内容图片
				}
				keChengContentService.deleteKeChengContent(keChengContent);
			}
			
			map.put("msg","success");//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","fail");//删除失败
		}
		return map;
	}
	
}
