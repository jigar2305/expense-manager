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
<title>expenses</title>
</head>
<body>
	<jsp:include page="navcustomer.jsp"></jsp:include>

	<div class="container">

		<table class="table mt-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">No.</th>
					<th scope="col">firstname</th>
					<th scope="col">age</th>
					<th scope="col">contact number</th>
					<th scope="col">gender</th>
				</tr>
			</thead>
			<tbody>
				<%
				int id = 1;
				%>
				<c:forEach items="${members}" var="it">
					<tr style="hight: 10px;">
						<th scope="row"><%=id%></th>
						<td>${it.firstname}</td>
						<td>${it.age}</td>
						<td>${it.contact_number}</td>
						<td>${it.gender}</td>

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