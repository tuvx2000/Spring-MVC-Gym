<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài học trả phí</title>
</head>

<body style="text-align: center;">
	<div class="table-responsive" style="text-align: center;">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Course Name</th>
					<th>Short Description about this Course</th>
					<th>Topic</th>
					<th>Illustration</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${model.listResult}">
					<form action="<c:url value='/bai-hoc-tra-phi'/>" method="get">
						<tr>
							<input hidden name="courseid" type="text" value="${item.id}"></input>
							<td>${item.name}</td>
							<td>${item.description}</td>
							<td>${item.topic}</td>

							<td><img src="${item.thumbnail}" width="250" height="165">
							</td>
							<td><input  type="submit" value="Learn Now"></td>

						</tr>
					</form>

				</c:forEach>
			</tbody>
		</table>
</body>

</html>