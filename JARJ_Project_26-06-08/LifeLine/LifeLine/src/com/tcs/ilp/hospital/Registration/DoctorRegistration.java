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
 * @web.servlet              name="DoctorRegistration"
 *                           display-name="Name for DoctorRegistration"
 *                           description="Description for DoctorRegistration"
 * @web.servlet-mapping      url-pattern="/DoctorRegistration"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class DoctorRegistration extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,
		IOException {
		// TODO Auto-generated method stub
		int rowInserted=0;
		PrintWriter pw=resp.getWriter();
		//pw.print("Servlet is invoke here.........");
		String d_name=req.getParameter("d_name");
		System.out.println("d_name"+d_name);
		String d_special=req.getParameter("d_special");
		System.out.println("d_special"+d_special);
		String d_address=req.getParameter("d_address");
		System.out.println("d_address"+d_address);
		String d_gender=req.getParameter("d_gender");
		System.out.println("d_gender"+d_gender);
		String d_phone=req.getParameter("d_phone");
		System.out.println("d_phone"+d_phone);
		String d_pwd=req.getParameter("d_pwd");
		System.out.println("d_pwd"+d_pwd);
		
		
		try {
			
			DoctorDAO db=new DoctorDAO();
			rowInserted=db.NewDoctorRegistration(d_name,d_special,d_address,d_gender,d_phone,d_pwd);
			if(rowInserted>0)
			{
				pw.print("<html><body bgcolor='999933'text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'><p align=center>Doctor successfully added to database</p></body></html>");
			}
			else
			{
				pw.print("<html><body bgcolor='999933'text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'><p align=center>Doctor could not be added</p></body></html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.print("Error in the code.....");
			
		}
	}

	}
