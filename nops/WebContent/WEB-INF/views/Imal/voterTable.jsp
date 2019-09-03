<!DOCTYPE html>
<%@page import="com.nops.model.PoliticalParty"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nops.service.ThanujaServiceImpl"%>
<%@page import="com.nops.service.ThanujaService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zxx" class="no-js">
		<head>
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Favicon-->
		<link rel="shortcut icon" href="img/fav.png">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Online polling system</title>

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="styles/css/linearicons.css">
			<link rel="stylesheet" href="styles/css/font-awesome.min.css">
			<link rel="stylesheet" href="styles/css/bootstrap.css">
			<link rel="stylesheet" href="styles/css/magnific-popup.css">
			<link rel="stylesheet" href="styles/css/nice-select.css">							
			<link rel="stylesheet" href="styles/css/animate.min.css">
			<link rel="stylesheet" href="styles/css/owl.carousel.css">
			<link rel="stylesheet" href="styles/css/main.css">	
		</head>
		<body>	
			  <header id="header" id="home">
		  		<div class="header-top">
		  			<div class="container">
				  		<div class="row">
				  			<div class="col-lg-6 col-sm-6 col-4 header-top-left no-padding">
				  				<ul>
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
									<li><a href="#"><i class="fa fa-behance"></i></a></li>
				  				</ul>
				  			</div>
				  			<div class="col-lg-6 col-sm-6 col-8 header-top-right no-padding">
				  				<a href="tel:(+94)112868426">(+94)112868426</a>
				  				<a href="mailto:info@elections.gov.lk">info@elections.gov.lk</a>				
				  			</div>
				  		</div>			  					
		  			</div>
				</div>
			    <div class="container main-menu">
			    	<div class="row align-items-center justify-content-between d-flex">
				      <div id="logo">
				        <a href="#"><img src="styles/img/srilanka/logo-01-1.png" alt="" title=""  width = "200px" height = "50px"/></a>
				      </div>
				      <nav id="nav-menu-container">
				        <ul class="nav-menu">
				          <li class="menu-active"><a href="../../index.jsp">Home</a></li>
				          <li><a href="#">About</a></li>
				          <li><a href="#">Cast vote</a></li>
				          <li><a href="#">Results</a></li>
				          <li class="menu-has-children"><a href="#">Log in</a>
				            <ul>
				              <li><a href="#">Voter</a></li>
				              <li><a href="#">Admin</a></li>
				            </ul>
				          </li>						          			              	          
				          <li><a href="#">Contact</a></li>
				        </ul>
				      </nav><!-- #nav-menu-container -->		    		
			    	</div>
			    </div>
			  </header><!-- #header -->
			  
			  
			  <div style="height: 175px;"></div>
			  
			  
			  
<link rel="stylesheet" href="styles/css/table.css">

<script src="styles/js/table.js"></script>			
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!--<div style="height: 100px;"></div>-->





<div class="container">

			<!--Title bar-->
           <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Voter List</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="addVoterForm" class="btn btn-success"><span>Add New Voter</span></a>
					</div>
                </div>
            </div>



  <div class="row" >
    <div class = "container">
      <div class="table-responsive">
        <table class="table" id="table1">
          
          <tbody>
			<tr style = "background-color: #EFEFEF">
              
              <th>First Name</th>
              <th>Last Name</th>
              <th>Other Names</th>
              <th>NIC</th>
              <th>Date of Birth</th>
              <th>Address No</th>
              <th>Address Street</th>
              <th>Address City</th>
              <th>Gender</th>
              <th>Race</th>
			  <th>Voter Email</th>
			  <th>Voter Contact</th>
			  <th>Voter Area Code</th>
			  <th>Update/Delete</th>
            </tr>
            
            <c:forEach var="voter" items="${VoterData}">   
				<tr>
				<td> <c:out value="${voter.fname}"></c:out></td>
				<td> <c:out value="${voter.lname}"></c:out></td>
				<td> <c:out value="${voter.oname}"></c:out></td>
				<td> <c:out value="${voter.nic}"></c:out></td>
				<td> <c:out value="${voter.dob}"></c:out></td>
				<td> <c:out value="${voter.addNo}"></c:out></td>
				<td> <c:out value="${voter.addStreet}"></c:out></td>
				<td> <c:out value="${voter.addCity}"></c:out></td>
				<td> <c:out value="${voter.gender}"></c:out></td>
				<td> <c:out value="${voter.race}"></c:out></td>
				<td> <c:out value="${voter.email}"></c:out></td>
				<td> <c:out value="${voter.contactNo}"></c:out></td>
				<td> <c:out value="${voter.areaCode}"></c:out></td>
				<td><a href = "/nops/ImalUpdateVoterServlet?nic=${voter.nic }">Edit</a></td>
				</tr>
		
		 </c:forEach>  
			
			

          </tbody>
        </table>
      </div>
	</div>
  </div>
