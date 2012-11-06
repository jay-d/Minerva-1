<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>

</head>
<body>
	<div class="container">
		<div class="span6">
			<h1>Edit Profile</h1>
		</div>
		<div class="well span6">
			<button class="btn btn-primary">Upload picture...</button>
		</div>
		<br> <br>
		<form id="userInfo" class="well span6">
			<label>First name <input type="text" class="span3 pull-right" />
			</label><br> <label>Last name <input type="text"
				class="span3 pull-right" />
			</label><br> Date of Birth <input type="text" class="span1 pull-right"
				placeholder="DD" /> <input type="text" class="span1 pull-right"
				placeholder="MM" /> <input type="text" class="span1 pull-right"
				placeholder="YYYY" /> <br> <br> <label>E-mail <input
				type="text" class="span3 pull-right" />
			</label><br> <label>Confirm e-mail <input type="text"
				class="span3 pull-right" />
			</label><br> <label>New Pasword <input type="text"
				class="span3 pull-right" />
			</label><br> <label>Confirm new password <input type="text"
				class="span3 pull-right" />
			</label><br>
		</form>
		<br>
		<div class="well span6">
			<strong>Bio:</strong> <br>
			<textarea class="field span6" id="textarea" rows="6"
				placeholder="Write your bio here..."></textarea>
			<br>
			<button type="submit" class="btn btn-primary">Submit changes</button>
		</div>
	</div>


</body>
</html>