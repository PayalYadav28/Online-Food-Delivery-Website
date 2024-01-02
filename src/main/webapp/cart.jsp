<%@page import="beans.Products"%>
<%@page import="database.UserData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.User" %>
<%@page import="beans.Cart" %>
<%@page import="beans.Products" %>
<%@page import="java.util.List"%>
    
 <%
    	User user1=(User)session.getAttribute("userD");
    	if(user1==null)
    	{
    		response.sendRedirect("login.jsp");
    		session.setAttribute("login-error","please Login...");
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<%@include file="includes/head.jsp" %>
<!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> Feane </title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
  <!-- nice select  -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <link href="index.css"rel="stylesheet">
  
</head>
<body>

	<%
	String updateMsg=(String)session.getAttribute("updateMsg");
	if(updateMsg!=null) {
	%>
	<div class="alert alert-success" role="alert"><%=updateMsg %></div>
		
	<%	
	
	session.removeAttribute("updateMsg");
	}
	
	%>
	
	<%
	String wrongMsg=(String)session.getAttribute("wrongMsg");
	if(wrongMsg!=null) {
	%>
	<div class="alert alert-danger" role="alert"><%=wrongMsg %></div>
		
	<%	
	
	session.removeAttribute("wrongMsg");
	}
	
	%>

<div class="container">
	<div class="d-flex py-3">
	
		
		<h3>Total Prize:</h3>
		<a class="mx-3 btn btn-primary" href="#">Check out</a>		
	</div>
	<table class="table table-loght">
		<thead>
		<tr>
			<th scope="col">images</th>
			<th scope="col">Dishname</th>
			<th scope="col">Description</th>
			<th scope="col">Price</th>
			<th scope="col">Buy Now</th>
			<th scope="col">Cancel</th>
			
		</tr>
	
		</thead>
		<tbody>
	
		<% 
		if(user1!=null){
			UserData ud=new UserData();
			List<Cart> products =ud.getCart(user1.getId());

				for(Cart c:products){%>
					
					<tr>
					<td><img src="<%=c.getImage()%>"></td>
					<td><%=c.getDishname() %></td>
					<td><%=c.getDescription()%></td>
					
					<td><%=c.getPrize()%></td>
					<td><a href="" class="order_online">Buy Now</a></td>
					<td><a href="CancelServlet?id=<%=c.getId()%>" class="order_online">Cancel</a></td>
					</tr>
				<%}
			}		
		%>	
	
		</tbody>
	</table>

</div>

</body>
</html>