</div>
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			<div style="height: 50px;"></div>  
			  
			  
			  
			  <!-- start footer Area -->		
			<footer class="footer-area section-gap">
				<div class="container">
					<div class="row">
						<div class="col-lg-3 col-md-12">
							<div class="single-footer-widget">
								<h6>For voters</h6>
								<ul class="footer-nav">
									<li><a href="#">How can I get Registered?</a></li>
									<li><a href="#">Check Your Registration</a></li>
									<li><a href="#">Voter Forms</a></li>
									<li><a href="#">Number of Registered Electors</a></li>
									<li><a href="#">FAQ for Voters</a></li>
									
								</ul>
							</div>
						</div>
						<div class="col-lg-6  col-md-12">
							<div class="single-footer-widget newsletter">
								<h6>Newsletter</h6>
								<p>You can trust us. we only send promo offers, not a single spam.</p>
								<div id="mc_embed_signup">
									<form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="form-inline">

										<div class="form-group row" style="width: 100%">
											<div class="col-lg-8 col-md-12">
												<input name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '" required="" type="email">
												<div style="position: absolute; left: -5000px;">
													<input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
												</div>
											</div> 
										
											<div class="col-lg-4 col-md-12">
												<button class="nw-btn primary-btn">Subscribe<span class="lnr lnr-arrow-right"></span></button>
											</div> 
										</div>		
										<div class="info"></div>
									</form>
								</div>		
							</div>
						</div>
						
					
					<div class="col-lg-3 col-md-12">
							<div class="single-footer-widget">
								<h6>Parties & candidates</h6>
								<ul class="footer-nav">
									<li><a href="#">How to Register?</a></li>
									<li><a href="#">Ethics</a></li>
									<li><a href="#">Recognized Political Parties & Symbols</a></li>
									<li><a href="#">Relevant Downloads</a></li>
									<li><a href="#">FAQ for Political Parties</a></li>
									
								</ul>
							</div>
						</div>
					
					
					

					<div class="row footer-bottom d-flex justify-content-between align-items-center">
						<p class="col-lg-8 col-sm-12 footer-text m-0 text-white"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved <!--| This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
						<div class="col-lg-4 col-sm-12 footer-social">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-dribbble"></i></a>
							<a href="#"><i class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</footer>
			<!-- End footer Area -->	

			<script src="styles/js/vendor/jquery-2.2.4.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="styles/js/vendor/bootstrap.min.js"></script>			
			<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
  			<script src="styles/js/easing.min.js"></script>			
			<script src="styles/js/hoverIntent.js"></script>
			<script src="styles/js/superfish.min.js"></script>	
			<script src="styles/js/mn-accordion.js"></script>
			<script src="styles/js/jquery.ajaxchimp.min.js"></script>
			<script src="styles/js/jquery.magnific-popup.min.js"></script>	
			<script src="styles/js/owl.carousel.min.js"></script>						
			<script src="styles/js/jquery.nice-select.min.js"></script>	
			<script src="styles/js/jquery.counterup.min.js"></script>
			<script src="styles/js/waypoints.min.js"></script>							
			<script src="styles/js/mail-script.js"></script>	
			<script src="styles/js/main.js"></script>	
		</body>
	</html>