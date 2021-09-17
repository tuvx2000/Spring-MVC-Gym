<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />



<link
	href="<c:url value='/template/admin/css/styles.css'/>" rel="stylesheet"  />


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>


</head>
<body class="sb-nav-fixed">

	<%@ include file="/common/admin/header.jsp" %>
	<dec:body/>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
		
	<script src="<c:url value='/template/admin/js/scripts.js'/>"></script>
		
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>

		<script src="<c:url value='/template/admin/assets/demo/chart-area-demo.js'/>"></script>
		<script src="<c:url value='/template/admin/assets/demo/chart-bar-demo.js'/>"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
		
	<script src="<c:url value='/template/admin/js/datatables-simple-demo.js'/>"></script>
</body>
</html>