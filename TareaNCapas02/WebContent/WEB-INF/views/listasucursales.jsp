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
	.container{
	flex: display;
	align-items:center;
	align-content: center;
	justify-content: center;
	margin-top: 30px;
	margin-bottom: 20px;
	}
	.wraper{
		display:flex;
		align-content: center;
		justify-content: center;
	}
	.wraper2{
		display:flex;
		align-content: center;
		justify-content: center;
	}
	
	.button{
		margin:20px;
	}
	.table{
		text-align:center;
		
	}

</style>
<title>Registrar Sucursal</title>
</head>
<body>

<div class="container">
	<div class="wraper">
	<form action="${pageContext.request.contextPath}/registrar" method = "post">
	<input type="submit" class="btn btn-outline-dark button" value="Registrar Sucursal">
	</form>
	</div>
	<div class="alert alert-success" role="alert">
 		${message}
	</div>
	<table class="table table-hover">
		<thead class="thead-dark table-hover">
		<tr>
			<th>Sucursal</th>
			<th>Ubicación</th>
			<th>Acción</th>
		</tr>
			<c:forEach items="${store}" var="store">
				<tr>
					<td>${store.store_name}</td>
					<td>${store.store_location}</td>
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
</body>
</html>