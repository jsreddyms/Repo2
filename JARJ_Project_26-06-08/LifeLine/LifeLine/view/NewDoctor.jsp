<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Doctor Registration</title>
<script type="text/javascript">
function validate_required(field,alerttxt)
{

with (field)
{
	if (value==null||value=="")
  	{
		alert(alerttxt);
		return false;
	}
	else 
	{
		return true;
	}
}
}

function validate_form(thisform)
{

with (thisform)
{
if (validate_required(d_name,"Enter Doctor name")==false)
  {	
	d_name.focus();
	return false;
	}
if (validate_required(d_address,"Enter address")==false)
  {
	d_address.focus();
	return false;
 }
if (validate_required(d_special,"Enter Specialisation")==false)
  {	
	d_special.focus();
	return false;
 }

if (validate_required(d_phone,"Enter phone number")==false)
  {	
	d_phone.focus();
	return false;
 }
 if (validate_required(d_pwd,"Enter Password")==false)
  {	
	d_pwd.focus();
	return false;
 }
}
}
</script>
</head>
<body bgcolor="999933" text="FFFFCC" link="FFFFCC" vlink="CCFFCC" alink="CCFFCC">
<form name="DoctorRegistration" method="post" action="DoctorRegistration" onsubmit="return validate_form(this)">
<h1 align="center"><font face="Monotype Corsiva" ><b><i>LIFE LINE HOSPITAL</i></b></font></h1>
<hr>

<table align="center" cellpadding=10 cellspacing=10>
<tr><th colspan=2><h3><font face="Times New Roman" size="+1" color="FFFFCC">New Doctor Registration</h3>
</td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Doctor Name </td><td> <input type="text" name="d_name">
</td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Specialisation</td><td> <input type="text" name="d_special">
</td></tr>

<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Doctor Address </td><td> <input type="text" name="d_address">
</td></tr>
<tr>
	<td><font face="Times New Roman" size="+1" color="FFFFCC">Gender</td>
	<td><input type="radio" name="d_gender" value="M"> <font face="Times New Roman" size="+1" color="FFFFCC">Male<input type="radio" name="d_gender" value="F"><font face="Times New Roman" size="+1" color="FFFFCC"> Female</td>
</tr>


<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Contact Number </td><td> <input type="text" name="d_phone">
</td></tr>

<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Password</td><td> <input type="password" name="d_pwd">
</td></tr>

<tr><th colspan=2><input type="submit" value="submit">
<input type="Reset" value="Reset" ></th></tr>
<tr><th colspan=2><a href="ReceiptionistHome.jsp"><font face="Times New Roman" size="+1" color="FFFFCC">Back &nbsp;</a><a href="LogIn.jsp"><font face="Times New Roman" size="+1" color="FFFFCC"><b>Logout</a></th></tr>
</table>
</form>

</body>
</html>