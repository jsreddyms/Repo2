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
 * @web.servlet              name="EnterPrescriptionDetail"
 *                           display-name="Name for EnterPrescriptionDetail"
 *                           description="Description for EnterPrescriptionDetail"
 * @web.servlet-mapping      url-pattern="/EnterPrescriptionDetail"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class EnterPrescriptionDetail extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,
		IOException {
		int rowInserted=0;
		PrintWriter pw=resp.getWriter();
		//pw.print("Servlet is invoke here........");
		String p_id=req.getParameter("p_id");
		System.out.println("p_id"+p_id);
		String p_type=req.getParameter("p_type");
		System.out.println("p_type"+p_type);
		
		String p_details=req.getParameter("p_details");
		System.out.println("p_details"+p_details);
		
		
		try {
			
			PrescriptionDAO db=new PrescriptionDAO();
			rowInserted=db.NewPrescription(p_id,p_type,p_details);
			if(rowInserted>0)
			{
				pw.print("<html><body bgcolor='999933'text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'><p align=center>Prescrption successfully added to database</p></body></html>");
			}
			else
			{
				pw.print("<html><body bgcolor='999933' text='FFFFCC' link='FFFFCC' vlink='CCFFCC' alink='CCFFCC'><p align=center>Prescription could not be added</p></body></html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.print("Error in the code.....");
			
		}
	}

	}
