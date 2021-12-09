<%@include file="/common/taglib.jsp"%>
<%@ page import="com.xuantujava.util.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
<!--  All snippets are MIT license http://bootdey.com/license -->
<title>Paid Course</title>

	<link
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
		rel="stylesheet">
</head>
<body>
<!-- name video course -->
	<div><h4 style="text-align:center;"> ${name}</h4></div>
<!-- name video course -->
<!-- video course -->
				<div class="embed-responsive embed-responsive-16by9">
				  <iframe class="embed-responsive-item" src="${s3path}"></iframe>
				</div>
<!-- video course -->

<!-- comment section -->

	<div class="container bootdey">
		<div class="col-md-12 bootstrap snippets">
			<div class="panel">
				<div class="panel-body">
					<!-- post binh luan -->
					<div style="width: 100%%;">
						<form action="<c:url value='/post-binh-luan'/>" method="POST">
							<input hidden type="text" name="userName"
								value="<%=SecurityUtils.getPrincipal().getUsername()%>">
							<input hidden type="text" name="parentIDCOMMENT" value="0">
							<input hidden type="text" name="courseid" value="${courseid}">
							<div class="form-group">
								<input type="text" class="form-control" id="fullName"
									name="comment" placeholder="what are you thinking">
							</div>
							<button type="submit" class="btn btn-primary">Post
								comment</button>
						</form>
					</div>

				</div>
			</div>
			<!-- 			 Đây là bắt đầu comment -->




			<div class="panel">
				<div class="panel-body">


					<!-- Newsfeed Content -->
					<!--===================================================-->
					<c:forEach var="item" items="${model.listResult}">
						<c:if test="${item.parentIDCOMMENT == 0}">

							<div class="media-block">
								<a class="media-left" href="#"><img
									class="img-circle img-sm" alt="Profile Picture"
									src="https://bootdey.com/img/Content/avatar/avatar1.png">
								</a>
								<div class="media-body ">
									<div class="mar-btm">
										<a href="#"
											class="btn-link text-semibold media-heading box-inline">${item.userFullName}</a>
									</div>
									<p> ${item.comment}</p>
									<!-- Comments -->
									<c:forEach var="item1" items="${model.listResult}">
										<c:if test="${item1.parentIDCOMMENT == item.IDCOMMENT}">
											<div>
												<div class="media-block level1">
													<a class="media-left" href="#"><img
														class="img-circle img-sm" alt="Profile Picture"
														src="https://bootdey.com/img/Content/avatar/avatar2.png"></a>
													<div class="media-body">
														<div class="mar-btm">
															<a href="#"
																class="btn-link text-semibold media-heading box-inline">${item1.userFullName}</a>
														</div>
														<p>${item1.comment}</p>
<%-- 														<p>${item1.userid}</p> --%>
<%-- 														<p>${item1.parentIDCOMMENT}</p> --%>
<%-- 														<p>${item1.IDCOMMENT}</p> --%>
													</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
									<!-- post binh luan -->
									<div class="panel">
										<div class="panel-body">
											<div style="width: 100%%;">
												<form action="<c:url value='/post-binh-luan'/>"
													method="POST">
													<input hidden type="text" name="userName"
														value="<%=SecurityUtils.getPrincipal().getUsername()%>">
													<input hidden type="text" name="parentIDCOMMENT"
														value="${item.IDCOMMENT}"> <input hidden
														type="text" name="courseid" value="${courseid}">
													<div class="form-group">
														<input type="text" class="form-control" id="fullName"
															name="comment" placeholder="what are you thinking">
													</div>
													<button type="submit" class="btn btn-primary">Post
														comment</button>
												</form>
											</div>
										</div>
									</div>

								</div>
							</div>
						</c:if>
					</c:forEach>




				</div>
			</div>
		</div>
	</div>

	<style type="text/css">
body {
	margin-top: 20px;
	background: #ebeef0;
}
.media-body{
	padding-left:15px;
}
.level1{
	padding-top:15px;	

}
.img-sm {
	width: 46px;
	height: 46px;
	border-radius: 5px;
}

.panel {
	box-shadow: 0 2px 0 rgba(0, 0, 0, 0.075);
	border-radius: 0;
	border: 0;
	margin-bottom: 15px;
}

.panel .panel-footer, .panel>:last-child {
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.panel .panel-heading, .panel>:first-child {
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.panel-body {
	padding: 25px 20px;
}

.media-block .media-left {
	display: block;
	float: left
}

.media-block .media-right {
	float: right
}

.media-block .media-body {
	display: block;
	overflow: hidden;
	width: auto
}

.middle .media-left, .middle .media-right, .middle .media-body {
	vertical-align: middle
}

.thumbnail {
	border-radius: 0;
	border-color: #e9e9e9
}

.tag.tag-sm, .btn-group-sm>.tag {
	padding: 5px 10px;
}

.tag:not (.label)
{
background-color:#fff;
padding:6px 12px;
border-radius: 2px;
border: 1px solid #cdd6e1;
font-size: 12px;
line-height: 1.42857;
vertical-align: middle;
-webkit-transition: all .15s ;
transition all .15s ;
}
.text-muted, a.text-muted:hover, a.text-muted:focus {
	color: #acacac;
}

.text-sm {
	font-size: 0.9em;
}

.text-5x, .text-4x, .text-5x, .text-2x, .text-lg, .text-sm, .text-xs {
	line-height: 1.25;
}

.btn-trans {
	background-color: transparent;
	border-color: transparent;
	color: #929292;
}

.btn-icon {
	padding-left: 9px;
	padding-right: 9px;
}

.btn-sm, .btn-group-sm>.btn, .btn-icon.btn-sm {
	padding: 5px 10px !important;
}

.mar-top {
	margin-top: 15px;
}
</style>

	<script type="text/javascript">
		
	</script>
</body>
</html>