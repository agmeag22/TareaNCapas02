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
	
	body,
	html {
		width: 100%;
		height: 100%;
		font-size:14px;
		
	}
	.table{
		font-size:14px;
	}
	.container{
	flex: flex-wrap;
	}

	.wraper2{
		display:flex;
		align-content: center;
		justify-content: center;
	}
	.wraper{
		flex: flex-wrap;
		display:flex;
		align-content: center;
		justify-content: center;
	}
	.button{
		margin:20px;
	}
	input.hidden {
    position: absolute;
    left: -9999px;
	}
	.container3{
		margin:20px;
	}
#profile-image1 {
    cursor: pointer;
  
    width: 100px;
    height: 100px;
	border:2px solid #03b1ce ;}
	.tital{ font-size:16px; font-weight:500;}
	 .bot-border{ border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0}	

</style>
<title>Restaurante Rustico</title>
</head>
<body>
	<div class="container">
	<div class="wraper">
      <form action="${pageContext.request.contextPath}/mostrar" method = "post">
      <input type="submit" class="btn btn-outline-dark button" value="Regresar a Sucursales">
      </form>
      </div>
     <div>
      <div class="col-sm-6">
      <h4 style="color:#00b1b1;">${store.store_name} </h4></span>
      <span><p>Sucursal: ${store.store_name} </p></span>            
      </div>
      <hr style="margin:5px 0 5px 0;">
      <div class="col-sm-5 col-xs-6 tital " >Horario de Apertura:</div><div class="col-sm-7"> ${store.store_schedule_open}</div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Horario de Cierre:</div><div class="col-sm-7"> ${store.store_schedule_close}</div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Ubicación:</div><div class="col-sm-7">${store.store_location}</div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Numero de mesas:</div><div class="col-sm-7">${store.store_tables}</div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Nombre del Gerente</div><div class="col-sm-7">${store.store_manager}</div>
      </div>
     
      <div class="wraper">
	 <div class="container3">
	  	<h4>Tabla Usuarios</h4>
	  	<table class="table table-hover">
		<thead class="thead-dark table-hover">
		<tr>
			<th>Número</th>
			<th>Usuario</th>
			<th>Contraseña</th>
			<th>Acción</th>
		</tr>
			<c:forEach items="${usuario}" var="usuario">
				<tr>
					<td>${usuario.iduser}</td>
					<td>${usuario.username}</td>
					<td>${usuario.password}</td>
					<td>
					<div class="wraper2">
					</form>
					<form action="${pageContext.request.contextPath}/editar" method="post">
						<input type="hidden" value="${usuario.iduser}" name="code">
						<input type="submit" class="btn btn-outline-success btn-sm" value="Editar">
					</form>
					<form action="${pageContext.request.contextPath}/eliminar" method="post">
						<input type="hidden" value="${usuario.iduser}" name="code">
						<input type="submit" class="btn btn-outline-danger btn-sm" value="Eliminar">
					</form>
					</div>
					</td>
				</tr>	
			</c:forEach>
	</table>
	  
	  </div>
      <div class="container3">
	  	<h4>Tabla Empleados</h4>
	  	<table class="table table-hover">
		<thead class="thead-dark table-hover">
		<tr>
			<th>Número</th>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Género</th>
			<th>Estado</th>
			<th>Acción</th>
		</tr>
			<c:forEach items="${empleados}" var="empleados">
				<tr>
					<td>${empleados.id_empleado}</td>
					<td>${empleados.e_name}</td>
					<td>${empleados.e_age}</td>
					<td>${empleados.e_gender}</td>
					<td>${empleados.active_state}</td>
					<td>
					<div class="wraper2">
					</form>
					<form action="${pageContext.request.contextPath}/editar" method="post">
						<input type="hidden" value="${empleados.id_empleado}" name="code">
						<input type="submit" class="btn btn-outline-success btn-sm" value="Editar">
					</form>
					<form action="${pageContext.request.contextPath}/eliminar" method="post">
						<input type="hidden" value="${empleados.id_empleado}" name="code">
						<input type="submit" class="btn btn-outline-danger btn-sm" value="Eliminar">
					</form>
					</div>
					</td>
				</tr>	
			</c:forEach>
	</table>
	  
	  </div>
	</div>
	</div>
</body>
</html>