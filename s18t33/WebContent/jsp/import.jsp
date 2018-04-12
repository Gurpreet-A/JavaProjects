<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b> Import data to table</b><br>
<h3>A demonstration of how the screen will look </h3>

<input type="file" id="myFile">

<p>Click the "Try it" button to disable the file upload button.</p>

<button onclick="myFunction()">Try it</button>

<script>
function myFunction() {
    var x = document.getElementById("myFile");
    x.disabled = true;
}
</script>

</body>

</html>