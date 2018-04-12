<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script>
<script>
function formValidation2()
{
	var uid = document.Navigation.username;
	var passid = document.bookMyMovie.password;
	var hostname = document.bookMyMovie.dbHostName;

	if  (uid.value.length==0){
		
		alert("Please enter a register username");
		uid.focus();
		return false;
	}
	
	else{
		if (passid.value.length==0){
			
			alert("Please enter a password for a given username");
			passid.focus();
			return false;
		}
		
		else
			if (hostname.value.length==0){
				
				alert("Please enter a hostname for the Database");
				hostname.focus();
				return false;
			}
			else
				{
				return true;
				}
	}
}

</script>
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login Page</title>
</head>
  <body onload="document.Navigation.userName.focus();">    
<jsp:useBean id="dbAccess" scope="session" class="Controller.DataBaseAccessBean"> </jsp:useBean>
<h1>Login </h1>
<center><form action="/s18t3/NavigationServlet?action=login" method="post" >
UserName:<input type="text" name="userName" value="${dbAccess.userName}" /><br/><br />
Password:<input type="text" name="passWord" value="${dbAccess.passWord}" /><br/><br/>
HostName :<input type="text" name="dbHostName" value="${dbAccess.dbHostName}"/><br/><br/>
Database Type
<select>
  <option value="MYSQL">MYSQL</option>
  <option value="Oracle">Oracle</option>
  <option value="DB2">DB2</option>
</select>
<br></br>
<input type="submit" name="Login"/>
</form>
</center>
</body>
</html>