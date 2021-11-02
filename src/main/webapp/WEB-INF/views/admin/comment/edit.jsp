<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/binh-luan/danh-sach"/>
<c:url var="editURL" value="/quan-tri/binh-luan/chinh-sua"/>
<c:url var ="NewAPI" value="/api/comment"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script> 
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa Bình Luận</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
						</c:if>
                        <form:form id="formSubmit" modelAttribute="model" role="form">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Content</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="comment" name="comment" value="${model.comment}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">User Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="userName" name="userName" value="${model.userName}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">User Id</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="userid" name="userid" value="${model.userid}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Course Id</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="courseid" name="courseid" style="width: 820px;height: 175px">${model.courseid}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <form:hidden path="id" id="commentid"/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật Bình luận" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Bình luận" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${model.id}" id="id" name="id"/>
                        </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
console.log("xxx");

// 	var editor = '';
// 	$(document).ready(function(){
// 		editor = CKEDITOR.replace( 'content');
// 	});
	
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) { 
            data[""+v.name+""] = v.value;
        });
//         data["content"] = editor.getData();
        var id = $('#commentid').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data);
        }
    	console.log("1");
		console.log(JSON.stringify(data));
    });
    function addNew(data) {
    	console.log("2");
        $.ajax({
            url: '${NewAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editURL}?page=1&limit=2?id=" +result.id +"&message=insert_success";
            	//?type=edit&id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?page=1&limit=2"+"&message=error_system";
            	//?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
    function updateNew(data) {
        $.ajax({
            url: '${NewAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editURL}?page=1&limit=2?id=" +result.id+"&message=update_success";
            	//?type=edit&id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?page=1&limit=2"+"&message=error_system";
            	//?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>
