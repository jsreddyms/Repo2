<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LifeLine Hospital</title>
</head>
<body bgcolor="999933" text="FFFFCC" link="FFFFCC" vlink="CCFFCC" alink="CCFFCC">
<h1 align="center"><font face="Monotype Corsiva" ><b><i>LIFE LINE HOSPITAL</i></b></font></h1>

<hr>
<%
	String mySession = (String)session.getAttribute("username");
	String myContext = (String)application.getAttribute("userName");

	if(mySession.equals(myContext))
	{
%>
<h4>
Welcome <%String uname=(String)session.getAttribute("username");%><%=uname %>
<br>
<%String type=(String)session.getAttribute("designation"); %><%=type %>
</h4>
<% } %>

<table  align="center" cellpadding=8 cellspacing=10>

<tr><td><a href="NewPatientRegistration.jsp"><font face="Times New Roman" size="+1" color="FFFFCC">New Patient Registration</a></td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">Upgrade Existing Patient Details</td></tr>
<tr><td><a href="NewDoctor.jsp"><font face="Times New Roman" size="+1" color="FFFFCC">Doctor Maintainance</a></td></tr>
<tr><td><a href="BillGeneratation.jsp"><font face="Times New Roman" size="+1" color="FFFFCC">Bill Generation</a></td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">Appoinment Maintainance</td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">.................<a href="Appointment.jsp"><font face="Times New Roman" size="+1" color="FFFFCC">Make Appoinment</a></td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">.................<a href="CancelAppointment.jsp">Cancel Appoinment</a></td></tr>
<tr><td><a href=""><font face="Times New Roman" size="+1" color="FFFFCC">Report Generation</td></tr>
<tr><td ><a href="LogIn.jsp"><font face="Times New Roman" size="+1" color="FFFFCC"><b>Logout</a></td></tr>

</table>
</body>
</html>