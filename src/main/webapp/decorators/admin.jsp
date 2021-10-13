<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Trang chủ" /></title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css' />"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="icon"
	href="data:image/png;base64,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">
<%--     <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script> --%>

<!-- <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>   -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>


x
</head>
<body class="no-skin">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- header -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- header -->

		<dec:body />

		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- footer -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>


	<script
		src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
	<script
		src="<c:url value='/template/admin/paging/jquery.twbsPagination.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>