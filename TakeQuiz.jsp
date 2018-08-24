<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Quizzing.css">
<script type="text/javascript">
	function Score()
	{
		alert("your score is "+score);	
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="topnav">
<a class="left" href="#home">Home</a>
<a class="left" href="#takequiz">Take Quiz</a>
<a class="left" href="#About">About</a>
<a class="left" href="Contact">Contact Us</a>
<a class="right" href="#Login">Login</a>
</div>

<%int c=0; int score=0; %>
<form onsubmit="Score()">
	<c:forEach var="qui" items="${quiz}">
		<%c++; %>
		<%out.println(c); %>&nbsp;<c:out value="${qui.question_stmt}"/><br>
		<input type=radio name="t" value="<c:out value="${qui.option1}"/>"><br>
		<input type=radio name="t" value="<c:out value="${qui.option2}"/>"><br>
		<input type=radio name="t" value="<c:out value="${qui.option3}"/>"><br>
		<input type=radio name="t" value="<c:out value="${qui.option4}"/>"><br>	
		<% String res=request.getParameter("t");%>
		<c:if test="${res==qui.correct }">
			<%score++; %>
		</c:if>
	</c:forEach>
	<input type="submit" />	
</form>
</body>
</html>