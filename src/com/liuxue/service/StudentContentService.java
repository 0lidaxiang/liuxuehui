package com.liuxue.service;

import com.liuxue.entity.StudentContent;

/**
 * 学生（成功案例）内容的服务层
 * @author 李成龙
 * @date 2015-6-5
 * 
 * */

public interface StudentContentService {
	
	//添加
	public void addStudentContent(StudentContent studentContent);
	
	//通过studentGuid查询
	public StudentContent findStudentContentByStudentGuid(String studentGuid);
	
	//更新
	public void updateStudentContent(StudentContent studentContent);
	
	//删除
	public void deleteStudentContent(StudentContent studentContent);
	
}
