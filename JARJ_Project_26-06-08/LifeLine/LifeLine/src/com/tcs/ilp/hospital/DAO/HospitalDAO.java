package com.tcs.ilp.hospital.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.*;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.tcs.ilp.hospital.jdbcconnection.oracleconnection;

/**
 * Servlet Class
 *
 * @web.servlet              name="HospitalDAO"
 *                           display-name="Name for HospitalDAO"
 *                           description="Description for HospitalDAO"
 * @web.servlet-mapping      url-pattern="/HospitalDAO"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class HospitalDAO extends HttpServlet {
	Connection conn=oracleconnection.getConnection();
	public int NewPatientRegistration(String p_name,String p_address,String p_gender,String p_age,String p_phone,String p_pwd)
	{	
		System.out.println("Inside registerPatient");
		int rowInserted=0;
		int rowlogin=0;
		int patient_id =0;
		try
		{
			
		String idQuery="select max(p_id) from LifeLinePatient";
		String loginQuery="select * from LifeLineLogin";
		
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(idQuery);
		ResultSet rs1=stmt.executeQuery(loginQuery);
		
		if(rs!=null)
		{
			System.out.println("rs not null");
		while(rs.next())
		{
			patient_id =Integer.parseInt(rs.getString(1));
			
			System.out.println("patient_id"+patient_id);
		}
		}
		
		if(patient_id==0)
		{
			patient_id=100;
		}
		else
		{
			patient_id=patient_id+1;
		}
		
		PreparedStatement pstmt=conn.prepareStatement("insert into LifeLinePatient(p_id,p_name,p_address,p_gender,p_age,p_phone,p_pwd,p_date)values(?,?,?,?,?,?,?,sysdate)");
		pstmt.setInt(1,patient_id);
		pstmt.setString(2,p_name);
		pstmt.setString(3,p_address);
		pstmt.setString(4,p_gender);
		pstmt.setString(5,p_age);
		pstmt.setString(6,p_phone);
		pstmt.setString(7,p_pwd);
		
		PreparedStatement pstmt1=conn.prepareStatement("insert into LifeLineLogin(username,password,Designation)values(?,?,'Patient')");
		pstmt1.setString(1,p_name);
		pstmt1.setString(2,p_pwd);
		
				rowInserted=pstmt.executeUpdate();
				rowlogin=pstmt1.executeUpdate();
		System.out.println("rows inserted"+rowInserted);
		if(rowInserted>0 && rowlogin>0)
		{
			System.out.println("Patient Registered");
		}
		else
		{
			System.out.println("Patient not Registered");
		}
		
		
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in the code.....");
		}
		return rowInserted;
	}
	
	
	
	
	
	
	

}
