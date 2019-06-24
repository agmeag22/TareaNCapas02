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
<title>Editar Usuario</title>
</head>
<body>
	
	<div class="form-group col-md-4 container">
		<form action="${pageContext.request.contextPath}/adduser" modelAttribute="user" method="post">
		<div>Usuario:</div><input type="text" class="form-control" name="username" placeholder="Usuario" required >
		<div>Contraseña:</div><input type="text" class="form-control" name="password" 
		placeholder="Contraseña" required >
		<input type="hidden" value="${usuario}" name="id_store">
		
		<input type="submit" class="btn btn-outline-dark button" value="Guardar Usuario">
		</form>
	</div>
	
</body>
</html>