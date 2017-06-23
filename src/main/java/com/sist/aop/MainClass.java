package com.sist.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.StudentDAO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml"); 
		StudentDAO dao=(StudentDAO)app.getBean("studentDAO");
		dao.stdUpdate();
		dao.stdDelete();
		dao.stdInsert();
	}
}
