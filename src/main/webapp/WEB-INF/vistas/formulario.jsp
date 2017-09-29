<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<div class = "container">
	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                 
         <form:form action="saludo"  method="POST" modelAttribute="persona">
         
	    	<h3 class="form-signin-heading">Taller Web I</h3>
			<hr class="colorgraph">
			</br>

			<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
			
			<form:input path="nombre" id="nombre" type="text" class="form-control" />
			<form:input path="apellido" id="email" type="text" class="form-control" />
			
			<form:input path="mail" id="mail" type="email" class="form-control" />					     		  
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Saludo</button>
		</form:form>
	</div>
</div>


</body>
</html>