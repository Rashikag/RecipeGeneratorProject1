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
{ background:url('https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=631&q=80') fixed no-repeat;
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
}
.mid{
padding-top: 160px;
padding-left:740px;

}
h2{
color:#008080;
padding-left:140px;
padding-bottom:20px;
font-family:  Acme ;
font-weight:bold;
}
.new
{
color:#008080;
padding-left:120px;
padding-top:10px;
padding-bottom:20px;
font-family:  Acme ;
font-size:30px;
}
.col-form-label{
color:#008080;
font-family:  Acme ;
}
.enter
{color:black;
font-weight:bold;
}
.error{
color:#dc143c;
font-size:20px;
font-family:  Acme ;
margin-left:60px;
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
          Username <input class="enter" name="name" type="text" required/>
          Password <input class="enter" name="password" type="password" required/> 
          <input type="submit" class="btn btn-success" value="Login"/>
        </form>
         </div> 
       </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
    
</nav>

 <form action="/signup" method="POST">
 <div class="mid">
 <p><h2>Sign up!</h2></p>
 <div class="form-group row">
    <label for="username" class="col-sm-2 col-form-label">Username</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="username" placeholder="username" name="username">
    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" id=password" placeholder="Password" name="password">
    </div>
  </div>
  <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-6">
      <input type="email" class="form-control" id="email" placeholder="email@example.com" name="gmail">
    </div>
  </div>
  <div class="form-group row new">
    <div class="col-sm-4">
      <input type="submit" class="btn btn-success" value="Sign Up"/>
    </div>
  </div>
  <p class="error">${errorMessage}</p>
  </div>
  </form>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>