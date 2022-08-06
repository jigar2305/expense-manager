<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
</head>
<body>
<div class="container">
<form method="post" action="profile" enctype="multipart/form-data">
<label>Please select image</label><br><br>
<input name="image" type="file" /><br><br>
<input type="submit" value="submit">
</form>

</div>


</body>
</html>