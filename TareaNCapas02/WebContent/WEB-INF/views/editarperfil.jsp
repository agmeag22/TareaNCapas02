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
	</div>
	<div class="form-group col-md-4 container">
		<form action="${pageContext.request.contextPath}/actualizar" modelAttribute="sucursal" method="post">
		<input type="hidden" class="form-control" name="id_store" value="${store.id_store}" required>
		<div>Nombre:</div><input type="text" class="form-control" name="store_name" placeholder="Nombre sucursal" required value="${store.store_name}">
		<div>Horario apertura:</div><input type="text" class="form-control" name="store_schedule_open" 
		placeholder="Ejemplo: 12:00 PM" required value="${store.store_schedule_open}">
		<div>Horario cierre:</div><input type="text" class="form-control" name="store_schedule_close" 
		placeholder="Ejemplo: 12:00 AM" required value="${store.store_schedule_close}">
		<div>Ubicación:</div><input type="text" class="form-control" name="store_location" required value="${store.store_location}">
		<div>Numero de mesas :</div><input type="number" class="form-control" name="store_tables" 
		placeholder="Número" required value="${store.store_tables}">
		<div>Nombre Gerente:</div><input type="text" class="form-control" name="store_manager" 
		placeholder="Número" required value="${store.store_manager}">
		<input type="submit" class="btn btn-outline-dark button" value="Actualizar Sucursal">
		</form>
	</div>
	
</body>
</html>