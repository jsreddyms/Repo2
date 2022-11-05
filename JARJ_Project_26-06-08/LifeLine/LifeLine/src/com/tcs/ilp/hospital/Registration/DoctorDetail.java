package com.tcs.ilp.hospital.Registration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Class
 *
 * @web.servlet              name="DoctorDetails"
 *                           display-name="Name for DoctorDetails"
 *                           description="Description for DoctorDetails"
 * @web.servlet-mapping      url-pattern="/DoctorDetails"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class DoctorDetail extends HttpServlet {
	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,
		IOException {
		System.out.println("hai");
		HttpSession session =req.getSession();
		ServletContext context=getServletContext();
		String mySession = (String)session.getAttribute("username");
		String myContext = (String)context.getAttribute("userName");

		if(mySession.equals(myContext))
			
		{
			String uname=(String)session.getAttribute("username");
			System.out.println(uname);
			String type=(String)session.getAttribute("designation");
		}
		// TODO Auto-generated method stub
	}

}
