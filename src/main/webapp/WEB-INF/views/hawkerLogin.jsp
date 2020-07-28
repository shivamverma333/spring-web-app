<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
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
<body class="login">
	<div  class="container">
        	<div class="content-section">
        		<form:form action="/hawker/login" method="post" class="form-container" modelAttribute="loginForm">
        		<div class="d-flex justify-content-center"><img class="user-img" src="<c:url value="/resources/images/user.png"/>"></div>
        		
        	<% if(request.getAttribute("error")!=null){ %>
        		<div class="alert alert-danger alert-dismissible" role="alert">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  ${error}
                </div>
            <%} %>
        		<legend class="border-bottom mb-4">Hawker Log In</legend>
        			<div class="form-group">
                    	<label class="form-control-label">Username</label>
                        <form:input path="username" type="text" class="form-control form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="username"/></span>
                        </div>
                	</div>
                	
                	<div class="form-group">
                    	<label class="form-control-label">Password</label>
                        <form:input path="password" type="password" class="form-control form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="password"/></span>
                        </div>
                	</div>
                	<div class="form-group">
        				<input type="submit" class="form-control btn btn-primary" value="submit" formnovalidate>
            		</div>
        		</form:form>
        		<div class="text-center"><span><a class="text-danger" href="/hawker/register">New user? Click here to Register</a></span></div>
    		</div>
        </div>
</body>

<script>
	var username=document.getElementById("username");
	if(document.getElementById("username.errors")!=null){
		username.classList.add("is-invalid");
	}else{
		if(username.classList.contains("is-invalid")){
			username.classList.remove("is-invalid");
		}
	}
	var password=document.getElementById("password");
	if(document.getElementById("password.errors")!=null){
		password.classList.add("is-invalid");
	}else{
		if(password.classList.contains("is-invalid")){
			password.classList.remove("is-invalid");
		}
	}

</script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</html>



