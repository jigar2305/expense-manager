<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
      .modal {
        display: none;
        position: fixed;
        z-index: 8;
        left: 0;
        top: 0;
        width: 50%;
        height: 50%;
        overflow: auto;
        background-color: rgb(0, 0, 0);
        background-color: rgba(0, 0, 0, 0.4);
      }
      .modal-content {
        margin: 50px auto;
        border: 1px solid #999;
        width: 60%;
      }
      h2,
      p {
        margin: 0 0 20px;
        font-weight: 400;
        color: #000;
      }
      span {
        color: #666;
        display: block;
        padding: 0 0 5px;
      }
      form {
        padding: 25px;
        margin: 25px;
        box-shadow: 0 2px 5px #f5f5f5;
        background: #eee;
      }
      input,
      textarea {
        width: 90%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #1c87c9;
        outline: none;
      }
      .contact-form button {
        width: 100%;
        padding: 10px;
        border: none;
        background: #1c87c9;
        font-size: 16px;
        font-weight: 400;
        color: #fff;
      }
      button:hover {
        background: #2371a0;
      }
      .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
      }
      .close:hover,
      .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
      }
      button.button {
        background: none;
        border-top: none;
        outline: none;
        border-right: none;
        border-left: none;
        border-bottom: #02274a 1px solid;
        padding: 0 0 3px 0;
        font-size: 16px;
        cursor: pointer;
      }
      button.button:hover {
        border-bottom: #a99567 1px solid;
        color: #a99567;
      }
    </style>


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

					<button type="button" class="button" data-modal="modalOne">Add</button>
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
	<script>
      let modalBtns = [...document.querySelectorAll(".button")];
      modalBtns.forEach(function (btn) {
        btn.onclick = function () {
          let modal = btn.getAttribute("data-modal");
          document.getElementById(modal).style.display = "block";
        };
      });
      let closeBtns = [...document.querySelectorAll(".close")];
      closeBtns.forEach(function (btn) {
        btn.onclick = function () {
          let modal = btn.closest(".modal");
          modal.style.display = "none";
        };
      });
      window.onclick = function (event) {
        if (event.target.className === "modal") {
          event.target.style.display = "none";
        }
      };
    </script>
</body>
</html>