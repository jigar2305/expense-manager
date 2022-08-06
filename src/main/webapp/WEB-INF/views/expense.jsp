<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add category</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-md-4"></div>
			<div class="col-md-4">
				<f:form method="post" action="addcategorybyadmin"
					modelAttribute="category">
					<h1>add category</h1>
					<div class="form-group">
						<label>name</label>
						<f:input class="form-control" path="categoryname" id="form1" />
						<f:errors path="categoryname"></f:errors>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</f:form>
			</div>
		</div>

</div>

</body>
</html>