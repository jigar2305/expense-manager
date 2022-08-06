<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>



<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">

<title>Accounts</title>
</head>
<body>
	<jsp:include page="navcustomer.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
			<div style="text-align: center;"><h2 style="border: 1px solid black; border-radius:10px; background-color: grey;">cash balance: 
			
			<c:forEach items="${cashs}" var="i">
			${i.cash}
			</c:forEach>
			
			</h2></div>
				<div id="creditcard">
				<h2 style="text-align: center;">Credit card</h2>
					<table class="table mt-5">
						<thead class="thead-dark">
							<tr>
								<th scope="col">No.</th>
								<th scope="col">cardname</th>
								<th scope="col">cardnumber</th>
								<th scope="col">limit</th>
							</tr>
						</thead>
						<tbody>
							<%
							int id = 1;
							%>
							<c:forEach items="${creditcard}" var="it">
								<tr style="hight: 10px;">
									<th scope="row"><%=id%></th>
									<td>${it.cardname}</td>
									<td>${it.cardnumber}</td>
									<td>${it.limit}</td>
									<%
									id++;
									%>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="debitcard">
								<h2 style="text-align: center;">Debit card</h2>
				
					<table class="table mt-5">
						<thead class="thead-dark">
							<tr>
								<th scope="col">No.</th>
								<th scope="col">CardName</th>
								<th scope="col">CardNumber</th>
								<th scope="col">balance</th>
							</tr>
						</thead>
						<tbody>
							<%
							int id2 = 1;
							%>
							<c:forEach items="${debitcard}" var="it">
								<tr style="hight: 10px;">
									<th scope="row"><%=id2%></th>
									<td>${it.cardname}</td>
									<td>${it.cardnumber}</td>
									<td>${it.balance}</td>
									<%
									id++;
									%>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="paytm">
				<h2 style="text-align: center;">Paytm</h2>

					<table class="table ">
						<thead class="thead-dark">
							<tr>
								<th scope="col">No.</th>
								<th scope="col">UPI</th>
								<th scope="col">money</th>
							</tr>
						</thead>
						<tbody>
							<%
							int id3 = 1;
							%>
							<c:forEach items="${paytm}" var="it">
								<tr style="hight: 10px;">
									<th scope="row"><%=id3%></th>
									<td>${it.upiid}</td>
									<td>${it.money}</td>
									<%
							id++;
							%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
      </div>
		<div id="modalOne" class="modal">
      <div class="modal-content">
        <div class="contact-form">
          <a class="close">&times;</a>
					<f:form action="/">
						<h2>update balance</h2>
						<div>
						</div>
						<select name="creditcardid" class="form-control">
							<c:forEach items="${creditcard}" var="i">
								<option value="${i.creditcardid}">${i.cardname}||
									${i.cardnumber} || ${i.limit}</option>
							</c:forEach>
						</select> <span>Message</span>
						
						<button type="submit">Submit</button>
					</f:form>
				</div>
    </div>
	</div>
	
</body>
</html>