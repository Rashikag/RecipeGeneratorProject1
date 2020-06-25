<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body
{ background:url('https://images.unsplash.com/photo-1579729056339-d9f3b4b979f2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80') fixed no-repeat;
	background-size: cover;
	background-position: center;
}
.navbar-inverse .navbar-brand 
{
	font-family: Coiny    ;
	color: #eeefff;
	font-size: 1.7em; 

}
.cred{
color: #eeefff;
padding-top: 10px;
padding-right:10px;
font-family: Coiny;
font-size: 1.1em; 
}
.username{
background-color:#202020;
color:#eeefff;
font-family: Coiny    ;
border:0;
}
.right
{
	margin-left: -1px;
}
.recipe{
margin-top:90px;
font-family:cursive;
font-size:40px;
margin-bottom:30px;
margin-left:400px;
}
.image{
margin-top:-250px;
margin-left:110px;
}
.details{
border:0;


}

.mail{
margin-left:-340px;
margin-top:200px;
padding:10px 70px;

}
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"> RecipeGenerator</a>
    </div>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav navbar-right">
        <div>
     	 <form class="cred" action="/login" method="POST">
          Hello <label for="name" class="username"></label>
          <button type="button" class="btn btn-warning" type="submit" >Logout</button>
         </form>
         </div> 
       </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  </nav>
  <div class="container">
  <label for="recipe_name" class="recipe">Chickpea Salad</label>
  <table>
  <tr>
  <th>
  <textarea id="details" name="details" class="jumbotron details" rows="25" cols="60">
  •	1 tablespoon oil
•	1 onion, chopped
•	1 stalk celery, chopped
•	3 cloves garlic, minced
•	1 teaspoon salt
•	¼ teaspoon pepper
•	2 tablespoons tomato paste
•	28 oz crushed tomato(795 g), 2 cans
•	6 cups vegetable broth(1 ½ L)

Instructions
1.	Combine oil, onion, celery, and garlic over medium heat in a large pot. Sauté for 3 minutes until onions are translucent.
2.	Add salt, pepper, tomato paste, basil, crushed tomatoes, broth, baking soda, and thyme. Bring to a boil.
3.	Lower heat and cover, simmering for 15 minutes.
4.	Uncover and remove thyme.
5.	Use an immersion or countertop blender to blend the soup until smooth.
6.	Allow to cool 2 minutes and serve topped with basil.
  
  </textarea>
  </div>
  </th>
  <th>
  <div>
  <img class="jumbotron image" src="https://images.unsplash.com/photo-1526991204058-9d45349da374?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60" width="450" height="350">
    </div>
    </th>
    <th>
    <button class="btn btn-success mail">Take to mail</button>
    </tr>
  </table>
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
</body>
</html>