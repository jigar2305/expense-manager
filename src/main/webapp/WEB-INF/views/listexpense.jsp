<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<style>
.hoverdiv{
  position: relative;
}

.hoverdiv > .tooltip {
  display: none;
}

.hoverdiv:hover > .tooltip {
  display: inline;
  position: absolute;
  top: 20px;
  left: 10px;
  background: red;
  border: 1px solid red;
	color:white
}
</style>
<title>expenses</title>
</head>
<body>
	<jsp:include page="navcustomer.jsp"></jsp:include>

	<div class="container">

		<table class="table mt-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">No.</th>
					<th scope="col">expensename</th>
					<th scope="col">spend</th>
					<th scope="col">categoryname</th>
					<th scope="col">subcategoryname</th>
					<th scope="col">expensedate</th>
					<th scope="col">expensetime</th>
					<th scope="col">paymenttype</th>


				</tr>
			</thead>
			<tbody>
				<%
				int id = 1;
				%>
				<c:forEach items="${espenses}" var="it">
					<tr style="hight: 10px;">
						<th scope="row"><%=id%></th>
						<td>${it.expensename}</td>
						<td>${it.spend}</td>
						<td>${it.categoryname}</td>
						<td>${it.subcategoryname}</td>
						<td>${it.expensedate}</td>
						<td>${it.expensetime}</td>
						<td>
							<div class="hoverdiv">
								<span class="hoverdiv_main">${it.paymenttype}</span> 
								<span class="tooltip">Text on hover</span>
							</div>
						</td>
						<%
						id++;
						%>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>