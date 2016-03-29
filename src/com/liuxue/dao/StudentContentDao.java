package com.liuxue.dao;

import org.springframework.stereotype.Repository;

import com.liuxue.entity.StudentContent;

/**
 * 学生（成功案例）内容的数据库操作库
 * @author 李成龙
 * @date 2015-06-05
 * 
 * */

@Repository
public class StudentContentDao extends BaseDao<StudentContent>{

	//通过studentGuid查找
	public StudentContent findbyStudentGuid(String studentGuid){
		String hql = "from StudentContent s where s.studentGuid=?";
		List<StudentContent> list = (List<StudentContent>)getHibernateTemplate().find(hql, studentGuid);
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
}
