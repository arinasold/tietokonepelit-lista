<%@ page language="java" contentType="text/html; ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8" />

<title>Tapahtumaraportti</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />

</head>
<body>

	<h1>Tapahtumaraportti</h1>
	<p><c:out value="${viesti}" /><p>
	<p><a href="/listaa-pelit">Pelit</a></p>
</body>
</html>