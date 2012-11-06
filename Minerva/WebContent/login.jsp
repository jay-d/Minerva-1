<div class="span3">
			<form class="well">
				<p>Welcome, <%=session.getAttribute("firstname")%> <%=session.getAttribute("lastname")%>!</p>
				<a href="viewprofile.jsp">My profile</a>
				<p>Log out</p>
			</form>
</div>