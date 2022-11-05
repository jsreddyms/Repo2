import java.sql.*;

import oracle.jdbc.*;

class JDBCVersion
{
   public static void main (String args[])
          throws SQLException
   {
      // Load the Oracle JDBC driver
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "scott",	"scott");

      // Create Oracle DatabaseMetaData object
      DatabaseMetaData meta = conn.getMetaData();

      // gets driver info:
      System.out.println("JDBC driver version is " + meta.getDriverVersion());
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("Select * from emp");
      while(rs.next()){
    	  //String str = rs.getString(0);
    	  //System.out.println("str:" + str);
    	  String strName = rs.getString(1);
    	  System.out.println("strName:" + strName);
      }
  
   }
}
