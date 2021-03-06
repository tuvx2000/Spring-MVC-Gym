<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>

</head>

<style>

#logininput{
		border-radius: 20px;
		background-image: url("<c:url value='/template/images/logininput.jpg'/>");
		background-repeat: no-repeat;
		background-size: cover;
		
}

</style>
<body>
	<!-- 			Login POST -->

	<div style="display:none;">
		<form hidden  action="<c:url value='/google-dang-nhap'/>" method="post">
			<input  id="IdToken" type="text" name="IdToken">xxx </input> 
			<input id="SubIdToken" type="submit" /> xxx</input>
		</form>
	</div>
	<a hidden href="#" onclick="signOut();">Sign out</a>

	<div style="">
	<div class="container" style="text-align:center;align-items:center;align-self:center;justify-items:center;position:absolute;left:50%;top:50%;transform:translate(-50%,-50%);">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="main-div" 
		id="logininput"
		style="border-radius: 20px;background-color:#ecf0f1">
			<h1 hidden>
			<h2 hidden id="holder"></h2>
			</h1>
			<div style="width:150px;padding-left:60px;"  class="g-signin2" data-onsuccess="onSignIn"></div>
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
						name="j_username" placeholder="Tên đăng nhập">
				</div>

				<div class="form-group">
					<input type="password" class="form-control" id="password"
						name="j_password" placeholder="Mật khẩu">
				</div>
				<button type="submit" class="btn btn-primary">Sign In</button>
				<a  class="btn btn-info" href="<c:url value='/dang-ky' />">Sign Up</a>
			</form>
		</div>
	</div>
	</div>

	<script>
		function onSignIn(googleUser) {
			var profile = googleUser.getBasicProfile();
			console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
			console.log('Name: ' + profile.getName());
			console.log('Image URL: ' + profile.getImageUrl());
			console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

			document.getElementById("holder").innerHTML = profile.getId();

			// The ID token you need to pass to your backend:
			var id_token = googleUser.getAuthResponse().id_token;
			console.log("ID Token: " + id_token);

			document.getElementById("IdToken").value = googleUser
					.getAuthResponse().id_token;
 			document.getElementById("SubIdToken").click();
		}
		
		
		
		function signOut() {
		    var auth2 = gapi.auth2.getAuthInstance();
		    auth2.signOut().then(function () {
		      console.log('User signed out.');
		    });
		  }
	</script>


</body>
</html>