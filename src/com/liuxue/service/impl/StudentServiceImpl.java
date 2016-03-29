package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.Page;
import com.liuxue.dao.StudentDao;
import com.liuxue.entity.Student;
import com.liuxue.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	public void addStudent(Student student) {
		studentDao.save(student);
	}

	public Student getStudentByGuid(String studentGuid) {
		return studentDao.get(studentGuid);
	}

	public Page page(int pageNo, int pageSize) {
		return studentDao.page(pageNo, pageSize);
	}

	public List<Student> findIndexStudent() {
		return studentDao.findIndexStudent();
	}

	public void deleteStudent(Student student) {
		studentDao.remove(student);
	}

	public void updateStudent(Student student) {
		studentDao.update(student);
	}

}
