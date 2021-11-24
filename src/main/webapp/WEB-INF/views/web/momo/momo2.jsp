<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make Member</title>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br><br>
	<c:if test="${textStatus == null}">
		<h1 style="text-align:center">You Already in Membership</h1>
	</c:if>	
		<c:if test="${textStatus != null}">
		<h1 style="text-align:center">Please Make Member to go into Paid Courses</h1>
	</c:if>	
	<br><br><br><br><br><br>
</body>
</html>