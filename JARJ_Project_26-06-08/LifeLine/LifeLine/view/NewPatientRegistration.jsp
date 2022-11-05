<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LifeLine Hospital</title>
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
if (validate_required(p_name,"Enter patient name")==false)
  {	
	p_name.focus();
	return false;
	}
if (validate_required(p_address,"Enter address")==false)
  {
	p_address.focus();
	return false;
 }
if (validate_required(p_age,"Enter age")==false)
  {	
	p_age.focus();
	return false;
 }

if (validate_required(p_phone,"Enter phone number")==false)
  {	
	p_phone.focus();
	return false;
 }
 if (validate_required(p_pwd,"Enter Password")==false)
  {	
	p_pwd.focus();
	return false;
 }
}
}
</script>
</head>
<body bgcolor="999933" text="FFFFCC" link="FFFFCC" vlink="CCFFCC" alink="CCFFCC">
<h1 align="center"><font face="Monotype Corsiva" ><b><i>LIFE LINE HOSPITAL</i></b></font></h1>
<form name="registration" method="post" action="PatientRegistration" onsubmit="return validate_form(this)">
<table align="center" cellpadding=10 cellspacing=10>
<tr><th colspan=2><h3>New Patient Registration</h3>
</td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Patient Name </td><td> <input type="text" name="p_name">
</td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Patient Address </td><td> <input type="text" name="p_address">
</td></tr>
<tr>
	<td><font face="Times New Roman" size="+1" color="FFFFCC">Gender</td>
	<td><input type="radio" name="p_gender" value="M"><font face="Times New Roman" size="+1" color="FFFFCC"> Male<input type="radio" name="p_gender" value="F"> <font face="Times New Roman" size="+1" color="FFFFCC">Female</td>
</tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Patient Age </td><td> <input type="text" name="p_age">
</td></tr>


<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Contact Number </td><td> <input type="text" name="p_phone">
</td></tr>
<tr><td><font face="Times New Roman" size="+1" color="FFFFCC">
Password</td><td> <input type="password" name="p_pwd">
</td></tr>

<tr><th colspan=2><input type="submit" value="submit">
<input type="Reset" value="Reset" ></th></tr>
<tr><th colspan=2><a href="LogIn.jsp"><font face="Times New Roman" size="+1" color="FFFFCC">Logout</a></th></tr>
</table>
</form>
</body>
</html>