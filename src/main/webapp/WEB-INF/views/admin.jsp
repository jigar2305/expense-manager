<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bean.MychartBean"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashbord</title>
</head>
<body>
<jsp:include page="Navadmin.jsp"></jsp:include>
	<div class="container">

		<table class="table mt-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">No.</th>
					<th scope="col">firstname</th>
					<th scope="col">lastname</th>
					<th scope="col">email</th>
					<th scope="col">active</th>
					<th scope="col">gender</th>
					<th scope="col">action</th>
					
				


				</tr>
			</thead>
			<tbody>
				<%
				int id = 1;
				%>
				<c:forEach items="${users}" var="it">
					<tr style="hight: 10px;">
						<th scope="row"><%=id%></th>
						<td>${it.firstname}</td>
						<td>${it.lastname}</td>
						<td>${it.email}</td>
						<td>${it.active}</td>
						<td>${it.gender}</td>
						<td>
						<a href="updatestatus?activate=${it.active}&userid=${it.userid}">
						<c:if test="${it.active == false }">activate</c:if>
						<c:if test="${it.active == true }">deactivate</c:if>
						</a></td>
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