package com.liuxue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxue.dao.StudentContentDao;
import com.liuxue.entity.StudentContent;
import com.liuxue.service.StudentContentService;

@Service
public class StudentContentServiceImpl implements StudentContentService{

	@Autowired
	private StudentContentDao studentContentDao;
	
	public void addStudentContent(StudentContent studentContent) {
		studentContentDao.save(studentContent);
	}

	public StudentContent findStudentContentByStudentGuid(String studentGuid) {
		return studentContentDao.findbyStudentGuid(studentGuid);
	}

	public void deleteStudentContent(StudentContent studentContent) {
		studentContentDao.remove(studentContent);
	}

	public void updateStudentContent(StudentContent studentContent) {
		studentContentDao.update(studentContent);
	}

}
