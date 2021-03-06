<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.validation.BindingResult" %>
<%@ page isELIgnored="false"%>
<%
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires","0");

	if(session.getAttribute("loggedin")==null||!(boolean)session.getAttribute("loggedin")||session.getAttribute("username")==null){
		response.sendRedirect("/customer/login");
	}

%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
</head>

<body class="hawkerDetailsPage">
<%@include file="customerLoginHeader.jsp" %>
	<div  class="container">
        <div class="content-section">
                <% if(request.getAttribute("error")!=null){ %>
        		<div class="alert alert-danger alert-dismissible" role="alert">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  ${error}
                </div>
        <%} %>
        	<h2 class="border-bottom mb-4">Hawker Details</h2>
        	<table>
        		<tr>
        			<td><label class="form-control-label">Username:</label></td>
        			<td><label class="form-control-label">${hawker.username}</label></td>
        		</tr>
        		<tr>
        			<td><label class="form-control-label">Name:</label></td>
        			<td><label class="form-control-label">${hawker.name}</label></td>
        		</tr>
        		 <tr>
        			<td><label class="form-control-label">Email:</label></td>
        			<td><label class="form-control-label">${hawker.email}</label></td>
        		</tr>
        		 <tr>
        			<td><label class="form-control-label">Contact:</label></td>
        			<td><label class="form-control-label">${hawker.contact}</label></td>
        		</tr>
        		<tr>
        			<td><label class="form-control-label">Address:</label></td>
        			<td><label class="form-control-label">${hawker.address}</label></td>
        		</tr>
        		<tr>
        			<td><label class="form-control-label">State:</label></td>
        			<td><label class="form-control-label">${hawker.state}</label></td>
        		</tr>
        		 <tr>
        			<td><label class="form-control-label">City:</label></td>
        			<td><label class="form-control-label">${hawker.city}</label></td>
        		</tr>
        		 <tr>
        			<td><label class="form-control-label">Plan Name:</label></td>
        			<td><label class="form-control-label">${hawker.planName}</label></td>
        		</tr>
        		 <tr>
        			<td><label class="form-control-label">Plan Quantity:</label></td>
        			<td><label class="form-control-label">${hawker.planQuantity}</label></td>
        		</tr>
        		<tr>
        			<td><label class="form-control-label">Plan Price:</label></td>
        			<td><label class="form-control-label">${hawker.planPrice}</label></td>
        		</tr>
        	</table>
        	<a class="btn btn-success bt-md" href="/customer/search/${service}/${hawker.username}/request">Request</a>
       	</div>
       	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>