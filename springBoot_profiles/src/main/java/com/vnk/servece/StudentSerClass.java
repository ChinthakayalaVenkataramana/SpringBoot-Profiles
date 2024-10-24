package com.vnk.servece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnk.dao.StudentDAO;
import com.vnk.sbeans.Student;
@Service("service")
public class StudentSerClass implements StudentManageService {
@Autowired
private StudentDAO dao;
	@Override
	public List<Student> viewDetails() throws Exception {
		return dao.viewtStudent();
	}

}
