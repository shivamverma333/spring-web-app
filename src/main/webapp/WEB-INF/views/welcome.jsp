<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>


<%@include file="header.jsp"%>
<h2 class="display-4 text-center">Our Features</h2>

<section>
<div id="services" class="row">
	<div class="col-lg-4 d-flex justify-content-center mt-3 mb-3">
		<span class="text-center"><img class="pqr" src="<c:url value="/resources/images/connect.png"/>"/><h3>Connects Hawkers and Customers</h3><p>This application provides hawkers to the customers and customers to the hawkers. It provides customers a convenient way of searching hawkers for daily services such as milk, water, newspaper etc. On the other side, this application is useful for hawkers as it provides them a large number of customers. </p></span>
	</div>
	<div class="col-lg-4 d-flex justify-content-center mt-3 mb-3">
		<span class="text-center"><img class="pqr" src="<c:url value="/resources/images/srch.png"/>"/><h3>Search Service</h3><p>Instead of searching milk man, water man, newspaper service manually, this application provides a convenient way of searching the services by entering the service name. It provides customers a different variety of choices based on price, quantity etc. and customers can choose the hawker according to their choice.</p></span>
	</div>
	<div class="col-lg-4 d-flex justify-content-center mt-3 mb-3">
		<span class="text-center"><img class="pqr" src="<c:url value="/resources/images/multiple.png"/>"/><h3>Multiple Choices</h3><p>Rather than sticking to only one  hawker, this  application  provides the facility to customers to choose more than one hawker for different services. Each connected hawker have separate details account independent of each other.</p></span>
	</div>
	<div class="col-lg-2 d-flex justify-content-center"></div>
	<div class="col-lg-4 d-flex justify-content-center mt-3">
		<span class="text-center"><img class="pqr" src="<c:url value="/resources/images/calendar.png"/>"/><h3>Add Leave Days</h3><p>This application provides the facility to customers to add leave days in a month when they does not want delivery of service. The per day amount will be deducted from the base monthly plan cost.</p></span>
	</div>
	<div class="col-lg-4 d-flex justify-content-center mt-3">
		<span class="text-center"><img class="pqr" src="<c:url value="/resources/images/payment.png"/>"/><h3>Tracking Monthly Payments</h3><p>No need to keep records of monthly payments manually which causes chaos and confusion. This application automatically keep tracks of monthly payment and generate payment bill every month which is shared to both customer and respective hawker.</p></span>
	</div>
	<div class="col-lg-2 d-flex justify-content-center"></div>
</div>
</section>



<section id="section" class="pt-3">
		<h2 class="display-4 text-center mt-0">Get Started!</h2> 
      <div class="row">
        <div class="col-lg-4 d-flex">
        	<div class="card card-class text-center pb-3">
        	<a class="text-dark" href="/customer/login">
        	   <img src="<c:url value="/resources/images/customer.png"/>" class="card-img-top">
  				<div class="card-body mt-0 pt-0">
  					<label>
    				<h3 class="text-center card-title">Customer</h3>
    				<p class="card-text">Click here if you are a customer and wants services.</p>
    				</label>
  				</div>
  			</a>
			</div>
        </div>
        <div class=" col-lg-4 d-flex">
        	<div class="card card-class text-center pb-3">
        	 <a class="text-dark" href="/hawker/login">
        	<img src="<c:url value="/resources/images/hawker.jpg"/>" class="card-img-top">
  				<div class="card-body mt-0 pt-0 pb-3">
  					<label>
    				<h3 class="text-center card-title">Hawker</h3>
    				<p class="card-text mb-3">Click Here if you are a hawker and wishes to provide services to customers.</p>
    				</label>
  				</div>
  				</a>
			</div>
        </div>
        <div class="col-lg-4  d-flex">
        	<div class="card card-class text-center pb-3">
        	<a class="text-dark" href="/admin/login">
        	<img src="<c:url value="/resources/images/admin.jpg"/>" class="card-img-top">
  				<div class="card-body mt-0 pt-0 pb-3">
  					<label>
    				<h3 class="text-center card-title">Admin</h3>
    				<p class="card-text">Click here if you are a admin of this application.</p>
    				</label>
  				</div>
  			</a>
			</div>
        </div>
       </div>
       </section>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>





