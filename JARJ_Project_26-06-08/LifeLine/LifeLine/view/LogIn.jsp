



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LIFELINE HOSPITAL</title>
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
if (validate_required(user,"Please enter username")==false)
  {	
	user.focus();
	return false;}
if (validate_required(pwd,"Please enter password")==false)
  {
	pwd.focus();
	return false;}

}
}
</script>
</head>
<body bgcolor="999933" text="FFFFCC"  link="FFFFCC" vlink="CCFFCC" alink="CCFFCC">
<form name="Login" method="post" action="LogIn" onsubmit="return validate_form(this)">
<br>
<h3 align="center"><font face="Monotype Corsiva" size="+5"><b><i>LIFE LINE HOSPITAL</i></b></font></h3>
<hr>
<br>
<br>
<table align="center" border=0 cellpadding=10 cellspacing=10>
<tr>
<td><font face="Monotype Corsiva" size="+2"><b>User Name</b></font> </td>

<td><input type="text" name="user" >
</td>
</tr>
<tr>
<td><font face="Monotype Corsiva" size="+2"><b>Password </b></font></td>
<td> <input type="password" name="pwd"></td>
</tr>
<tr>
<th colspan=2><font face="Monotype Corsiva" size="+2"><b><input type="submit" value="Submit" ><input type="reset" value="Reset"></b></font></th>
</tr>
<tr>
<th colspan=2><a href="NewPatientRegistration.jsp">New Patient Registration</a></th>
</tr>
</table>

</form>
</body>
</html>