<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import= "com.xuantujava.util.SecurityUtils" %>
<c:url var ="userName" value="<%= SecurityUtils.getPrincipal().getFullName() %>"/>


<!DOCTYPE html>
<html>
<head>
</head>
<body>

<form method="post" action="<c:url value='/quan-tri/chat'/>" enctype="multipart/form-data">
					<!--  start a unit -->
					  <div class="form-group">
					        <label class="col-sm-3 control-label no-padding-right">name</label>
					        <div class="col-sm-9">
					  			<input type="text" name="linkvideo" class="form-control"  placeholder="linkvideo" />
					        </div>
					  </div>        
			
					  <input type="submit" value="Create New livestym" />
					  </form>	

</body>
</html>