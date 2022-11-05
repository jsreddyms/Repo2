package com.tcs.ilp.hospital.Registration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.ilp.hospital.jdbcconnection.*;
import com.tcs.ilp.hospital.DAO.*;

/**
 * Servlet Class
 *
 * @web.servlet              name="PatientRegistration"
 *                           display-name="Name for PatientRegistration"
 *                           description="Description for PatientRegistration"
 * @web.servlet-mapping      url-pattern="/PatientRegistration"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class PatientRegistration extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,
	IOException {
	int rowInserted=0;
	PrintWriter pw=resp.getWriter();
	//pw.print("Servlet is invoke here.........");
	String p_name=req.getParameter("p_name");
	System.out.println("p_name"+p_name);
	String p_address=req.getParameter("p_address");
	System.out.println("p_address"+p_address);
	String p_gender=req.getParameter("p_gender");
	System.out.println("p_gender"+p_gender);
	String p_age=req.getParameter("p_age");
	System.out.println("p_age"+p_age);
	String p_phone=req.getParameter("p_phone");
	System.out.println("p_phone"+p_phone);
	String p_pwd=req.getParameter("p_pwd");
	System.out.println("p_pwd"+p_pwd);
	
	
	try {
		
		HospitalDAO db=new HospitalDAO();
		rowInserted=db.NewPatientRegistration(p_name,p_address,p_gender,p_age,p_phone,p_pwd);
		if(rowInserted>0)
		{
			pw.print("<html><body bgcolor='999933'text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'><p align=center>Patient successfully added to database</p></body></html>");
		}
		else
		{
			pw.print("<html><body bgcolor='999933'text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'><p align=center>Patient could not be added</p></body></html>");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		pw.print("Error in the code.....");
		
	}
}

}
