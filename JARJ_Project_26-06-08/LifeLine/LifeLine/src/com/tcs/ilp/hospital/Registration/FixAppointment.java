package com.tcs.ilp.hospital.Registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.hospital.DAO.AppointmentDAO;

/**
 * Servlet Class
 *
 * @web.servlet              name="FixAppointment"
 *                           display-name="Name for FixAppointment"
 *                           description="Description for FixAppointment"
 * @web.servlet-mapping      url-pattern="/FixAppointment"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class FixAppointment extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,
	IOException {
	// TODO Auto-generated method stub
		int rowInserted=0;
		PrintWriter pw=resp.getWriter();
		//pw.print("Servlet is invoke here.........");
		String p_name=req.getParameter("pname");
		System.out.println("pname"+p_name);
		String a_date=req.getParameter("adate");
		System.out.println("adate"+a_date);
		String a_time=req.getParameter("atime");
		System.out.println("atime"+a_time);
		String a_purpose=req.getParameter("apurpose");
		System.out.println("apurpose"+a_purpose);
	
	
	try {
		
		AppointmentDAO db=new AppointmentDAO();
		rowInserted=db.NewAppointment(p_name,a_date,a_time,a_purpose);
				
		if(rowInserted>0)
		{
			pw.println("<html>");
			pw.println("<body bgcolor='999933' text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'>");
			pw.println("<br><center><h3>LIFELINE HOSPITAL</h3></center><br>");
			pw.println("<br><hr><br>");
			pw.println("<table border=1 align=center cellpadding=15 cellspacing=2>");
			pw.println("<tr>");
			pw.println("<th colspan=2> Appointment Details");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Patient Name <td>" + p_name);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Appointment Date <td>" + a_date);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Appoinment Time <td>" + a_time);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.print("<html><body><p align=center>Appointment successfully added to database</p></body></html>");
		}
		else
		{
			pw.print("<html><body><p align=center>Appointment could not be added</p></body></html>");
		}
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		pw.print("Error in the code.....");
	}
	
	}
}
