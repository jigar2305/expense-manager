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
	function cardnumber11(cardnumber) {
		let type = document.getElementById("type").value
		if (type == "Debitcard" || type == "Creditcard") {
			var cardno = /^(?:5[1-5][0-9]{14})$/;
			if (cardnumber.value.match(cardno)) {
				return true;
			} else {
				alert("Not a valid Mastercard number!");
				return false;
			}
		}

	}
	function hide() {
		let type = document.getElementById("type").value
		let cardname = document.getElementById("cardname")
		let cardnumber = document.getElementById("cardnumber")
		let upiid = document.getElementById("upiid")
		let balance = document.getElementById("balance")
		let cardname1 = document.getElementById("cardname1")
		let cardnumber1 = document.getElementById("cardnumber1")
		let upiid1 = document.getElementById("upiid1")
		

		if (type == "cash") {
			cardname.setAttribute("style", "display:none");
			cardnumber.setAttribute("style", "display:none");
			upiid.setAttribute("style", "display:none");
			cardnumber1.required = false;
			cardname1.required = false;
			upiid1.required = false;
			
		}
		if (type == "Paytm") {
			cardname.setAttribute("style", "display:none");
			cardnumber.setAttribute("style", "display:none");
			upiid.setAttribute("style", "display:visible");
			upiid1.required = true;
			cardnumber1.required = false;
			cardname1.required = false;
			
		}
		if (type == "Debitcard") {
			cardname.setAttribute("style", "display:visible");
			cardnumber.setAttribute("style", "display:visible");
			upiid.setAttribute("style", "display:none");
			cardnumber1.required = true;
			cardname1.required = true;
			upiid1.required = false;

		}
		if (type == "Creditcard") {
			cardname.setAttribute("style", "display:visible");
			cardnumber.setAttribute("style", "display:visible");
			upiid.setAttribute("style", "display:none");
			cardnumber1.required = true;
			cardname1.required = true;
			upiid1.required = false;

		}

	}
</script>
</head>
<body>
	<jsp:include page="navcustomer.jsp"></jsp:include>

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
							<f:option value="Creditcard">CreditCard</f:option>
							<f:option value="cash">Cash</f:option>
							<f:option value="Debitcard">DebitCard</f:option>
							<f:option value="Paytm">PayTm</f:option>
						</f:select>
					</div>
					<div class="form-group" id="cardname">
						<label>Card Name</label>
						<f:input class="form-control" path="cardname" id="cardnumber1"/>
						<f:errors path="cardname"></f:errors>
					</div>
					<div class="form-group" id="cardnumber">
						<label>card number</label>
						<f:input class="form-control" path="cardnumber" id="cardnumber1"
							onblur="cardnumber11(cardnumber)" /><span>${creditcarderror}${debitcarderror}</span>
						<f:errors path="cardnumber"></f:errors>
					</div>
					<div class="form-group" id="upiid" style="display: none;">
						<label>UPI</label>
						<f:input class="form-control" path="upiid" id="upiid1"/><span>${paytmerror}</span>
						<f:errors path="upiid"></f:errors>
					</div>
					<div class="form-group" id="balance">
						<label>balance</label>
						<f:input class="form-control" path="balance" id="balance"/>
						<f:errors path="balance"></f:errors>
					</div>
					<input type="submit" class="btn btn-primary" value="add">

				</f:form>
			</div>
		</div>
	</div>
</body>
</html>