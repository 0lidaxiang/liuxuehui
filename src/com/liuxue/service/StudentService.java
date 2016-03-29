package com.liuxue.service;

import com.liuxue.dao.Page;
import com.liuxue.entity.Student;

/**
 * 学生（成功案例）服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface StudentService {

	//添加
	public void addStudent(Student student);
	
	//分页
	public Page page(int pageNo,int pageSize);
	
	//通过主键guid获取
	public Student getStudentByGuid(String studentGuid);
	
	//查询到主页选用的
	public List<Student> findIndexStudent();
	
	//更新
	public void updateStudent(Student student);
	
	//删除
	public void deleteStudent(Student student);
}
