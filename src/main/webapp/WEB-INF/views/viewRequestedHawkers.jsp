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

<body class="viewRequestedHawkers">
<%@include file="customerLoginHeader.jsp" %>
     <section id="section" class="pt-2">
        <h2 class=" text-center mt-0 pt-0 mb-2 pb-2">Requested Hawkers</h2>
        <div class="row">
        <div class="col-12 d-flex justify-content-center">
        	<table class="table table-striped">
  				<c:choose>
  					<c:when test="${list.size()==0}">
  					<div style="color:red" class="text-center"><p>No requested hawkers.</p></div>
  					</c:when>
  					<c:otherwise>
  					<thead class="thead-dark">
    				<tr>
      					<th scope="col">Username</th>
      					<th scope="col">Name</th>
      					<th scope="col">Service</th>
    				</tr>
  				</thead>
  				<tbody>
  						<c:forEach var="hawker" items="${list}">
    				<tr>
    					    <th scope="row">${hawker.username}</th>
      						<td>${hawker.name}</td>
      						<td>${hawker.planName}</td>
    				</tr>
    			</c:forEach>
  					</c:otherwise>
  				</c:choose>
				 </tbody>
			</table>
       	</div>
       	</div>
       	</section>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>