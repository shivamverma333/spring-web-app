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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>

<body class="viewCurrentHawkerDetails">
<%@include file="customerLoginHeader.jsp" %>
	<div  class="container">
      <div class="content-section">
        <% if(request.getAttribute("error")!=null){ %>
        		<div class="alert alert-danger alert-dismissible" role="alert">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  ${error}
                </div>
        <%} %>
        <% if(request.getAttribute("success")!=null){ %>
        		<div class="alert alert-success alert-dismissible" role="alert">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  ${success}
                </div>
        <%} %>
        	<h2 class=" text-center border-bottom mb-4">Hawker Details</h2>
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
        		<tr>
        			<td valign="top"><label class="form-control-label">Leave Dates:</label><br></td>
        			<td><c:choose>
        			<c:when test="${hawker.leaveDates.size()==0}">
        				<label class="form-control-label">No Leave Dates added.</label>
        			</c:when>
        			<c:otherwise>
        				<c:forEach var="leaveDate" items="${hawker.leaveDates}">
        					<label class="form-control-label">${leaveDate}</label><br>
        				</c:forEach>
        			</c:otherwise>
        			</c:choose></td>
        		</tr>
        	</table>
        	<div>
        		<form:form action="/customer/currentHawkers/${hawker.username}" method="POST" modelAttribute="dateForm">
        			<label class="form-control-label">Drop a leave date (yyyy-mm-dd):</label>
        			<c:choose>
        					<c:when test="${result.getFieldError('date')!=null}">
        						<form:input path="date" class="form-control is-invalid" style="width:25%;" type="text"/>
        						<div class="invalid-feedback">
                        			<span><form:errors path="date"/></span>
                        		</div>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="date" class="form-control" style="width:25%;" type="text"/>
        					</c:otherwise>
        			</c:choose>
        			<form:input path="customerUsername" hidden="true" type="text" value="${username}"/>
        			<form:input path="hawkerUsername" hidden="true" type="text" value="${hawker.username}"/>
        			<input type="submit" class="btn btn-success btn-sm" value="Save" style="margin-top:0.5rem;">
        		</form:form>
        	</div>
        	
        	<c:choose>
        	<c:when test="${checkPayment==true}">
        		<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  				<div class="modal-dialog">
    				<div class="modal-content">
      					<div class="modal-header">
        					<h5 class="modal-title" id="staticBackdropLabel">Payment Details</h5>
      					</div>
      				<div class="modal-body">
        		<c:choose>
        			<c:when test="${hawker.leaveDates.size()==0}">
        				<label class="form-control-label">No Leave Dates added.</label>
        			</c:when>
        			<c:otherwise>
        			<table class="table abc">
  				<thead class="thead-dark">
    				<tr>
      					<th scope="col">Leave Dates</th>
      					<th scope="col">Cost Deducted</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach var="leaveDate" items="${hawker.leaveDates}">
    				<tr>
    					    <th scope="row">${leaveDate}</th>
      						<td>${hawker.planPrice/30}</td>
    				</tr>
    				</c:forEach>
    				<tr>
    					<th scope="row">Total deduction amount:</th>
    					<td>${hawker.leaveDates.size()*(hawker.planPrice/30)}</td>
    				</tr>
				 </tbody>
			</table>
        			</c:otherwise>
        		</c:choose>
       		<table class="table abc">
  				<thead class="thead-dark">
    				<tr>
      					<th scope="col">Plan</th>
      					<th scope="col">Amount</th>
    				</tr>
  				</thead>
  				<tbody>
    				<tr>
    					    <th scope="row">Base Plan Cost</th>
      						<td>${hawker.planPrice}</td>
    				</tr>
    				<tr>
    					    <th scope="row">Leave dates deducted amount</th>
      						<td>${hawker.leaveDates.size()*(hawker.planPrice/30)}</td>
    				</tr>
    				 <tr>
    					    <th scope="row">Total payable amount of the month.</th>
      						<td>${hawker.planPrice-hawker.leaveDates.size()*hawker.planPrice/30}</td>
    				</tr>
				 </tbody>
			</table>
      				</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        				<a class="btn btn-primary" href="">Payment done!</a>
      				</div>
    				</div>
  				</div>
			</div>
        	</c:when>
        	</c:choose>
			<div class="modal fade" id="paymentHistoryModal" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="paymentHistoryModalLabel" aria-hidden="true">
  				<div class="modal-dialog">
    				<div class="modal-content">
      					<div class="modal-header">
        					<h5 class="modal-title" id="paymentHistoryModalLabel">Payment History</h5>
      					</div>
      		<div class="modal-body">
        		<c:choose>
        			<c:when test="${paymentHistory.size()==0}">
        				<label class="form-control-label">No Payment History Found.</label>
        			</c:when>
        			<c:otherwise>
        			<table class="table abc">
  				<thead class="thead-dark">
    				<tr>
      					<th scope="col">Customer Username</th>
      					<th scope="col">Hawker Username</th>
      					<th scope="col">Date of payment</th>
      					<th scope="col">Amount Paid</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach var="history" items="${paymentHistory}">
    				<tr>
    					    <td>${history.customerUsername}</td>
      						<td>${history.hawkerUsername}</td>
      						<td>${history.dateOfPayment}</td>
      						<td>${history.paymentAmount}</td>
    				</tr>
    				</c:forEach>
				 </tbody>
			</table>
        			</c:otherwise>
        		</c:choose>
      		</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      				</div>
    				</div>
  				</div>
			</div>
			<div class="text-center">
				<c:choose><c:when test="${checkPayment==true}">
				<button id="payment" type="button" class="btn btn-primary payment-button" data-toggle="modal" hidden="true" data-target="#staticBackdrop">
  					View Current Payment Details 
				</button>
			</c:when></c:choose>
				<button id="paymentHistory" type="button" class="btn btn-primary payment-button ml-2" data-toggle="modal"  data-target="#paymentHistoryModal">
  					View Payment History 
				</button>
			</div>
       	</div>
       	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
     <c:choose>
     	<c:when test="${checkPayment==true}">
     		<script>
     			$('#staticBackdrop').modal('show');
     			document.getElementById("payment").removeAttribute("hidden");
     		</script>
     	</c:when>
     </c:choose>
</html>