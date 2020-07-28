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
		response.sendRedirect("/hawker/login");
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
<body class="updateHawker">
<%@include file="hawkerLoginHeader.jsp" %>
	<div  class="container">
        	<div class="content-section">
        	<% if(request.getAttribute("error")!=null){ %>
        		<div class="alert alert-danger alert-dismissible" role="alert">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  ${error}
                </div>
            <%} %>
        		<form:form action="/hawker/update" method="post" name="updateForm" modelAttribute="updateForm">
        		<legend class="border-bottom mb-4">Update Details</legend>
        		<div class="form-group">
                    	<label class="form-control-label">Username</label>
                    	<c:choose>
        					<c:when test="${result.getFieldError('username')!=null}">
        						<form:input path="username" type="text" readonly="true" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="username" type="text" readonly="true" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        <div class="invalid-feedback">
                        	<span><form:errors path="username"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Name</label>
                    	<c:choose>
        					<c:when test="${result.getFieldError('name')!=null}">
        						<form:input path="name" type="text" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="name" type="text" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        <div class="invalid-feedback">
                        	<span><form:errors path="name"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Email</label>
                    	<c:choose>
        					<c:when test="${result.getFieldError('email')!=null}">
        						<form:input path="email" type="text" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="email" type="text" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        <div class="invalid-feedback">
                        	<span><form:errors path="email"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Contact Number</label>
                    	<c:choose>
        					<c:when test="${result.getFieldError('contact')!=null}">
        						<form:input path="contact" type="number" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="contact" type="number" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        <div class="invalid-feedback">
                        	<span><form:errors path="contact"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Address</label>
                    	<c:choose>
        					<c:when test="${result.getFieldError('address')!=null}">
        						<form:input path="address" type="textarea" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="address" type="textarea" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        <div class="invalid-feedback">
                        	<span><form:errors path="address"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">State</label>
                    	<c:choose>
        					<c:when test="${result.getFieldError('state')!=null}">
        						<form:input path="state" type="text" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="state" type="text" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        <div class="invalid-feedback">
                        	<span><form:errors path="state"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">City</label>
                    	<c:choose>
        					<c:when test="${result.getFieldError('city')!=null}">
        						<form:input path="city" type="text" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="city" type="text" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>              
                        <div class="invalid-feedback">
                        	<span><form:errors path="city"/></span>
                        </div>
                	</div>
                	<div id="planDetails">
                	    <div class="form-group">
                    		<label class="form-control-label">Plan Name</label>
                    		<c:choose>
        					<c:when test="${result.getFieldError('planName')!=null}">
        						<form:input path="planName" type="text" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="planName" type="text" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        	
                        	<div class="invalid-feedback">
                        		<span><form:errors path="planName"/></span>
                        	</div>
                		</div>
                	    <div class="form-group">
                    		<label class="form-control-label">Plan Quantity</label>
                    		<c:choose>
        					<c:when test="${result.getFieldError('planQuantity')!=null}">
        						<form:input path="planQuantity" type="text" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="planQuantity" type="text" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        	
                        	<div class="invalid-feedback">
                        		<span><form:errors path="planQuantity"/></span>
                        	</div>
                		</div>
                	    <div class="form-group">
                    		<label class="form-control-label">Plan Monthly Price</label>
                    		<c:choose>
        					<c:when test="${result.getFieldError('planPrice')!=null}">
        						<form:input path="planPrice" type="text" class="form-control form-control is-invalid"/>
        					</c:when>
        					<c:otherwise>
        					 	<form:input path="planPrice" type="text" class="form-control form-control"/>
        					</c:otherwise>
        				</c:choose>
                        	
                        	<div class="invalid-feedback">
                        		<span><form:errors path="planPrice"/></span>
                        	</div>
                    	</div>
                    </div>
                	<div class="form-group">
        				<input type="submit" class="btn btn-dark" value="submit" formnovalidate>
            		</div>
        		</form:form>
    		</div>
        </div>
</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>