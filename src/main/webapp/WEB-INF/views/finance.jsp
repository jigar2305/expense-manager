<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Finance</title>
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
					<h3>Add Payment</h3>
				</div>
				<span>${msg}</span>
				<f:form method="post" action="" modelAttribute="finance">
					
					<div class="form-group">
						<label>payment</label>
						<f:select path="financetype" class="form-control">
							<f:option value="cash">Cash</f:option>
							<f:option value="Creaditcard">CreditCard</f:option>
							<f:option value="Debitcard">DebitCard</f:option>
							<f:option value="Paytm">Paytm</f:option>
						</f:select>
					</div>
					<input type="submit" class="btn btn-primary" value="Add">
				</f:form>

			</div>
		</div>
	</div>
</body>
</html>