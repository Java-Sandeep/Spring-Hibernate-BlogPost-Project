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
	<!-- Form fields -->
	<div class="row">
		<div class="col s2"></div>
		<div class="col s8">
			<h3 class="center blue-text text-darken-2">Blog Post Form</h3>
			<hr>
			<form action="addblog.htm" method="post">
				<div class="row">
					<div class="input-field col s12">
						<input id="title" type="text" class="validate" name="title">
						<label for="title">Blog Title</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="subject" type="text" class="validate" name="subject">
						<label for="subject">Blog Subject</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<textarea id="content" class="materialize-textarea" name="content"></textarea>
						<label for="content">Blog Content</label>
					</div>
				</div>
				<div class="row center">
					<button class="btn waves-effect waves-light red darken-2"
						type="submit" name="action">
						Reset <i class="material-icons right"></i>
					</button>
					<button class="btn waves-effect waves-light" type="submit"
						name="action">
						Add Blog <i class="material-icons right"></i>
					</button>
				</div>
			</form>
		</div>
		<div class="col s2"></div>
	</div>






	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>

</body>
</html>
