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
		<form action="${pageContext.request.contextPath}/addempleado" modelAttribute="empleado" method="post">
		<input type="hidden" class="form-control" name="id_empleado" value="${empleado.id_empleado}" required>
		<input type="hidden" class="form-control" name="id_store" value="${empleado.id_store}" required>
		<div>Nombre Empleado:</div><input type="text" class="form-control" name="e_name" placeholder="Nombre Empleado" required value="${empleado.e_name}">
		<div>Edad:</div><input type="number" class="form-control" name="e_age" 
		placeholder="Contraseñ	a" required value="${empleado.e_age}">
		<div>Sexo:</div>
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		  </div>
		  <select class="custom-select" id="inputGroupSelect01" name="e_gender">
		  	<c:set var = "sexo" value = "${empleados.e_gender}"/>
			<c:if test = "${sexo=='M'}">
			<option selected>Masculino</option>
			</c:if>
			<c:if test = "${sexo=='F'}">
			<option selected>Femenino</option>
			</c:if>
		    <option value="M">Masculino</option>
		    <option value="F">Femenino</option>
		  </select>
		</div> 
		<div>Estado:</div>
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		  </div>
		  <select class="custom-select" id="inputGroupSelect01" name="active_state">
		  	<c:set var = "state" value = "${empleados.active_state}"/>
			<c:if test = "${state>0}">
			<option selected>Activo</option>
			</c:if>
			<c:if test = "${state<1}">
			<option selected>Inactivo</option>
			</c:if>
		    <option value="0">Inactivo</option>
		    <option value="1">Activo</option>
		  </select>
		</div> 
		
		
		
		<input type="submit" class="btn btn-outline-dark button" value="Actualizar Usuario">
		</form>
	</div>
	
</body>
</html>