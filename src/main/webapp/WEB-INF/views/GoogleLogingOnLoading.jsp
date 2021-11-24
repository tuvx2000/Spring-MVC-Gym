<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>

</head>
<body>


	<div style="text-align:center;align-items:center;align-self:center;justify-items:center;position:absolute;left:50%;top:50%;transform:translate(-50%,-50%);">
		<h3 style="color: #f39c12">Loading....</h3>
		<div>
		<div class="spinner-border text-primary"></div>
		<div class="spinner-border text-success"></div>
		<div class="spinner-border text-info"></div>
		<div class="spinner-border text-warning"></div>
		<div class="spinner-border text-danger"></div>
		<div class="spinner-border text-secondary"></div>
		<div class="spinner-border text-dark"></div>
		</div>
	</div>

	<div hidden class="g-signin2" data-onsuccess="onSignIn"></div>
	<div hidden class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->

	

		<div  class="main-div">

			<hr>
			<c:if test="${param.incorrectAccount != null}">
				<div class="alert alert-danger">Username or Password is
					incorrect!</div>
			</c:if>
			<c:if test="${param.accessDenied != null}">
				<div class="alert alert-danger">AccessDenied, You are not
					Authorized!</div>
			</c:if>
			<form action="j_spring_security_check" id="formLogin" method="post">
				<div class="form-group">
					<input type="text" class="form-control" id="userName"
						name="j_username" value=${j_username}>
				</div>

				<div class="form-group">
					<input type="password" class="form-control" id="password"
						name="j_password" value=${j_password}>
				</div>
				<button id="LoginGoogleButton" type="submit" class="btn btn-primary">Sign In</button>
			</form>
		</div>
	</div>
	</div>

	<script type="text/javascript">
		function onSignIn(googleUser) {

			document.getElementById("LoginGoogleButton").click();

		}
	</script>
</body>
</html>