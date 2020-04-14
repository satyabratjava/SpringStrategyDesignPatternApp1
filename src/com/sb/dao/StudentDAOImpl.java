package com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.sb.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private DataSource ds;
	private final String INSERT_STUDENT="INSERT INTO STUDENT1 VALUES (?,?,?,?,?,?)";


	private StudentDAOImpl(DataSource ds) {
		System.out.println("StudentDAOImpl.StudentDAOImpl()::1-param constructor");
		this.ds = ds;
	}



	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement pst=null;
		int count=0;
		con=ds.getConnection();
		pst=con.prepareStatement(INSERT_STUDENT);
		pst.setInt(1,bo.getSno());
		pst.setString(2,bo.getSname());
		pst.setString(3,bo.getSadd());
		pst.setInt(4,bo.getTotal());
		pst.setFloat(5, bo.getAvg());
		pst.setString(6,bo.getResult());
		count=pst.executeUpdate();
		return count;
		
		
		
	}

}
