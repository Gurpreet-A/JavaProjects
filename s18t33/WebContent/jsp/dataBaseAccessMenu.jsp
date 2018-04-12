<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>DataBaseAccessMenuPage</title>
</head>
<body>

<jsp:useBean id="dbAccess" scope="session" class="Controller.DataBaseAccessBean"> </jsp:useBean>
 <form action="/s18t33/NavigationServlet?action=executeQuery" method="post">

	<center> 
	<a href="jsp/DatabaseManagment.jsp">Database Management</a><br></br>
	<a href="jsp/import.jsp">Import Excel file</a><br></br>
	<a href="jsp/export.jsp">Export Excel file</a><br></br>
	<a href="jsp/Statistical Analysis.jsp">Statistical Analysis</a><br></br>
	<a href="jsp/Data Visualization.jsp">Data Visualization</a><br></br>
	<a href="jsp/logout.jsp">Logout</a></center>
</body>
</html>