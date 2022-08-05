<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
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
					<h3>SignUp</h3>
				</div>
				<f:form method="post" action="signup" modelAttribute="user">
					<div class="form-group">
						<label>FirstName</label>
						<f:input class="form-control" path="firstname" />
						<f:errors path="firstname"></f:errors>
					</div>
					<div class="form-group">

						<label>LastName</label>
						<f:input class="form-control" path="lastname" />
						<f:errors path="lastname"></f:errors>
					</div>

					<div class="form-group">

						<label>email</label>
						<f:input class="form-control" path="email" />
						<f:errors path="email"></f:errors>
						<span style="color: red;">${duplicate}</span>
					</div>
					<div class="form-group">

						<label>password</label>
						<f:input class="form-control" path="password" />
						<f:errors path="password"></f:errors>
					</div>
					<div class="form-group">

						<label>security question</label>
						<f:select path="question" class="form-control">
							<f:option value="Your mother's BirthPlace">Your mother's BirthPlace</f:option>
							<f:option value="First Bank Who Provide CreditCard">First Bank Who Provide CreditCard</f:option>
							<f:option value="First Job Company Name">First Job Company Name</f:option>
						</f:select>
						<f:errors path="question"></f:errors>
					</div>
					<div class="form-group">

						<label>security answer</label>
						<f:input class="form-control" path="answer" />
						<f:errors path="answer"></f:errors>
					</div>
					<div class="form-group">

						<label>gender: </label> <label>male</label>
						<f:radiobutton path="gender" value="male" />
						<label>female</label>
						<f:radiobutton path="gender" value="female" />
						<f:errors path="gender"></f:errors>
					</div>
					<input type="submit" class="btn btn-primary" value="Signup">
				</f:form>
					<a href="login">login</a>

			</div>
		</div>
	</div>
</body>
</html>