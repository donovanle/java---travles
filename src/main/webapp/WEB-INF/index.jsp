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
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items="${travels}">
				<tr>
					<td>
						<a href="/expenses/${travel.id}">
							<c:out value="${travel.expense}"></c:out>
						</a>
					</td>
					<td><c:out value="${travel.vendor}"></c:out></td>
					<td>$ <c:out value="${travel.amount}"></c:out></td>
					<td><a href="/expenses/${travel.id}/edit">Edit</a></td>
					<td>
						<form action="/expenses/${travel.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete">
							<button>Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	
	<h2>Add an Expense:</h2>
	<form:form action="/expenses/new" method="post" modelAttribute="travel">
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