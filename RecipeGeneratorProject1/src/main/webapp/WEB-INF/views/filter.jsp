<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	font-size: 1.1em;
}

.right {
	margin-left: -1px;
}

#carousel-example-generic {
	margin-left: 220px;
	margin-top: 60px;
	height: 290px;
	width: 920px;
	position: center;
	margin-bottom: 60px;
}

.item {
	height: 290px;
	margin-left: 100px;
}

.table {
	margin-top: 50px;
	margin-bottom: -40px;
}

tr {
	height: 40px;
}

.dropdown {
	margin-top: 7px;
	margin-left: 7px;
}

.start {
	padding-top: 80px;
	font-family: Alegreya;
	font-size: 2.5em;
	color: #3b5323;
}

.search {
	margin-left: 480px;
	margin-top: 80px;
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
								value=${name } readonly>
							<button type="button" class="btn btn-warning" type="submit">Logout</button>
						</form>
					</div>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<form:form action="/filter" method="POST" commandName="recipe">
		<div class="container">
			<p class="start">Welcome to the Pantry!!</p>
			<table class="table">
				<tr>
					<th>Ingredients</th>
					<th><form:select class="dropdown col-sm-12" path="ingredientNameList" multiple="true" required="true">
							<form:option value="" label="Select" />
							<form:options items="${ingredientList}" />
						</form:select></th>
						<th></th>
					<th></th>
					<th></th>
				</tr>
				<tr> 
					<th>Veg/Non-Veg</th>
					<th>
						<div >
							<label><form:radiobutton  path="recipeType"
									value="Veg" /><font color="green">   VEG</font></label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton  path="recipeType"
									value="Non-Veg" /><font color="red">   NON-VEG</font></label>
						</div>
					</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>Cuisine</th>
					<th>
						<div>
							<label><form:radiobutton path="cuisine"
									value="Indian" /><font>   Indian</font></label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton path="cuisine"
									value="American" /><font>   American</font></label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton path="cuisine"
									value="Italian" /><font>   Italian</font></label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton path="cuisine"
									value="Chinese" /><font>   Chinese</font></label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton path="cuisine"
									value="French" />   French</label>
						</div>
					</th>
				</tr>
				<tr>
					<th>Category</th>
					<th>
						<div>
							<label><form:radiobutton  path="cuisineType"
									value="Starter" /><font>   Starter</font></label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton  path="cuisineType"
									value="Side Dish" /><font>   Side Dish</font></label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton  path="cuisineType"
									value="Main Course" />   Main Course</label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton  path="cuisineType"
									value="Soup" />   Soup</label>
						</div>
					</th>
					<th>
						<div>
							<label><form:radiobutton path="cuisineType"
									value="Dessert" />   Dessert</label>
						</div>
					</th>
				</tr>
			</table>
			<button class="btn btn-primary col-sm-2 search">SEARCH</button>
		</div>
	</form:form>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			<li data-target="#carousel-example-generic" data-slide-to="3"></li>
			<li data-target="#carousel-example-generic" data-slide-to="4"></li>
		</ol>
		<!--  -->
		<!-- Wrapper for slides
    
   -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img
					src="https://images.unsplash.com/photo-1552590635-e94502090862?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
					width="700" height="50">
			</div>
			<div class="item">
				<img
					src="https://images.unsplash.com/photo-1543826173-cfe2ca17577d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
					width="700" height="50">
			</div>
			<div class="item">
				<img
					src="https://images.unsplash.com/photo-1512003867696-6d5ce6835040?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
					width="700" height="50">
			</div>
			<div class="item">
				<img
					src="https://images.unsplash.com/photo-1526991204058-9d45349da374?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
					width="700" height="50">
			</div>
		</div>

		<!-- Controls -->
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




	
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

</body>
</html>