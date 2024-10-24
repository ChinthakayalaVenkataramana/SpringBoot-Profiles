package com.vnk;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vnk.controller.StudentController;
import com.vnk.sbeans.Student;

@SpringBootApplication
public class SpringBootProfilesApplication {

	public static void main(String[] args) {
	ApplicationContext app=	SpringApplication.run(SpringBootProfilesApplication.class, args);
	
	StudentController sc=app.getBean("control",StudentController.class);
	try {
		List<Student> list=sc.details();
	    list.forEach(st->{
			System.out.println(st.getClientEmail()+" "+st.getClientName()+" "+st.getClientId()+" "+st.getClientMobileNo());
		});
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

}
