<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="no">
<head>
<title>Project:Minerva</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="generator" content="Eclipse Juno" />
<meta name="author" content="dj" />
<link rel="shortcut icon" href="" />
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/bootstrap.js"></script>
<%
String contentPage = request.getParameter("page");
if (contentPage == "" || contentPage == null) {
	contentPage = "home";
}
%>
</head>
<style type="text/css">
BODY {
	padding-top: 15px;
}
</style>
<body>
<div class="container">

<%--	Header + login field	--%>
  <div class="row">
	<div class="span9">
	  <a href="./"><img src="logo.png" style="width:50%;height:50%" /></a>
	</div>
	<div class="span3">
	  <form class="well">
	  <input type="text" class="span2" placeholder="Brukernavn" /><br />
	  <input type="password" class="span2" placeholder="Passord" /><br />
	  <div class="btn-group">
	    <button class="btn btn-primary btn-small">Logg inn</button>
	  </div>
	  </form>
	</div>
  </div>
  
  <%--	Navigation	--%>
  <div class="row">
    	<div class="span12">
			<!--  <div class="navbar nav-tabs navbar-static-top"><div class="navbar-inner">-->
				<ul class="nav">
				 <li<%if(contentPage.equals("home"))out.print(" class=\"active\"");%>>
				 	<a href="./"><i class="icon-home"></i>&nbsp;Hjem</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("topics"))out.print(" class=\"active\"");%>>
				 	<a href="?page=topics"><i class="icon-star"></i>&nbsp;Emner</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("news"))out.print(" class=\"active\"");%>>
				 	<a href="?page=news"><i class="icon-list-alt"></i>&nbsp;Nyheter</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("search"))out.print(" class=\"active\"");%>>
				 	<a href="?page=search"><i class="icon-search"></i>&nbsp;S&oslash;k</a>
				 </li>
				 <li class="divider-vertical"></li>
				 <li<%if(contentPage.equals("info"))out.print(" class=\"active\"");%>>
				 	<a href="?page=info"><i class="icon-asterisk"></i>&nbsp;Informasjon</a>
				 </li>
				</ul>
			<!--  </div></div>-->
    	</div>
  </div>
  
<% // Include page content files
	if (contentPage.equals("home")) {%>
		<%@ include file="home.jsp" %>
<%	}
	if (contentPage.equals("topics")) {%>
		<%@ include file="topic_chooser.html" %>
<%	}
	if (contentPage.equals("news")) {%>
		<%@ include file="news.jsp" %>
<%	}
	if (contentPage.equals("search")) {%>
		<jsp:include page="search.jsp"></jsp:include>
<%	}
	if (contentPage.equals("info")) {%>
		<jsp:include page="info.jsp" />
<%	} %>

</div>
</body>
</html>
