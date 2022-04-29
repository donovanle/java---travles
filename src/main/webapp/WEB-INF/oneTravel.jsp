<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Expense Details</h1>
	<p><a href="/expenses">Go back</a></p>
	<h2>Expense Name: <c:out value="${travel.expense}"></c:out></h2>
	<h2>Expense Description: <c:out value="${travel.description}"></c:out></h2>
	<h2>Vendor: <c:out value="${travel.vendor}"></c:out></h2>
	<h2>Amount Spent: $<c:out value="${travel.amount}"></c:out></h2>
</body>
</html>