<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Edit</h1>
	<p><a href="/expenses">Go back</a></p>
	<form:form action="/expenses/${travel.id}/edit" method="post" modelAttribute="travel">
		<input type="hidden" name="_method" value="put">
		<p>
        	<form:label path="expense">Expense Name:</form:label>
        	<form:errors path="expense"/>
        	<form:input path="expense"/>		
		</p>
		<p>
        	<form:label path="vendor">Vendor:</form:label>
        	<form:errors path="vendor"/>
        	<form:input path="vendor"/>		
		</p>
		<p>
        	<form:label path="description">Description:</form:label>
        	<form:errors path="description"/>
        	<form:input path="description"/>		
		</p>
		<p>
        	<form:label path="amount">Amount:</form:label>
        	<form:errors path="amount"/>
        	<form:input type="double" path="amount"/>		
		</p>
		<button>Submit</button>
	</form:form>
</body>
</html>