package com.tcs.ilp.hospital.Login;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import java.io.PrintWriter;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcs.ilp.hospital.jdbcconnection.*;





/**
 * Servlet Class
 *
 * @web.servlet              name="LogIn"
 *                           display-name="Name for LogIn"
 *                           description="Description for LogIn"
 * @web.servlet-mapping      url-pattern="/LogIn"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class LogIn extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,
	IOException {
	// TODO Auto-generated method stub
	PrintWriter pw=resp.getWriter();
	
	HttpSession mysession=req.getSession(true);
	ServletConfig myconfig = getServletConfig();
	ServletContext mycontext = myconfig.getServletContext();
	
	pw.print("Servlet is invoke here.........");
	String userName=req.getParameter("user");
	String password=req.getParameter("pwd");
	
	pw.print("user : "+userName);
	pw.print("password : "+password);
	
	Connection conn = null;
	
	try {
		pw.print("try block");
		String login_name="",login_password="",designation="";
		String strquery="select * from LifeLineLogin where username ='"+userName+"' and password ='"+password+"'";
		pw.print("before connection");
		//Connection conn=oracleconnection.getConnection();
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("After connection");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(strquery);
		System.out.println(strquery);
		while(rs.next())
		{
			System.out.println("rs is : "+rs.getString("username"));
			login_name=rs.getString("username");
			
			login_password=rs.getString("password");
			designation=rs.getString("designation");
			System.out.println("designation"+designation);
		}
		if(login_name.equals(userName)&&login_password.equals(password))
		{
			System.out.println("Inside if");
			
			mysession.setAttribute("username",userName);
			mysession.setAttribute("designation",designation);
			mycontext.setAttribute("userName",userName);
			mycontext.setAttribute("designation",designation);
			
			
			if( designation.equals("Receptionist"))
			{
				resp.sendRedirect("ReceiptionistHome.jsp");
			}
			if(designation.equals("Doctor"))
			{
				resp.sendRedirect("DoctorHome.jsp");
			}
			if(designation.equals("Patient"))
			{
				resp.sendRedirect("Patient.jsp");
			}
			
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




