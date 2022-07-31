<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>balance</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script type="text/javascript">
	function hide() {
		let type = document.getElementById("type").value
		let cardname = document.getElementById("cardname")
		let cardnumber = document.getElementById("cardnumber")
		let upiid = document.getElementById("upiid")
		let balance = document.getElementById("balance")
		cardname.style.display = "visible";
		cardnumber.style.display = "visible";
		upiid.style.display = "visible";

		if (type == "cash") {
			cardname.style.display = "none";
			cardnumber.style.display = "none";
			upiid.style.display = "none";

		}
		if (type == "Paytm") {
			cardname.style.display = "none";
			cardnumber.style.display = "none";
			upiid.style.display = "visible";

		}
		if (type == "Debitcard") {
			cardname.style.display = "visible";
			cardnumber.style.display = "visible";
			upiid.style.display = "visible";

		}
		if (type == "Creaditcard") {
			cardname.style.display = "visible";
			cardnumber.style.display = "visible";
			upiid.style.display = "visible";
		}

	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div style="text-align: center;">
					<h3>balance</h3>
				</div>
				<f:form method="post" action="balance" modelAttribute="balance">
					<div class="form-group">
						<label>payment</label>
						<f:select path="financetype" class="form-control" id="type"
							onclick="hide()">
							<f:option value="Creaditcard">CreditCard</f:option>
							<f:option value="cash">Cash</f:option>
							<f:option value="Debitcard">DebitCard</f:option>
							<f:option value="Paytm">Paytm</f:option>
						</f:select>
					</div>
					<div class="form-group" id="cardname">

						<label>Card Name</label>
						<f:input class="form-control" path="cardname" />
						<f:errors path="cardname"></f:errors>
					</div>
					<div class="form-group" id="cardnumber">
						<label>card number</label>
						<f:input class="form-control" path="cardnumber" />
						<f:errors path="cardnumber"></f:errors>
					</div>
					<div class="form-group" id="upiid">
						<label>UPI</label>
						<f:input class="form-control" path="upiid" />
						<f:errors path="upiid"></f:errors>
					</div>
					<div class="form-group" id="balance">
						<label>balance</label>
						<f:input class="form-control" path="balance" />
						<f:errors path="balance"></f:errors>
					</div>
					<input type="submit" class="btn btn-primary" value="add">

				</f:form>
			</div>
		</div>
	</div>
</body>
</html>