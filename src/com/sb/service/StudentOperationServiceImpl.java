package com.sb.service;

import com.sb.bo.StudentBO;
import com.sb.dao.StudentDAO;
import com.sb.dto.StudentDTO;

public class StudentOperationServiceImpl implements StudentOperationsService {
private	StudentDAO dao;


	private StudentOperationServiceImpl(StudentDAO dao) {
	System.out.println("StudentOperationServiceImpl:1-param cons");
	this.dao = dao;
}


	@Override
	public String register(StudentDTO dt) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		int count=0;
		total=dt.getM1()+dt.getM2()+dt.getM3();
		avg=total/3.0f;
		if(dt.getM1()<35||dt.getM2()<35||dt.getM3()<35)
		
			result="fail";
		
		else
			result="pass";
		
		StudentBO bo=new StudentBO();
		bo.setSno(dt.getSno());
		bo.setSname(dt.getSname());
		bo.setSadd(dt.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		count=dao.insert(bo);
		if(count==0)
			return "registration failed";
		else
			return "registration Success="+total+"avg="+avg+"result"+result;
		
		
	}

}
