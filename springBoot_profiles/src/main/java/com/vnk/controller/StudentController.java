package com.vnk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vnk.sbeans.Student;
import com.vnk.servece.StudentManageService;

@Controller("control")
public class StudentController {
@Autowired
private StudentManageService manageService;

public List<Student> details() throws Exception{
	return manageService.viewDetails();
}
}
