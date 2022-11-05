package com.tcs.ilp.hospital.Registration;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.ilp.hospital.jdbcconnection.*;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet Class
 *
 * @web.servlet              name="PrescriptionUpdate"
 *                           display-name="Name for PrescriptionUpdate"
 *                           description="Description for PrescriptionUpdate"
 * @web.servlet-mapping      url-pattern="/PrescriptionUpdate"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class PrescriptionUpdate extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,
	IOException {
	PrintWriter pw=resp.getWriter();
	int patient_id=0;
	//pw.print("Servlet is invoke here.........");
	int patientid=Integer.parseInt(req.getParameter("p_id"));
		
	//pw.print("Patient Id "+patientid);
			
	try {
		
		
		String pname="",pgender="";
		int page1=0;
		String strquery="select * from LifeLinePatient where p_id ="+patientid+"";
	
		Connection conn=oracleconnection.getConnection();
		
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(strquery);
		System.out.println(strquery);
		while(rs.next())
		{
		//	pw.println("rs is : "+rs.getInt("p_id"));
			 patient_id = rs.getInt("p_id");
			 pname = rs.getString("p_name");
			 pgender = rs.getString("p_gender");
			 page1 = rs.getInt("p_age");
			 //pw.print("Patient Id "+patient_id);
			 
		}	
		
		if(patient_id == patientid )
		{  
			
			
			pw.println("<html>");
			pw.println("<body bgcolor='999933' text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'>");
			pw.println("<br><center><h3>LIFELINE HOSPITAL</h3></center><br>");
			pw.println("<br><hr><br>");
			pw.println("<table border=1 align=center cellpadding=15 cellspacing=2>");
			pw.println("<tr>");
			pw.println("<th colspan=2> Patient Details");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Patient ID <td>"+ patient_id);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Patient Name <td>" + pname);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Patient Gender <td>" + pgender);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Patient Age <td>" + page1);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th colspan=2><a href='EnterPrescription.jsp'>Enter Prescription Details</td>");
			pw.println("</body>");
			pw.println("</html>");
			
		}
		else
		{
			resp.sendRedirect("LifeLineFailure.jsp");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		pw.print("Error in the code.....");
	}
}

}
	