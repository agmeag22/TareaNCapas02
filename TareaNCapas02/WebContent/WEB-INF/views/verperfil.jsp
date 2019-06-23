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
	input.hidden {
    position: absolute;
    left: -9999px;
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
<div class="wraper">
      <form action="${pageContext.request.contextPath}/mostrar" method = "post">
      <input type="submit" class="btn btn-outline-dark button" value="Regresar a Sucursales">
      </form>
       </div>
      <div class="container">
      <div class="row">
      <div class="col-md-7 ">
      <div class="panel panel-default">
      <div class="panel-heading">  <h4 >User Profile</h4></div>
      <div class="panel-body">
      <div class="box box-info">
      <div class="box-body">
      <div class="col-sm-6">
      <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive"> 
      <input id="profile-image-upload" class="hidden" type="file">
      </div>
      <br>
      </div>
      <div class="col-sm-6">
      <h4 style="color:#00b1b1;">${store.store_name} </h4></span>
      <span><p>Sucursal</p></span>            
      </div>
      <div class="clearfix"></div>
      <hr style="margin:5px 0 5px 0;">
      <div class="col-sm-5 col-xs-6 tital " >Horario de Apertura:</div><div class="col-sm-7"> ${store.store_schedule_open}</div>
      <div class="clearfix"></div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Horario de Cierre:</div><div class="col-sm-7"> ${store.store_schedule_close}</div>
      <div class="clearfix"></div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Ubicación</div><div class="col-sm-7">${store.store_location}</div>
      <div class="clearfix"></div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Numero de mesas:</div><div class="col-sm-7">${store.store_tables}</div>
      <div class="clearfix"></div>
      <div class="bot-border"></div>
      <div class="col-sm-5 col-xs-6 tital " >Nombre del Gerente</div><div class="col-sm-7">${store.store_manager}</div>
      <div class="clearfix"></div>
      </div>
      </div>    
      </div> 
      </div>
      </div>         
      </div>
      </div>
	  <div class="container2">
	  	<h1>Tabla Empleados</h1>
	  	<table class="table table-hover">
		<thead class="thead-dark table-hover">
		<tr>
			<th>Número</th>
			<th>Empleado</th>
			<th>Edad</th>
			<th>Genero</th>
			<th>Estado</th>
			<th>Acción</th>
		</tr>
			<c:forEach items="${empleado}" var="empleados">
				<tr>
					<td>${empleado.id_employee}</td>
					<td>${empleado.employee_name}</td>
					<td>${empleado.employee_age}</td>
					<td>${empleado.employee_gender}</td>
					<td>${empleado.active_state}</td>
					<td>
					<div class="wraper2">
					<form action="${pageContext.request.contextPath}/verperfil" method="post">
						<input type="hidden" value="${store.id_store}" name="code">
						<input type="submit" class="btn btn-outline-primary btn-sm" value="Ver Perfil">
					</form>
					<form action="${pageContext.request.contextPath}/editar" method="post">
						<input type="hidden" value="${store.id_store}" name="code">
						<input type="submit" class="btn btn-outline-success btn-sm" value="Editar">
					</form>
					<form action="${pageContext.request.contextPath}/eliminar" method="post">
						<input type="hidden" value="${store.id_store}" name="code">
						<input type="submit" class="btn btn-outline-danger btn-sm" value="Eliminar">
					</form>
					</div>
					</td>
				</tr>	
			</c:forEach>
	</table>
	  
	  </div>
     <div class="container3">
	  	<h1>Tabla Usuarios</h1>
	  	<table class="table table-hover">
		<thead class="thead-dark table-hover">
		<tr>
			<th>Número</th>
			<th>Usuario</th>
			<th>Contraseña</th>
			<th>Acción</th>
		</tr>
			<c:forEach items="${usuario}" var="usuarios">
				<tr>
					<td>${usuario.id_user}</td>
					<td>${usuario.username}</td>
					<td>${usuario.password}</td>
					<td>
					<div class="wraper2">
					</form>
					<form action="${pageContext.request.contextPath}/editar" method="post">
						<input type="hidden" value="${store.id_store}" name="code">
						<input type="submit" class="btn btn-outline-success btn-sm" value="Editar">
					</form>
					<form action="${pageContext.request.contextPath}/eliminar" method="post">
						<input type="hidden" value="${store.id_store}" name="code">
						<input type="submit" class="btn btn-outline-danger btn-sm" value="Eliminar">
					</form>
					</div>
					</td>
				</tr>	
			</c:forEach>
	</table>
	  
	  </div>
     
	
</body>
</html>