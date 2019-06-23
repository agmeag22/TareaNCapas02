<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./resources/css/bootstrap.css" media="all" type="text/css" rel="stylesheet">
<style type="text/css">
	.wraper{
		display:flex;
		align-content: center;
		justify-content: center;
	}
	.button{
		margin:20px;
	}

</style>
<title>Registrar Sucursal</title>
</head>
<body>
	<div class="wraper">

	<form action="${pageContext.request.contextPath}/mostrar" method = "post">
	<input type="submit" class="btn btn-outline-dark button" value="Mostrar Sucursales">
	</form>
	
	<form action="${pageContext.request.contextPath}/registrar" method = "post">
	<input type="submit" class="btn btn-outline-dark button" value="Registrar Sucursal">
	</form>
	
	</div>
	
</body>
</html>