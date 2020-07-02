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
body
{ background:url('https://images.unsplash.com/photo-1443808709349-353c8b390400?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=755&q=80') fixed no-repeat;
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
	font-size: 1.1em;
}

.right {
	margin-left: -1px;
}

.item {
	height: 290px;
	margin-left: 100px;
}


.start {
	padding-top: 80px;
	font-family: Alegreya;
	font-size: 2.5em;
color:white;
}
.label-text{
	font-weight: normal;
}
.error{
color:#dc143c;
font-size:20px;
font-family:  Acme ;
margin-left:180px;
padding-left:20px;
}

</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> RecipeGenerator</a>
			</div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<div>
						<form class="cred" action="/login" method="POST">
							Hello <input name="name" type="text" class="username"
								value=${name } readonly>
							<a href="/login"><button type="button" class="btn btn-warning" type="submit">Logout</button></a>
						</form>
					</div>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<form:form action="/home" method="POST" commandName="recipe">
		<div class="container">
			<p class="start">Welcome to the Pantry!!</p>
			<div class="container well">
				<div style="padding-bottom: 40px">
				<div class="form-row">
					<label for="ingredient">Ingredients</label>
					<form:select id="ingredient" class="custom-select col-md-12 form-control" path="ingredientNameList" multiple="true" required="true">
							<form:option value="" label="Select" />
							<form:options items="${ingredientList}" />
						</form:select>
				</div>
			</div>
				<div style="margin-top: 60px">
				<div class="form-row">
					<div class="col-md-4">
						<label for="recipeType" class="col-md-6" >Recipe Type</label>
						<div class="col-md-6">
						<div class="custom-control custom-radio custom-control-inline" id="recipeType">
						<form:radiobutton path="recipeType"  id="customRadioInline1"  cssClass="custom-control-input" value="Veg"></form:radiobutton>
						<label class="custom-control-label label-text" for="customRadioInline1" style="color:green">Veg</label>
					</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="recipeType"  id="customRadioInline2"  cssClass="custom-control-input" value="Non-Veg"></form:radiobutton>
							<label class="custom-control-label label-text" for="customRadioInline2" style="color: red">Non-Veg</label>
						</div>
						</div>
					</div>
					<div class="col-md-4">
						<label for="cuisine" class="col-md-6">Cuisine</label>
						<div class="col-md-6">
						<div class="custom-control custom-radio custom-control-inline" id="cuisine">
							<form:radiobutton path="cuisine"  id="cuisine1" cssClass="custom-control-input" value="Indian"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisine1" >Indian</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisine"  id="cuisine2"  cssClass="custom-control-input" value="American"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisine2" >American</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisine"  id="cuisine3"  cssClass="custom-control-input" value="Italian"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisine3" >Italian</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisine"  id="cuisine4" cssClass="custom-control-input" value="Chinese"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisine4" >Chinese</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisine"  id="cuisine5"  cssClass="custom-control-input" value="French"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisine5" >French</label>
						</div>
						</div>

					</div>
					<div class="col-md-4">
						<label for="cuisineType" class="col-md-6">Cuisine Type</label>
						<div class="col-md-6">
						<div class="custom-control custom-radio custom-control-inline" id="cuisineType">
							<form:radiobutton path="cuisineType"  id="cuisineType1" cssClass="custom-control-input" value="Starter"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisineType1" >Starter</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisineType"  id="cuisineType2"  cssClass="custom-control-input" value="Side Dish"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisineType2" >Side Dish</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisineType"  id="cuisineType3"  cssClass="custom-control-input" value="Main Course"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisineType3" >Main Course</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisineType"  id="cuisineType4" cssClass="custom-control-input" value="Soup"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisineType4" >Soup</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="cuisineType"  id="cuisineType5"  cssClass="custom-control-input" value="Dessert"></form:radiobutton>
							<label class="custom-control-label label-text" for="cuisineType5" >Dessert</label>
						</div>
						</div>
					</div>
				</div>
				</div>
			<div class="col-md-12">
			<button class="btn btn-primary col-sm-2">SEARCH</button>
			<div class="error">
            <p >${errorMsg}</p>
            </div>
			</div>
		</div>
		</div>
	</form:form>	
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

</body>
</html>