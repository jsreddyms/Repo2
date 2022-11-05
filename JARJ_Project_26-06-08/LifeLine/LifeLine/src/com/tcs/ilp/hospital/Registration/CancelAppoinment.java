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

/**
 * Servlet Class
 *
 * @web.servlet              name="CancelAppoinment"
 *                           display-name="Name for CancelAppoinment"
 *                           description="Description for CancelAppoinment"
 * @web.servlet-mapping      url-pattern="/CancelAppoinment"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class CancelAppoinment extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,
	IOException {
	PrintWriter pw=resp.getWriter();
	int app_id=0;
	//pw.print("Servlet is invoke here.........");
	int appid=Integer.parseInt(req.getParameter("a_id"));
		
	//pw.print("Patient Id "+patientid);
	
	Connection conn=oracleconnection.getConnection();	
	
	try {
		
		
		//String strquery1="delete from LIFELINEAPPOINTMENT where a_id ="+appid;
		//Statement stmt=conn.createStatement();
		//ResultSet rs=stmt.executeQuery(strquery1);
		//PreparedStatement pstmt1=conn.prepareStatement(strquery1);
		//pstmt1.executeUpdate();
		//pw.println("Deleted");
		
		 
	    String a_date="",a_purpose="",a_pname="";
		int page1=0;
		String strquery="select * from LifeLineAppointment where a_id ="+appid+"";
		System.out.println(11);
	
		
    
    //PreparedStatement ps = conn.prepareStatement(strquery1);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(strquery);
		System.out.println(strquery);
		while(rs.next())
		{
		//	pw.println("rs is : "+rs.getInt("p_id"));
			 app_id = rs.getInt("a_id");
			 a_pname=rs.getString("p_name");
			 a_date = rs.getString("a_date");
			 a_purpose = rs.getString("a_purpose");
			 			 //pw.print("Patient Id "+patient_id);
			 
		}	
		
		if(app_id == appid )
		{  
			
			
			pw.println("<html>");
			pw.println("<body bgcolor='999933'text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'>");
			pw.println("<br><center><h3>LIFELINE HOSPITAL</h3></center><br>");
			pw.println("<br><hr><br>");
			pw.println("<table border=1 align=center cellpadding=15 cellspacing=2>");
			pw.println("<tr>");
			pw.println("<th colspan=2> Appointment Details");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Appointment ID <td>"+ app_id);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Patient Name <td>" + a_pname);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Appoinment Date <td>" + a_date);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Purpose <td>" + a_purpose);
			pw.println("</tr>");
			pw.println("<tr>");
		//	pw.println("<th colspan=2><a href='AppCancel.jsp'>Cancel Appoinment</td>");
			pw.println("</body>");
			pw.println("</html>");
			System.out.println("12");
			
			String strquery1="delete from LIFELINEAPPOINTMENT where a_id ="+appid;
			
			PreparedStatement pstmt1=conn.prepareStatement(strquery1);
			pstmt1.executeUpdate();
			
			pw.println("Appointment Cancelled sucessfully");
			System.out.println("13");
            conn.commit();
            
			
		}
		else
		{
			resp.sendRedirect("LifeLineFailure.jsp");
		}
		
		
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		pw.print("Error in the code.....");
	}
}

}
	
