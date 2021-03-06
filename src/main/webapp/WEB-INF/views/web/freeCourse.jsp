<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DS bài học miễn phí</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="../jquery.twbsPagination.js" type="text/javascript"></script>
</head>

<body style="text-align: center;">
	<div class="table-responsive"  style="text-align:center;padding-left:30px;padding-right:30px">
		<table class="table table-hover table-dark" >
			<thead>
				<tr style="color:#f8c291">
					<th><h3>Name Course</h3></th>
					<th><h3>Short Description about the course</h3></th>
					<th><h3>Topic</h4></th>
					<th hidden> Link Youtube</th>
					<th><h3>Illustration</h3></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${model.listResult}">
					<tr>
						<td style="padding-top:150px;font-size: 120%;">${item.name}</td>
						<td style="padding-top:150px;font-size: 120%;">${item.description}</td>
						<td style="padding-top:150px;font-size: 120%;">${item.topic}</td>
						<td hidden >${item.linkyoutube}</td>
						<td >
						
						<iframe width="560" height="315"
								src="https://www.youtube.com/embed/${item.linkyoutube}"
								title="YouTube video player" frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen></iframe></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		<div style="width:100px;padding-left:550px;">
				<form style="width:100px;" action="<c:url value='/danh-sach-bai-hoc-mien-phi'/>" id="formSubmit" method="get">
				<ul style="width:100px;"  class="pagination" id="pagination"></ul>	
				<input type="hidden" value="" id="page" name="page"/>
				<input type="hidden" value="" id="limit" name="limit"/>		
				</form>			
		</div>
		
		


<!-- <div class="container"> -->
<!--     <nav aria-label="Page navigation"> -->
<!--         <ul class="pagination" id="pagination"></ul> -->
<!--     </nav> -->
<!-- </div> -->

		</div>


		<!-- /.main-content -->
<script type="text/javascript">
	var totalPages =  ${model.totalPage};
	var currentPage = ${model.page};
	$(function () {
	    window.pagObj = $('#pagination').twbsPagination({
	        totalPages: totalPages,
	        visiblePages: 10,
	        startPage: currentPage,
	        onPageClick: function (event, page) {
	        	if (currentPage != page) {
	        		$('#limit').val(5);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
	        }
	    });
	});

		</script>
</body>

</html>