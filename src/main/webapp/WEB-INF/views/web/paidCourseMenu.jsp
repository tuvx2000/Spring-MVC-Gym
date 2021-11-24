<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài học trả phí</title>

   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="../jquery.twbsPagination.js" type="text/javascript"></script>

</head>

<body style="text-align: center;">
	<div class="table-responsive" style="text-align:center;padding-left:30px;padding-right:30px">
		<table class="table table-hover table-dark">
			<thead>
				<tr style="color:#f8c291">
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
							<td style="padding-top:70px;font-size: 120%;">${item.name}</td>
							<td style="padding-top:70px;font-size: 120%;">${item.description}</td>
							<td style="padding-top:70px;font-size: 120%;">${item.topic}</td>

							<td><img src="${item.thumbnail}" width="250" height="165">
							</td>
							<td style="padding-top:70px;"><input class="btn btn-warning" type="submit" value="Learn Now"></td>

						</tr>
					</form>

				</c:forEach>
			</tbody>
		</table>
		
<%-- 		<form action="<c:url value='/danh-sach-bai-hoc-tra-phi'/>" id="formSubmit" method="get"> --%>
		
<!-- 		<ul class="pagination" id="pagination"></ul>	 -->
<!-- 		<input type="hidden" value="" id="page" name="page"/> -->
<!-- 		<input type="hidden" value="" id="limit" name="limit"/>		 -->
<!-- 		</form> -->
		
		<div style="width:100px;padding-left:550px;">
				<form style="width:100px;" action="<c:url value='/danh-sach-bai-hoc-tra-phi'/>" id="formSubmit" method="get">
				<ul style="width:100px;"  class="pagination" id="pagination"></ul>	
				<input type="hidden" value="" id="page" name="page"/>
				<input type="hidden" value="" id="limit" name="limit"/>		
				</form>			
		</div>
		
		
		
		</div>
	
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