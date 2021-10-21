<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài học trả phí</title>
</head>

<body style="text-align: center;">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<video width="200" height="150" controls>
		<source
			src="https://xuantu-spring-db.s3.ap-southeast-1.amazonaws.com/Snaptik_7004450901670825222_manchester-united.mp4"
			type="video/mp4">
	</video>
	<div class="table-responsive" style="text-align: center;">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Tên bài viết</th>
					<th>Mô tả ngắn</th>
					<th>Thao tác</th>
					<th>Chủ đề</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${model.listResult}">
					<tr>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>${item.topic}</td>
						<td>
						<a href="https://www.google.com/">
						<img src="${item.thumbnail}"  width="250" height="165">
						</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>


		<!-- /.main-content -->
		<script>
			var currentPage = $
			{
				model.page
			};
			var totalPages = $
			{
				model.totalPage
			};

			$(function() {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages : totalPages,
					visiblePages : 10,
					startPage : currentPage,
					onPageClick : function(event, page) {
						if (currentPage != page) {
							$('#limit').val(2);
							$('#page').val(page);
							$('#formSubmit').submit();
						}
					}
				});
			});
		</script>
</body>

</html>