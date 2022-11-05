package com.tcs.ilp.hospital.Registration;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.ilp.hospital.jdbcconnection.*;

/**
 * Servlet Class
 *
 * @web.servlet              name="Bill"
 *                           display-name="Name for Bill"
 *                           description="Description for Bill"
 * @web.servlet-mapping      url-pattern="/Bill"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class Bill extends HttpServlet {
	
	Connection conn=oracleconnection.getConnection();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,IOException 
	{
		PrintWriter pw=resp.getWriter();
		int patient_id=0;
		int patientid=Integer.parseInt(req.getParameter("p_id"));
		
		try {
			
			String pname="",pgender="", pdetails="";
			int page1=0;
			
			String strquery="select * from LifeLinePatient where p_id ="+patientid+"";
	//		String strquery1="select * from LifeLinePrescription where p_id ="+patientid+"";
		
			Statement stmt = conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(strquery);
		//	ResultSet rs1=stmt.executeQuery(strquery1);
			
			while(rs.next())
			{
			//	pw.println("rs is : "+rs.getInt("p_id"));
				 patient_id = rs.getInt("p_id");
				 pname = rs.getString("p_name");
				 pgender = rs.getString("p_gender");
				 page1 = rs.getInt("p_age");
				 //pw.print("Patient Id "+patient_id);
				
				 
			}
			
			
			/* while(rs1.next())
			{
				pw.println("rs is : "+rs.getInt("p_id"));
				pdetails = rs1.getString("p_details");
				 
				 
			}*/ 
			
			 if(rs!=null)
			{  
				
				
				pw.println("<html>");
				pw.println("<body bgcolor='999933' text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'>");
				pw.println("<br><center><h3>LIFELINE HOSPITAL</h3></center><br>");
				pw.println("<br><hr><br>");
				pw.println("<table border=1 align=center cellpadding=15 cellspacing=2>");
				pw.println("<tr>");
				pw.println("<th colspan=2> Patient Bill Details");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td colspan=2 align=right>Patient ID :  <td>"+ patient_id);
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td colspan=2 align=right>Patient Name :  <td>" + pname);
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td colspan=2 align=right>Gender :  <td>" + pgender);
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td colspan=2 align=right > Age :  <td>" + page1);
				pw.println("</tr>");
				
				pw.println("<tr>");
				pw.println("<th colspan=2> Particulars</th>");
				pw.println("</tr>");
				//pw.println("<td>"+pdetails);
				
				pw.println("</table>");
				
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
