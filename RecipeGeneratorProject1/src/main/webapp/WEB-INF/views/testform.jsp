<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	margin-top: 40px;
	margin-bottom: -33px;
	'
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
	margin-top: 50px;
}

img {
	z-index: -1;
}
</style>
</head>
<body>
	<form:form action="/testform" method="POST" commandName="ingredient">
		<div class="container">
			<p class="start">Welcome to the Pantry!!</p>
			<table class="table">
				<tr>
					<th>Ingredients</th>
					<th><form:select class="dropdown" path="ingredientName">
							<form:option value="" label="...." />
							<form:options items="${dairyList}" />
						</form:select></th>
					
				<!--  	<th><form:select class="dropdown" path="ingredientName">
							<form:option value="" label="...." />
							<form:options items="${vegList}" />
						</form:select></th>
					
					<th><form:select class="dropdown" path="ingredientName">
							<form:option value="" label="...." />
							<form:options items="${fruitList}" />
						</form:select></th>
							
					<th><form:select class="dropdown" path="ingredientName">
					        
							<form:option value="" label="...." />
							<form:options items="${grainList}" />
						</form:select></th>
								
					<th><form:select class="dropdown" path="ingredientName">
					        
							<form:option value="" label="...." />
							<form:options items="${proteinList}" />
						</form:select></th>			
				
					<th><form:select class="dropdown" path="ingredientName">
					        
							<form:option value="" label="...." />
							<form:options items="${packList}" />
						</form:select></th> -->
				</tr>
			</table>

			<button class="btn btn-primary col-sm-2 search" type="submit"
				name="submit">SEARCH</button>
			<textarea rows="10" cols="10">
  <c:forEach items="${allRecipeDetails}" var="recipe">
<tr>
<td>${recipe.details}</td>
</tr>
</c:forEach>
</textarea>
		</div>

	</form:form>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

</body>
</html>