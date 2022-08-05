<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>add expense</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  right: 15px;
  align-content: left;
  top:250px;
  position:fixed;
  border: 3px solid #f1f1f1;
  z-index: 1;
}


/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}




/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>

</head>

<body>
	<jsp:include page="navcustomer.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div style="text-align: center;">
					<h3>expanse</h3>
				</div>
			${expensemoney}
				<f:form method="post" action="expense" modelAttribute="expense">
					<div class="form-group">
						<label>expense name</label>
						<f:input class="form-control" path="expensename" />
						<f:errors path="expensename"></f:errors>
					</div>
					<div class="form-group">

						<label>spend</label>
						<f:input class="form-control" path="spend" />
						<f:errors path="spend"></f:errors>
					</div>
					<div class="form-group">
								
								<label>category</label>
								<br>
								<f:select path="categoryid"  id="category">
									<c:forEach items="${category}" var="i">
										<f:option value="${i.categoryid}">${i.categoryname}</f:option>
									</c:forEach>
								</f:select>
								<span>
									<button type="button" onclick="openForm()">add</button>
								</span>
								<f:errors path="categoryid"></f:errors>
							<br>
					</div>

					<div id="hidecategory" style="display: none;">
						<label>sub category</label><br>
						<f:select path="subcategoryid" >
						</f:select>
						<span>
							<button type="button" onclick="openForm1()">add</button>
						</span><br>
						<f:errors path="subcategoryid"></f:errors>
					</div>
					<div class="form-group">
						<label>payment</label>
						<f:select path="paymenttype" class="form-control" id="type"
							onclick="hide1()">
							<f:option value="cash">Cash</f:option>
							<f:option value="Creditcard">CreditCard</f:option>
							<f:option value="Debitcard">DebitCard</f:option>
							<f:option value="Paytm">PayTm</f:option>
						</f:select>
					</div>
					<div class="form-group">
						<label>Account</label> <select name="paymentid"
							class="form-control">
							<optgroup label="Cash" id="cash" style="display: none;">
								<c:forEach items="${cash}" var="i">
									<option value="${i.cashid}">${i.cash}</option>
								</c:forEach>
							</optgroup>
							<optgroup label="Paytm" id="paytm" style="display: none;">
								<c:forEach items="${paytm}" var="i">
									<option value="${i.paytmid}">${i.upiid} || ${i.money}</option>
								</c:forEach>
							</optgroup>
							<optgroup label="Creditcard" id="credit" style="display: none;">
								<c:forEach items="${creditcard}" var="i">
									<option value="${i.creditcardid}">${i.cardname} ||
										  ${i.cardnumber} || ${i.limit}</option>
								</c:forEach>
							</optgroup>
							<optgroup label="Debitcard" id="debit" style="display: none;">
								<c:forEach items="${debitcard}" var="i">
									<option value="${i.debitcardid}">${i.cardname} ||
										 ${i.cardnumber} || ${i.balance}</option>
								</c:forEach>
							</optgroup>

						</select>
					</div>
					<input type="submit" class="btn btn-primary" value="Signup">
				</f:form>
			</div>

			</div>
			<div class="col-md-4">
				<div class="form-popup" id="myForm">
					<a type="button" id="a"
						style="text-align: right; font-family: fantasy; font-size: 10;"
						onclick="closeForm()">x</a>
					<f:form method="post" action="addcategory"
						modelAttribute="category1" class="form-container">
						<h1>add category</h1>
						<div class="form-group">
							<label>name</label>
							<f:input class="form-control" path="categoryname" id="form1"/>
							<f:errors path="categoryname"></f:errors>
						</div>
						<button type="submit" class="btn btn-primary" >Add</button>
					</f:form>
				</div>
			<div class="form-popup" id="myForm1">
				<a type="button" id="a"
					style="text-align: right; font-family: fantasy; font-size: 10;"
					onclick="closeForm1()">x</a>
				<f:form method="post" action="addsubcategory"
					modelAttribute="subcategory" class="form-container">
					<div class="form-group">
						<label>category</label>
						<f:select path="categoryid" class="form-control" id="category">
							<c:forEach items="${category}" var="i">
								<f:option value="${i.categoryid}">${i.categoryname}</f:option>
							</c:forEach>
						</f:select>
						<f:errors path="categoryid"></f:errors>
					</div>
					<div class="form-group">
						<label>Subcategory name</label>
						<f:input class="form-control" path="subcategoryname" id="form2"/>
						<f:errors path="subcategoryname"></f:errors>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</f:form>
			</div>
		</div>
	</div>
	<script>
		function openForm() {
			document.getElementById("myForm").style.display = "block";
			let form1 = document.getElementById("form1")
			form1.required = true;
		}

		function closeForm() {
			document.getElementById("myForm").style.display = "none";
			let form1 = document.getElementById("form1");
			form1.required = false;
		}
		function openForm1() {
			document.getElementById("myForm1").style.display = "block";
			let form2 = document.getElementById("form2");
			form2.required = true;
		}

		function closeForm1() {
			document.getElementById("myForm1").style.display = "none";
			let form2 = document.getElementById("form2");
			form2.required = false;
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document)
			.ready(
				function () {

					$("#category")
						.click(
							function () {
								let hidecategory = document.getElementById("hidecategory");
								hidecategory.setAttribute("style","display:visible");
								let categoryid = document.getElementById("category").value;
								let url = "https://expense-tracker2305.herokuapp.com/subcategory/"+ categoryid;
								$.get(url).done(function (data) {
											let subcategory = $("#subcategoryid");
											subcategory.empty();
											for (let i = 0; i < data.length; i++) {
												subcategory.append("<option value=" + data[i].subcategoryid + ">"+ data[i].subcategoryname+ "</option>");
											}
										})
									.fail(function () {
											console.log("something went wrong");
										});
							})
				})
	</script>

	<script type="text/javascript">
	
	
	function hide1() {
		let type = document.getElementById("type").value
		let cash = document.getElementById("cash")
		let paytm = document.getElementById("paytm")
		let credit = document.getElementById("credit")
		let debit = document.getElementById("debit")
		

		if (type == "cash") {
			cash.setAttribute("style", "display:visible");
			paytm.setAttribute("style", "display:none");
			credit.setAttribute("style", "display:none");
			debit.setAttribute("style", "display:none");
		}
		if (type == "Paytm") {
			cash.setAttribute("style", "display:none");
			paytm.setAttribute("style", "display:visible");
			credit.setAttribute("style", "display:none");
			debit.setAttribute("style", "display:none");
		}
		if (type == "Debitcard") {
			cash.setAttribute("style", "display:none");
			paytm.setAttribute("style", "display:none");
			credit.setAttribute("style", "display:none");
			debit.setAttribute("style", "display:visible");
		}
		if (type == "Creditcard") {
			cash.setAttribute("style", "display:none");
			paytm.setAttribute("style", "display:none");
			credit.setAttribute("style", "display:visible");
			debit.setAttribute("style", "display:none");

		}
	}
	
	</script>

</body>

</html>