package com.sb.controller;

import com.sb.dto.StudentDTO;
import com.sb.service.StudentOperationsService;
import com.sb.vo.StudentVO;

public class MainController {
	private StudentOperationsService service;

	private MainController(StudentOperationsService service) {
		System.out.println("MainController:1-param cons");
		this.service = service;
	}
	public String handleStudent(StudentVO vo) throws Exception
	{
		String result=null;
		StudentDTO dto=null;
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		result=service.register(dto);
		return result;
		
		
	}

}
