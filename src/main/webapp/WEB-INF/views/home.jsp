<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bean.MychartBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	
	<%List<MychartBean> mycharts = (List<MychartBean>)request.getAttribute("mycharts"); %>
</head>
<body>
<jsp:include page="navcustomer.jsp"></jsp:include>
<div class="container">
<div style="hight:200px;">
<canvas id="myChart" width="400" height="200"></canvas>
</div>
</div>
<script>
const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: [<%for (MychartBean mc : mycharts) {%>
		'<%=mc.getCategoryname()%>',
		<%}%>],
        datasets: [{
            label: 'Expenses',
            data: [<%for (MychartBean mc : mycharts) {%>
    		<%=mc.getSpends()%>,
    		<%}%>],
            backgroundColor: [
                'rgba(0, 0, 0, 0.5)',
            
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
</script>
</body>
</html>