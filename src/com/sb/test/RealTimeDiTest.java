
package com.sb.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.sb.controller.MainController;
import com.sb.vo.StudentVO;

public class RealTimeDiTest {
public static void main(String[] args) {
	try {
		
		BeanFactory factory;
		MainController controller;
		String result;
		Scanner sc;
		String sno=null,sname=null,sadd=null,m1=null,m2=null,m3=null;
		factory=new XmlBeanFactory(new ClassPathResource("com/sb/cnfg/ApplicationContext.xml"));
		controller=factory.getBean("stuController",MainController.class);
		sc=new Scanner(System.in);
		System.out.println("enter your sno");
		sno=sc.next();
		System.out.println("enter your sname");
		sname=sc.next();
		System.out.println("enter your sadd");
		sadd=sc.next();
		System.out.println("enter your m1");
		m1=sc.next();
		System.out.println("enter your m2");
		m2=sc.next();
		System.out.println("enter your m3");
		m3=sc.next();
		StudentVO vo =new StudentVO();
		vo.setSno(sno);vo.setSname(sname);vo.setSadd(sadd);vo.setM1(m1);vo.setM2(m2);vo.setM3(m3);
		result=controller.handleStudent(vo);
		System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("registration failed");
	}
}
}
