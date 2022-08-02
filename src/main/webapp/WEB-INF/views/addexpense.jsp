<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>add expense</title>
				
				
		
					
			
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
							<f:form method="post" action="expense" modelAttribute="expense">
								<div class="form-group">
									<label>expansename</label>
									<f:input class="form-control" path="expansename" />
									<f:errors path="expansename"></f:errors>
								</div>
								<div class="form-group">

									<label>spend</label>
									<f:input class="form-control" path="spend" />
									<f:errors path="spend"></f:errors>
								</div>
								<div class="form-group" >
									<label>category</label>
									<f:select path="categoryid" class="form-control" id="category">
										<c:forEach items="${category}" var="i">
											<f:option value="${i.categoryid}">${i.categoryname}</f:option>
										</c:forEach>
									</f:select><a class="btn btn-success">add Category</a>
									<f:errors path="categoryid"></f:errors>
								</div>
								<div id="hidecategory" style="display: none;">
									<label>sub category</label>
									<f:select path="subcategoryid" class="form-control">
										<f:option value="${i.subcategoryid}">${i.subcategoryname}</f:option>
									</f:select>
									<f:errors path="subcategoryid"></f:errors>
								</div>
								<div class="form-group">
									<label>Payment Method</label>

								<select name="payment" id="cars"class="form-control">
									<optgroup label="Cash">
									<c:forEach items="${cash}" var="i">
										<option value="${i.cashid}">${i.cash}</option>
									</c:forEach>
									</optgroup>
									<optgroup label="Paytm">
									<c:forEach items="${paytm}" var="i">
										<option value="${i.paytmid}">${i.upiid}</option>
									</c:forEach>
									</optgroup>
									<optgroup label="Creditcard">
									<c:forEach items="${creditcard}" var="i">
										<option value="${i.creditcardid}">${i.cardname} || ${i.cardnumber}</option>
									</c:forEach>
									</optgroup>
									<optgroup label="Debitcard">
									<c:forEach items="${debitcard}" var="i">
										<option value="${i.debitcardid}">${i.cardname} || ${i.cardnumber}</option>
									</c:forEach>
									</optgroup>
									
								</select>
							</div>
								<input type="submit" class="btn btn-primary" value="Signup">
							</f:form>

						</div>
					</div>
				</div>
				<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
						<script type="text/javascript">
				$(document).ready(function() {
					
					$("#category").click(function () {
								let hidecategory = document.getElementById("hidecategory");
								hidecategory.setAttribute("style", "display:visible");
						
								let categoryid = document.getElementById("category").value;
								let url = "http://localhost:8980/subcategory/"+ categoryid;
								$.get(url)
								.done(function (data) {
											let subcategory = $("#subcategoryid");
											subcategory.empty();
											for (let i = 0; i < data.length; i++) {
												subcategory.append("<option value=" + data[i].subcategoryid + ">"+ data[i].subcategoryname+ "</option>");}})
									.fail(function () {
											console.log("something went wrong");
										});
							})
				})
				</script>

			</body>

			</html>