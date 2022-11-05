<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="999933" text="FFFFCC" link="FFFFCC" vlink="CCFFCC" alink="CCFFCC">
<h1 align="center"><font face="Monotype Corsiva" ><b><i>LIFE LINE HOSPITAL</i></b></font></h1>

<br>
<%
	String mySession = (String)session.getAttribute("username");
	String myContext = (String)application.getAttribute("userName");

	if(mySession.equals(myContext))
	{
%>

<hr>
<h4>
Welcome <%String uname=(String)session.getAttribute("username");%><%=uname %>
<br>
<%String type=(String)session.getAttribute("designation"); %><%=type %>
</h4>
<% } %>
<br><br>
<table  align="center" cellpadding=10 cellspacing=10>

<tr><td><a href="Prescription.jsp"><font face="Times New Roman" size="+1" color="FFFFCC"><b>Prescription Details</a></td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC"><b>Personal Details</a></td></tr>

<tr><td align="center"><a href="LogIn.jsp"><font face="Times New Roman" size="+1" color="FFFFCC"><b>Logout</a></td></tr>


</table>

</body>
</html>