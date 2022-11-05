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
 * @web.servlet              name="AppointmentDAO"
 *                           display-name="Name for AppointmentDAO"
 *                           description="Description for AppointmentDAO"
 * @web.servlet-mapping      url-pattern="/AppointmentDAO"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class AppointmentDAO extends HttpServlet {

	Connection conn=oracleconnection.getConnection();
	
	public int NewAppointment(String p_name,String a_date,String a_time,String a_purpose)
	{	
		System.out.println("Inside registerAppointment");
		int rowInserted=0;
		int appointment_id =0;
		try
		{
			
		
		String appQuery="select * from LifeLineAppointment";
		
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(appQuery);
		
		
		if(rs!=null)
		{
			System.out.println("rs not null");
		
			while(rs.next())
		{
		    appointment_id =Integer.parseInt(rs.getString(1));
			
			System.out.println("appointment_id"+appointment_id);
		}
		}
		
		if(appointment_id==0)
		{
			appointment_id=100;
		}
		else
		{
			appointment_id=appointment_id+1;
		}
		
		PreparedStatement pstmt=conn.prepareStatement("insert into LifeLineAppointment(a_id,p_name,a_date,a_time,a_purpose)values(?,?,?,?,?)");
		pstmt.setInt(1,appointment_id);
		pstmt.setString(2,p_name);
		pstmt.setString(3,a_date);
		pstmt.setString(4,a_time);
		pstmt.setString(5,a_purpose);
		
		
		rowInserted=pstmt.executeUpdate();
	
		System.out.println("rows inserted"+rowInserted);
		if(rowInserted>0 )
		{
			System.out.println("Appointment Registered");
		}
		else
		{
			System.out.println("Appointment not Registered");
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
	

