<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background:
		url('https://images.unsplash.com/photo-1579729056339-d9f3b4b979f2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80')
		fixed no-repeat;
	background-size: cover;
	background-position: center;
}

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

.right {
	margin-left: -1px;
}

.recipetitle {
	margin-top: 30px;
	font-family: cursive;
	font-size: 40px;
	margin-bottom: 30px;
	margin-left: 400px;
}
.item {
	height: 290px;
	margin-left: 100px;
}
#carousel-example-generic {
	margin-left: 110px;
	padding-top: 60px;
	height: 290px;
	width: 920px;
	position: center;
	margin-bottom: 70px;
}

.image {
	margin-top: -250px;
	margin-left: 110px;
}

.details {
	border: 0;
}

.mail {
	margin-left: -340px;
	margin-top: 200px;
	padding: 10px 70px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> RecipeGenerator</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<div>
						<form class="cred" action="/login" method="POST">
							Hello <input name="name" type="text" class="username"
								value=${name} readonly>
							<button type="button" class="btn btn-warning" type="submit">Logout</button>
						</form>
					</div>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="container" >
		<form action="/recipef" method="POST" modelAttribute="allRecipeDetails">
		<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
		<c:forEach var="count" items="${allRecipeDetails}" >
			<li data-target="#carousel-example-generic" data-slide-to="${count.recipeImage}"
				class="active"></li>
				
		</c:forEach>
		</ol>
		<div class="carousel-inner" role="listbox">
		    <c:forEach var="photo" items="${allRecipeDetails}">
		    <div class="item active">
			 <img src="<c:out value="${photo.recipeImage}"/>" height="50px" width="700px"/>
            </div>
		    </c:forEach>
		</div>

		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
		
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
</body>
</html>