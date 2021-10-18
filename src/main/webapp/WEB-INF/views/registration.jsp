<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">Username or Password is
						incorrect!</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">AccessDenied, You are not
						Authorized!</div>
				</c:if>
				<form action="<c:url value='/dang-ky'/>" id="formLogin"
					method="POST" name="frmRegister">

					<div class="form-group">
						<input type="text" class="form-control" id="fullName"
							name="j_fullname" placeholder="Tên người dùng">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="j_password" placeholder="Mật khẩu">
					</div>
					<button type="submit" class="btn btn-primary">Sign Up</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>