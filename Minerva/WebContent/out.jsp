<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Sandhana - OpenID Test</title>

</head>
<body>

	<div id="content">
		<div id="colOne">
			<h2>OpenID Attribute exchange with Google</h2>
			<p>&nbsp;</p>

			<div>
				<fieldset>
					<legend>Results</legend>
					<table>
						<tr>
							<td>OpenID</td>
							<td><%=request.getParameter("openid")%></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><%=request.getParameter("email")%></td>
						</tr>
						<tr>
							<td>First Name</td>
							<td><%=request.getParameter("firstname")%></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><%=request.getParameter("lastname")%></td>
						</tr>
						<tr>
							<td>Country</td>
							<td><%=request.getParameter("country")%></td>
						</tr>
						<tr>
							<td>Language</td>
							<td><%=request.getParameter("language")%></td>
						</tr>
					</table>
				</fieldset>
			</div>

		</div>
	</div>

</body>
</html>
