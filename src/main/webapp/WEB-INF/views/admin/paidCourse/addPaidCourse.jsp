<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/bai-hoc-tra-phi/danh-sach"/>
<c:url var="editURL" value="/quan-tri/bai-hoc-tra-phi/chinh-sua"/>
<c:url var ="NewAPI" value="/api/paidcourse"/>


<!DOCTYPE html> 
<html> 
<head> 
<title> Java File Upload Servlet Example </title> 
</head> 
<body>
<hr><h1>Thêm mới Paid-Course:</h1>

  <form method="post" action="<c:url value='/quan-tri/bai-hoc-tra-phi/chinh-sua'/>" enctype="multipart/form-data">
<!--  start a unit -->
  <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">name</label>
        <div class="col-sm-9">
  			<div><input type="text" name="name"  placeholder="Course Name" /></div>
        </div>
  </div>
<!--   end a unit -->
<!--  start a unit -->
  <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">description</label>
        <div class="col-sm-9">
 			 <div> <input type="text" name="description"  placeholder="Course description" /></div>
        </div>
  </div>
<!--   end a unit -->
<!--  start a unit -->
  <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">description</label>
        <div class="col-sm-9">
 			 <div><h4>Video: </h4><input type="file" name="file"/></div>
        </div>
  </div>
<!--   end a unit -->
  <div> <input type="text" name="shortdescription"   placeholder="Course shortdescription" /></div>
  <div>  <input type="text" name="topic"  placeholder="Course topic"  />
  <input type="text" name="thumbnail" placeholder="Course tothumbnailpic" /></div>
  <input type="submit" value="Upload" />
  </form>
<hr>


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
						<hr><h1>Chỉnh sửa Paid-Course:</h1>
						
                        <form:form id="formSubmit" modelAttribute="model" role="form" enctype="multipart/form-data">                        
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">s3Path</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="s3Path" name="s3Path" value="${model.s3Path}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">thumbnail</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="thumbnail" name="thumbnail" value="${model.thumbnail}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">topic</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="topic" name="topic" style="width: 820px;height: 175px">${model.topic}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">id</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="id" name="id" style="width: 820px;height: 175px">${model.id}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">sentiment</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="sentiment" name="sentiment" style="width: 820px;height: 175px">${model.sentiment}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <form:form  path="id" id="paidcourseid"/>
                            
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
            console.log(v.value);
            console.log("/");

        });
//         data["content"] = editor.getData();
        var id = $('#paidcourseid').val();
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
            url: '${quan-tri/bai-hoc-tra-phi/danh-sach}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editURL}?page=1&limit=5?id=" +result.id +"&message=insert_success";
            	//?type=edit&id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?page=1&limit=5"+"&message=error_system";
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
            	window.location.href = "${editURL}?page=1&limit=5?id=" +result.id+"&message=update_success";
            	//?type=edit&id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?page=1&limit=5"+"&message=error_system";
            	//?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>