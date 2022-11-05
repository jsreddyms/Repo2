package com.tcs.ilp.hospital.jdbcconnection;

import java.sql.*;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Servlet Class
 *
 * @web.servlet              name="oracleconnection"
 *                           display-name="Name for oracleconnection"
 *                           description="Description for oracleconnection"
 * @web.servlet-mapping      url-pattern="/oracleconnection"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class oracleconnection extends HttpServlet {
	
	static Connection conn = null;
	public static Connection getConnection(){
				
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","scott");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}


}
