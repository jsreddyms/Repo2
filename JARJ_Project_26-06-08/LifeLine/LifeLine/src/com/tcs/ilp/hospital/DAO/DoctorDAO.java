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
 * @web.servlet              name="DoctorDAO"
 *                           display-name="Name for DoctorDAO"
 *                           description="Description for DoctorDAO"
 * @web.servlet-mapping      url-pattern="/DoctorDAO"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class DoctorDAO extends HttpServlet {
	
	Connection conn=oracleconnection.getConnection();

	public int NewDoctorRegistration(String d_name,String d_special, String d_address,String d_gender,String d_phone,String d_pwd)
	{	
		System.out.println("Inside registerDoctor");
		int rowInserted=0;
		int rowlogin=0;
		int doctor_id =0;
		try
		{
			
		String idQuery="select max(d_id) from LifeLineDoctor";
		String loginQuery="select * from LifeLineLogin";
		
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(idQuery);
		ResultSet rs1=stmt.executeQuery(loginQuery);
		
		if(rs!=null)
		{
			System.out.println("rs not null");
		while(rs.next())
		{
			doctor_id =Integer.parseInt(rs.getString(1));
			
			System.out.println("doctor_id"+doctor_id);
		}
		}
		
		if(doctor_id==0)
		{
			doctor_id=1000;
		}
		else
		{
			doctor_id=doctor_id+1;
		}
		
		PreparedStatement pstmt=conn.prepareStatement("insert into LifeLineDoctor(d_id,d_name,d_special,d_address,d_gender,d_phone,d_pwd)values(?,?,?,?,?,?,?)");
		pstmt.setInt(1,doctor_id);
		pstmt.setString(2,d_name);
		pstmt.setString(3,d_special);
		pstmt.setString(4,d_address);
		pstmt.setString(5,d_gender);
		pstmt.setString(6,d_phone);
		pstmt.setString(7,d_pwd);
		
		PreparedStatement pstmt1=conn.prepareStatement("insert into LifeLineLogin(username,password,Designation)values(?,?,'Doctor')");
		pstmt1.setString(1,d_name);
		pstmt1.setString(2,d_pwd);
		
				rowInserted=pstmt.executeUpdate();
				rowlogin=pstmt1.executeUpdate();
		System.out.println("rows inserted"+rowInserted);
		if(rowInserted>0 && rowlogin>0)
		{
			System.out.println("Doctor Registered");
			System.out.println("Doctor Id : "+doctor_id);
		}
		else
		{
			System.out.println("Doctor not Registered");
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
