<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài học miễn phí</title>
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

	<div class="table-responsive"  style="text-align: center;">
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
						
						<iframe width="560" height="315"
								src="https://www.youtube.com/embed/${item.linkyoutube}"
								title="YouTube video player" frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen></iframe></td>

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