<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    


  </head>
<body>
	<br>
	<div align='center'>
		<h2>
			Hey You..!! This is your 1st Spring MCV Tutorial..<br> <br>
		</h2>
		<h3>
			<a href="login.html">Click here to See Welcome Message... </a>(to
			check Spring MVC Controller... @RequestMapping("/login"))
		</h3>
	</div>
	<form method="GET" action = "index.html">
		<input type="hidden" name = "test" value ="Beforetest"></input>
		<button type="submit" id="btestbtn"></button>
	</form>
	<form method="GET" action = "index.html">
		<input type="hidden" name = "test" value ="Aftertest"></input>
		<button type="submit" id="atestbtn"></button>
	</form>
</body>
</html>
