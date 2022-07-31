<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div style="text-align: center;">
					<h3>login</h3>
				</div>
				<f:form modelAttribute="loginBean" action="login" method="post">
					<div class="form-group">
						<label>email</label>
						<f:input class="form-control" path="email" />
						<f:errors path="email"></f:errors>
					</div>
					<div class="form-group">

						<label>password</label>
						<f:input class="form-control" path="password" />
						<f:errors path="password"></f:errors>
					</div>
					<div class="form-group" style="text-align: center;">

						<input type="submit" class="btn btn-primary pr-3 pl-3" value="login">
					</div>

				</f:form>
			</div>
		</div>
	</div>
</body>
</html>