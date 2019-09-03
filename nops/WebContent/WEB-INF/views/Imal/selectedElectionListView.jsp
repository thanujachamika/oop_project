<%@page import="com.nops.model.ElectionModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nops.service.ImalResultsService"%>
<%@page import="com.nops.service.ImalResultsService"%>

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
				          <li class="menu-active"><a href="index.jsp">Home</a></li>
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
						<h2>View <b>Results</b></h2>
					</div>
					
                </div>
            </div>

	  <div class="row" >
    <div class = "container">
      <div class="table-responsive">
        <table class="table" id="table1">
          
          <tbody>
			<tr style = "background-color: #EFEFEF">
              <th>Election ID</th>
              <th>Election Name</th>
              <th>Election Date</th>
              <th>Election Cycle</th>
              <th>Results</th>
            </tr>
			
			
			<%
				
				ImalResultsService hs = new ImalResultsService();
				ArrayList<ElectionModel> al = hs.returnElectionList((String)request.getAttribute("ElectionID"));
				
				for(ElectionModel e : al){
			%>
		  
            <tr>
              <td><%=e.getEid() %></td>
              <td><%=e.getEname() %></td>
              <td><%=e.getDate() %></td>
              <td><%=e.getEcycle() %></td>
              <td>
				
				<a href = "/nops/ImalResultsServlet?eid=<%=e.getEid() %>">View Results</a>
			  </td>

            </tr>
            <%
				}
            %>
            

          </tbody>
        </table>
      </div>
	</div>
  </div>

	
		</body>
	</html>