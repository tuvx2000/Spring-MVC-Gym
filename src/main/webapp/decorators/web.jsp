<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon"
	href="https://previews.123rf.com/images/vectorgalaxy/vectorgalaxy1805/vectorgalaxy180500457/101156842-gym-logo-png-isolated-on-white-background-for-your-web-and-mobile-app-design-colorful-vector-icon-br.jpg">

<!-- <title>10Real Gym-Center</title> -->
<title><dec:title default="10Real Gym-Center" /></title>


<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="google-signin-client_id"
	content="841081615376-3hbsvqkqpj1u4p943gpj93v0ki62tmjo.apps.googleusercontent.com">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap"
	rel="stylesheet">

<!--

TemplateMo 548 Training Studio

https://templatemo.com/tm-548-training-studio

-->
<!-- Additional CSS Files -->

<link href="<c:url value='/template/web/assets/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css" />



<link href="<c:url value='/template/web/assets/css/bootstrap.min.cs'/>"
	rel="stylesheet" type="text/css" />


<link href="<c:url value='/template/web/assets/css/font-awesome.css'/>"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value='/template/web/assets/css/templatemo-training-studio.css'/>"
	rel="stylesheet" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">


<!-- char -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js" integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>

<style>
div.fixed {
  position: fixed;
  bottom: 20px;
  right: 20px;
  width: 300px;
  border: 3px solid #73AD21;
  z-index: 99999999999999999999;
  
}
div.fixed div button {
font-family-sans-serif: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
font-family-monospace: SFMono-Regular,Menlo,Monaco,Consolas,"Liberation Mono","Courier New",monospace;
font-weight: 500;
font-size: 20px;color:#fff;

}

</style>

<dec:head />

</head>
<body style="background-color: #ecf0f1;">
	<div style="background-color:#fffa65;width:100px;float:left" class="fixed">
		<div style="text-align:center;">
			<button  style="background-color:#ed563b;">
						<a style="text-decoration:none;color:white" href="<c:url value='/chat' />" >
							Join Stream
						</a>	
			</button>
		</div>
		<div style="text-align:center;">
			<img height="70px" width="70px" alt="" src="<c:url value='/template/images/muscle.png' />">
		</div>
		
		
		
	</div>
	

	<div style="background-color: black;width:100%;height:70px;">
	</div>
	<%@ include file="/common/web/header.jsp"%>


	<dec:body />



	<%@ include file="/common/web/footer.jsp"%>
<!-- google -->
  <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>


	<!-- jQuery -->
	<script
		src="<c:url value='/template/web/assets/js/jquery-2.1.0.min.js'/>"></script>
	<!-- Bootstrap -->
	<script src="<c:url value='/template/web/assets/js/popper.js'/>"></script>
	<script src="<c:url value='/template/web/assets/js/bootstrap.min.js'/>"></script>

	<!-- Plugins -->
	<script
		src="<c:url value='/template/web/assets/js/scrollreveal.min.js'/>"></script>
	<script src="<c:url value='/template/web/assets/js/waypoints.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/assets/js/jquery.counterup.min.js'/>"></script>
	<script src="<c:url value='/template/web/assets/js/imgfix.min.js'/>"></script>
	<script src="<c:url value='/template/web/assets/js/mixitup.js'/>"></script>
	<script src="<c:url value='/template/web/assets/js/accordions.js'/>"></script>

	<!-- Global Init -->
	<script src="<c:url value='/template/web/assets/js/custom.js'/>"></script>



	<script
		src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
	<script
		src="<c:url value='/template/admin/paging/jquery.twbsPagination.min.js' />"></script>



</body>
</html>