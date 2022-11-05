<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="999933" text="FFFFCC" link="FFFFCC" vlink="CCFFCC" alink="CCFFCC">
<form name="appoinment" method="post" action="FixAppointment">
<h1 align="center"><font face="Monotype Corsiva" ><b><i>LIFE LINE HOSPITAL</i></b></font></h1>
<hr>
<br>
<table border=0 cellpadding=10 cellspacing=2 align="center">
<tr>
<th colspan=2><font face="Times New Roman" size="+1" color="FFFFCC">Appoinment Details</th>
</tr>
<tr>
<td><font face="Times New Roman" size="+1" color="FFFFCC">Patient Name<td><input type=text name="pname">
</tr>
<tr>
<td><font face="Times New Roman" size="+1" color="FFFFCC">Date<td><input type=text name="adate">
</tr>
<tr>
<td><font face="Times New Roman" size="+1" color="FFFFCC">Time<td><input type=text name="atime"><select>
<option>am
<option>pm
</option></select>
</tr>
<tr>
<td><font face="Times New Roman" size="+1" color="FFFFCC">Purpose<td><input type=text name="apurpose">
</tr>
<tr>
<th colspan=2><input type="submit" value="Submit" ><input type="Reset" value="Reset">
</tr>
</table>
</form>
</body>
</html>