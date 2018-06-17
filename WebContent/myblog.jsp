<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Starter Template - Materialize</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
<body>
		<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="#" class="brand-logo">Blog Post
				Application</a>
		<ul class="right hide-on-med-and-down">
			<li><a href="login.htm">Logout</a></li>	
		</ul>

		<ul id="nav-mobile" class="sidenav">
			<li><a href="login.htm">Logout</a></li>
		</ul>
		<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
	</div>
	</nav>
	<div class="row">
		<div class="col s3"></div>
		<div class="col s6">
			<center>
				<a class="btn-floating btn-large waves-effect waves-light red" href="blog.htm"><i class="material-icons">add</i></a>
			</center>
			<ul class="collection">
			
			<%
				Connection con =  DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from blogpost where uid = " + session.getAttribute("uid"));
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
			%>
				<li class="collection-item avatar"><i
					class="material-icons circle">folder</i> <span class="title"><%= rs.getString(2) %></span>
					<p>
						<%= rs.getString(3) %>
					</p>
					<p>
						<%= rs.getString(4)%>
					</p>
					<p style="text-align: right"><%= rs.getString(5)%></p> 
					<a class="waves-effect waves-teal btn-flat" href='<%= "./editform.htm?bid="+ rs.getString(1)%>'><i
						class="material-icons large" >edit</i></a>
					<a class="waves-effect waves-teal btn-flat Medium" href='<%= "./delete.htm?bid="+ rs.getString(1)%>'><i
						class="material-icons" >delete</i></a>
				</li>
			<%} %>
			</ul>
			
		</div>
		<div class="col s3"></div>
	</div>






	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>

</body>
</html>
