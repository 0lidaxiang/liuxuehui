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
import com.liuxue.entity.Student;
import com.liuxue.entity.StudentContent;
import com.liuxue.service.StudentContentService;
import com.liuxue.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController{

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentContentService studentContentService;
	
	//分页进入列表页面
	@RequestMapping(value="/more",method=RequestMethod.GET)
	public ModelAndView lieBiao(@RequestParam("pageNo")String pageNo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		int pageNoInt = Integer.parseInt(pageNo); //页数 页码
		int pageSize = 8;//每页记录数
		try {
			Page page = studentService.page(pageNoInt, pageSize);
			List<Student> studentList = (List<Student>)page.getResult();
			mav.addObject("studentList", studentList);
			mav.addObject("page", page);
			mav.addObject("pageUrl","student/more.shtml");
			if (adminUser==null) {
				mav.setViewName("forward:/view/chengGongAnLi.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/student/studentManage.jsp");
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
	public ModelAndView content(@RequestParam("studentGuid")String studentGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			Student student = studentService.getStudentByGuid(studentGuid);
			
			StudentContent studentContent = studentContentService.findStudentContentByStudentGuid(studentGuid);
			
			mav.addObject("student",student);
			mav.addObject("studentContent",studentContent);
			if (adminUser==null) {
				mav.setViewName("forward:/view/chengGongAnLiContent.jsp");
			}else{
				mav.setViewName("forward:/lxhAdmin/student/studentContent.jsp");
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
			@RequestParam("chengJi")String chengJi,@RequestParam("offer")String offer,@RequestParam("jinRuXueXiao")String jinRuXueXiao,
			@RequestParam("jinRuXueXiaoPingJi")String jinRuXueXiaoPingJi,@RequestParam("xueXiao")String xueXiao,
			@RequestParam("picture")MultipartFile picture,@RequestParam("zhuanYe")String zhuanYe,@RequestParam("indexMiaoShu")String indexMiaoShu,
			@RequestParam("pingJunChengJi")String pingJunChengJi,@RequestParam("anLiJianJie")String anLiJianJie,
			@RequestParam("anLiFenXi")String anLiFenXi,@RequestParam("indexWeiZhi")String indexWeiZhi,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer pingJi_xueXiao = jinRuXueXiaoPingJi.equals("")?null:Integer.parseInt(jinRuXueXiaoPingJi);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				Student student = new Student();
				student.setChengJi(chengJi);
				student.setIndexWeiZhi(weiZhiInteger);
				student.setJinRuXueXiao(jinRuXueXiao);
				student.setJinRuXueXiaoPingJi(pingJi_xueXiao);
				student.setName(name);
				student.setOffer(offer);
				student.setIndexXyBj(indexXyBj_Integer);
				student.setIndexMiaoShu(indexMiaoShu);
				
				
				String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
				student.setPhotoName(newImageName);
				photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.studentLieBiaoImagePath+newImageName));//保存小图片
				
				
				if(!indexPhoto.isEmpty()){
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					student.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentIndexImagePath+newImageName2));//保存首页图片图片
				}
				studentService.addStudent(student);
				
				StudentContent studentContent = new StudentContent();
				studentContent.setAnLiFenXi(anLiFenXi);
				studentContent.setAnLiJianJie(anLiJianJie);
				studentContent.setPingJunChengJi(pingJunChengJi);
				studentContent.setStudentGuid(student.getGuid());
				studentContent.setXueXiao(xueXiao);
				studentContent.setZhuanYe(zhuanYe);
				if (!picture.isEmpty()) {
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					studentContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentContentImagePath+newImageName3));//保存内容图片图片
				}
				studentContentService.addStudentContent(studentContent);
				mav.addObject("msg", "新增成功");
				mav.setViewName("forward:/lxhAdmin/student/addStudent.jsp");
				
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
	public ModelAndView update(@RequestParam("studentGuid")String studentGuid,@RequestParam("name")String name,@RequestParam("photo")MultipartFile photo,
			@RequestParam("indexPhoto")MultipartFile indexPhoto,@RequestParam("indexXyBj")String indexXyBj,
			@RequestParam("chengJi")String chengJi,@RequestParam("offer")String offer,@RequestParam("jinRuXueXiao")String jinRuXueXiao,
			@RequestParam("jinRuXueXiaoPingJi")String jinRuXueXiaoPingJi,@RequestParam("xueXiao")String xueXiao,
			@RequestParam("picture")MultipartFile picture,@RequestParam("zhuanYe")String zhuanYe,@RequestParam("indexMiaoShu")String indexMiaoShu,
			@RequestParam("pingJunChengJi")String pingJunChengJi,@RequestParam("anLiJianJie")String anLiJianJie,
			@RequestParam("anLiFenXi")String anLiFenXi,@RequestParam("indexWeiZhi")String indexWeiZhi,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				Integer pingJi_xueXiao = jinRuXueXiaoPingJi.equals("")?null:Integer.parseInt(jinRuXueXiaoPingJi);
				Integer indexXyBj_Integer = indexXyBj.equals("")?null:Integer.parseInt(indexXyBj);
				Integer weiZhiInteger = indexWeiZhi.equals("")?null:Integer.parseInt(indexWeiZhi);
				
				Student student = studentService.getStudentByGuid(studentGuid);
				student.setChengJi(chengJi);
				student.setIndexWeiZhi(weiZhiInteger);
				student.setJinRuXueXiao(jinRuXueXiao);
				student.setJinRuXueXiaoPingJi(pingJi_xueXiao);
				student.setName(name);
				student.setOffer(offer);
				student.setIndexXyBj(indexXyBj_Integer);
				student.setIndexMiaoShu(indexMiaoShu);
				
				if(!photo.isEmpty()){
					File f = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentLieBiaoImagePath+student.getPhotoName());//原列表图片
					f.delete();//删除原列表图片
					
					String newImageName = SpercialCharUtil.suiJiImageName(photo.getOriginalFilename());
					student.setPhotoName(newImageName);
					photo.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentLieBiaoImagePath+newImageName));//保存小图片
				}
				
				
				
				if(!indexPhoto.isEmpty()){
					File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentIndexImagePath+student.getIndexPhotoName());
					f2.delete();//删除首页图片
					
					String newImageName2 = SpercialCharUtil.suiJiImageName(indexPhoto.getOriginalFilename());
					student.setIndexPhotoName(newImageName2);
					indexPhoto.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentIndexImagePath+newImageName2));//保存首页图片图片
				}
				studentService.updateStudent(student);
				
				StudentContent studentContent = studentContentService.findStudentContentByStudentGuid(studentGuid);
				studentContent.setAnLiFenXi(anLiFenXi);
				studentContent.setAnLiJianJie(anLiJianJie);
				studentContent.setPingJunChengJi(pingJunChengJi);
				studentContent.setStudentGuid(student.getGuid());
				studentContent.setXueXiao(xueXiao);
				studentContent.setZhuanYe(zhuanYe);
				if (!picture.isEmpty()) {
					File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentContentImagePath+studentContent.getPictureName());
					f3.delete();//删除内容图片
					
					String newImageName3 = SpercialCharUtil.suiJiImageName(picture.getOriginalFilename());
					studentContent.setPictureName(newImageName3);
					picture.transferTo(new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentContentImagePath+newImageName3));//保存内容图片图片
				}
				studentContentService.updateStudentContent(studentContent);
				mav.addObject("msg", "修改成功");
				mav.addObject("student", student);
				mav.addObject("studentContent", studentContent);
				mav.setViewName("forward:/lxhAdmin/student/updateStudent.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("errorMsg", "数据库访问出错");
			mav.setViewName("forward:/view/fail.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value="/goUpdateStudent")
	public ModelAndView goUpdateStudent(@RequestParam("studentGuid")String studentGuid,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		AdminUser adminUser = (AdminUser)request.getSession().getAttribute("adminUserSession");
		try {
			if (adminUser==null) {
				mav.setViewName("redirect:/lxhAdmin/adminDengLu.jsp");
			}else{
				Student student = studentService.getStudentByGuid(studentGuid);
				StudentContent studentContent = studentContentService.findStudentContentByStudentGuid(studentGuid);
				mav.addObject("student", student);
				mav.addObject("studentContent", studentContent);
				mav.setViewName("forward:/lxhAdmin/student/updateStudent.jsp");
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
	public Object delete(@RequestParam("studentGuid")String studentGuid,HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		try {
			Student student = studentService.getStudentByGuid(studentGuid);
			StudentContent studentContent = studentContentService.findStudentContentByStudentGuid(studentGuid);
			
			if (student.getPhotoName()!=null) {
				File f = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.studentLieBiaoImagePath+student.getPhotoName());//原列表图片
				f.delete();//删除原列表图片
			}
			if (student.getIndexPhotoName()!=null) {
				File f2 = new File(request.getSession().getServletContext().getRealPath("/")+
						Constants.studentIndexImagePath+student.getIndexPhotoName());
				f2.delete();//删除首页图片
			}
			studentService.deleteStudent(student);
			
			if(studentContent!=null){
				if (studentContent.getPictureName()!=null) {
					File f3 = new File(request.getSession().getServletContext().getRealPath("/")+
							Constants.studentContentImagePath+studentContent.getPictureName());
					f3.delete();//删除内容图片
				}
				studentContentService.deleteStudentContent(studentContent);
			}
			
			map.put("msg","success");//删除成功
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","fail");//删除失败
		}
		return map;
	}
	
	
}
