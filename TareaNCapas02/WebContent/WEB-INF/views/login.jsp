<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Login</title>
<link href="./resources/css/bootstrap.css" media="all" type="text/css" rel="stylesheet">
<style type="text/css">
	.wraper{
		display:flex;
		align-content: center;
		justify-content: center;
	}
	.container{
		margin-top: 50%;
	}
	
	.t{
		margin-top: 10px;
	}
	.e{
		margin-left: 80px;
	}

</style>
</head>
<body>

<div class="wraper">
    <form action="${pageContext.request.contextPath}/login" method = "post">
    <div class="form-group col-md-12 container">
		<input type="text" id="login" class="form-control t" name="username" placeholder="Username">
		<input type="password" id="password" class="form-control t" name="password" placeholder="Password"z>
		<input type="submit" class="btn btn-outline-dark t e" value="Sign In">
    </div>
    </form>
  </div>
</div>
</body>
</html>