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
		<form action="${pageContext.request.contextPath}/nuevousuario" method="post">
      	<input type="hidden" value="${store.id_store}" name="id_store">
		<input type="submit" class="btn btn-outline-primary btn-sm" value="Nuevo Usuario">
		</form>
	  	<h4>Tabla Usuarios</h4>
	  	<table class="table table-hover">
		<thead class="thead-dark table-hover">
		<tr>
			<th>Usuario</th>
			<th>Contraseña</th>
			<th>Acción</th>
		</tr>
			<c:forEach items="${usuario}" var="usuario">
				<tr>
					<td>${usuario.username}</td>
					<td>${usuario.password}</td>
					<td>
					<div class="wraper2">
					</form>
					<form action="${pageContext.request.contextPath}/editaruser" method="post" modelAttribute="user">
						<input type="hidden" value="${usuario.iduser}" name="iduser">
						<input type="hidden" value="${usuario.username}" name="username">
						<input type="hidden" value="${usuario.password}" name="password">
						<input type="hidden" value="${usuario.id_store}" name="id_store">
						<input type="submit" class="btn btn-outline-success btn-sm" value="Editar">
					</form>
					<form action="${pageContext.request.contextPath}/eliminaruser" method="post" modelAttribute="user">
						<input type="hidden" value="${usuario.iduser}" name="iduser">
						<input type="hidden" value="${usuario.username}" name="username">
						<input type="hidden" value="${usuario.password}" name="password">
						<input type="hidden" value="${usuario.id_store}" name="id_store">
						<input type="submit" class="btn btn-outline-danger btn-sm" value="Eliminar">
					</form>
					</div>
					</td>
				</tr>	
			</c:forEach>
	</table>
	  
	  </div>
      <div class="container3">
      	<form action="${pageContext.request.contextPath}/nuevoempleado?id_store=${store.id_store} " method="post">
      	<input type="hidden" value="${store.id_store}" name="id_store">
		<input type="submit" class="btn btn-outline-primary btn-sm" value="Nuevo Empleado">
	  	<h4>Tabla Empleados</h4>
	  	<table class="table table-hover">
		<thead class="thead-dark table-hover">
		<tr>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Género</th>
			<th>Estado</th>
			<th>Acción</th>
			
		</tr>
			<c:forEach items="${empleados}" var="empleados">
				<tr>
					<td>${empleados.e_name}</td>
					<td>${empleados.e_age}</td>
					<td>${empleados.e_gender}</td>
					<c:set var = "state" value = "${empleados.active_state}"/>
					<c:if test = "${state<1}">
					<td><button type="button" class="btn btn-danger btn-sm">Inactivo</button></td>
					</c:if>
					<c:if test = "${state>0}">
					<td><button type="button" class="btn btn-success btn-sm">Activo</button></td>
					</c:if>
					<td>
					<div class="wraper2">
					</form>
					<form action="${pageContext.request.contextPath}/editarempleado" method="post" ModelAttribute="empleado">
						<input type="hidden" value="${empleados.id_empleado}" name="id_empleado">
						<input type="hidden" value="${empleados.e_name}" name="e_name">
						<input type="hidden" value="${empleados.e_age}" name="e_age">
						<input type="hidden" value="${empleados.e_gender}" name="e_gender">
						<input type="hidden" value="${empleados.id_store}" name="id_store">
						<input type="hidden" value="${empleados.active_state}" name="active_state">
						<input type="submit" class="btn btn-outline-success btn-sm" value="Editar">
					</form>
					<form action="${pageContext.request.contextPath}/eliminarempleado" method="post">
						<input type="hidden" value="${empleados.id_empleado}" name="id_empleado">
						<input type="hidden" value="${empleados.e_name}" name="e_name">
						<input type="hidden" value="${empleados.e_age}" name="e_age">
						<input type="hidden" value="${empleados.e_gender}" name="e_gender">
						<input type="hidden" value="${empleados.id_store}" name="id_store">
						<input type="hidden" value="${empleados.active_state}" name="active_state">
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