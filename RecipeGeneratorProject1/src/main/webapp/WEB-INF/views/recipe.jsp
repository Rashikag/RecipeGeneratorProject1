<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
		  rel="stylesheet">
	<style>
		.navbar-inverse .navbar-brand {
			font-family: Coiny;
			color: #eeefff;
			font-size: 1.7em;
		}

		.cred {
			color: #eeefff;
			padding-top: 10px;
			padding-right: 10px;
			font-family: Coiny;
			font-size: 1.1em;
		}

		.username {
			background-color: #202020;
			color: #eeefff;
			font-family: Coiny;
			border: 0;
		}

		
	</style>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> RecipeGenerator</a>
		</div>
		<div >
			<ul class="nav navbar-nav navbar-right">
				<div>
					<form class="cred" action="/login" method="POST">
						Hello <input name="name" type="text" class="username"
									 value=${name } readonly>
						 <a href="/home"><button type="button" class="btn btn-warning" type="submit">Back</button></a>
						<a href="/login"><button type="button" class="btn btn-warning" type="submit">Logout</button></a>
					</form>
				</div>
			</ul>
		</div>
	</div>
</nav>
<div>
<form action="/recipe" method="POST">
	<div class="container">
		<c:forEach var="recipeInfo" items="${allRecipeDetails}">
			<div class="card row well" style="clear: both; margin-bottom: 10px;">
				<img class="card-img-top col-md-4 float-left" src="${recipeInfo.recipeImage}" width="400px">
				<div class="col-md-8 float-right">
					<div>
						<h3 style="margin-top: 0">${recipeInfo.recipeTitle}</h3>
						<div style="width: inherit">${recipeInfo.details}</div>
				</div>
			</div>
			</div>
		</c:forEach>
	</div>

</form>
</div>

<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>