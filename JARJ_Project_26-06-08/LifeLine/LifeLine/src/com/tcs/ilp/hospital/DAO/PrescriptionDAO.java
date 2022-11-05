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
 * @web.servlet              name="PrescriptionDAO"
 *                           display-name="Name for PrescriptionDAO"
 *                           description="Description for PrescriptionDAO"
 * @web.servlet-mapping      url-pattern="/PrescriptionDAO"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class PrescriptionDAO extends HttpServlet {

	Connection conn=oracleconnection.getConnection();

	public int NewPrescription(String p_id,String p_type,String p_details)
	{	
		System.out.println("Inside registerDoctor");
		int rowInserted=0;
		try
		{
			
		
		String prescriptionQuery="select * from LifeLinePrescription";
		
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(prescriptionQuery);
		
		
		if(rs!=null)
		{
			System.out.println("rs not null");
		
		}
		
		
		
		PreparedStatement pstmt=conn.prepareStatement("insert into LifeLinePrescription(p_id,p_type,p_details)values(?,?,?)");
		pstmt.setString(1,p_id);
		pstmt.setString(2,p_type);
		pstmt.setString(3,p_details);
		
		
				rowInserted=pstmt.executeUpdate();
		
		System.out.println("rows inserted"+rowInserted);
		if(rowInserted>0 )
		{
			System.out.println(" Prescription Details Successfully Updated");
					}
		else
		{
			System.out.println("Prescription Failed");
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



